/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件<br/>
 * @author 徐建军
 * @date 2014-1-20
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;

import com.icinfo.creditinfo.bean.biz.entappcon.EntAppConInfo;
import com.icinfo.creditinfo.lucence.common.AppConInfo;
import com.icinfo.creditinfo.lucence.common.NameResponse;
import com.icinfo.creditinfo.lucence.core.ObjectConversion;
import com.icinfo.creditinfo.lucence.core.SearchEngineCore;
import com.icinfo.creditinfo.lucence.core.SearchObject;
import com.icinfo.creditinfo.service.biz.entappcon.EntAppConService;
import com.icinfo.creditinfo.service.search.AppSearchService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.ProUtil;

/**
 * 描述: 企业信息查询<br>
 * 
 * @author 徐建军
 * @date 2014-1-20
 */
public class AppSearchServiceImpl implements AppSearchService {

	private EntAppConService entAppConService;

	/**
	 * 描述: 创建index
	 * 
	 * @author gqf
	 * @date 2015年10月14日
	 * @param baseIndexPath
	 * @throws Exception
	 */
	@Override
	public void doCreateIndex(String baseIndexPath) throws Exception {
		List<EntAppConInfo> entAppConInfoList = entAppConService
				.doGetEntAppConInfoListForIndex(null);
		if (entAppConInfoList != null && entAppConInfoList.size() > 0) {
			doSaveEntIndexFromList(entAppConInfoList,
					baseIndexPath + ProUtil.getENTINDEX_PATH());
		}
	}

	/**
	 * 描述: 把ENT列表中数据保存为索引文档
	 * 
	 * @author 朱勇
	 * @date 2015-01-23
	 * @param entAppConInfoList
	 *            数据
	 * @param indexPath
	 *            索引地址
	 * @throws Exception
	 */
	private void doSaveEntIndexFromList(List<EntAppConInfo> entAppConInfoList,
			String indexPath) throws Exception {
		Directory directory = SearchEngineCore.getDirectory(indexPath);
		IndexWriter indexWriter = SearchEngineCore.getIndexWriter(directory);
		for (EntAppConInfo entAppConInfo : entAppConInfoList) {
			try {// 生成document文档
				Document document = getDocument(getEntAppConInfoMap(entAppConInfo));
				indexWriter.addDocument(document);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		closeAll(indexWriter);
		directory.close();
	}
	
	/**
	 * 描述: 根据数据生成Document
	 * 
	 * @author 朱勇
	 * @date 2015-01-26
	 * @param map
	 * 企业核准内容信息
	 * @return Document
	 */
	private Document getDocument(Map<String, String> map) {
		// 生成document文档
		return ObjectConversion.convertContentToDoc(map);
	}
	
	/**
	 * 描述: 将entAppConInfo对象转换为索引需要的Map数据
	 * 
	 * @author 朱勇
	 * @date 2015-01-26
	 * @param entAppConInfo
	 * @return Map<String,String>
	 * @throws Exception
	 */
	private Map<String, String> getEntAppConInfoMap(EntAppConInfo entAppConInfo)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("corpid",   StringUtils.trimToEmpty(entAppConInfo.getCorpid()));
		map.put("entname",  StringUtils.trimToEmpty(entAppConInfo.getAppConEntName()));
		map.put("regno",    StringUtils.trimToEmpty(entAppConInfo.getAppConRegNo()));
		map.put("legrep",   StringUtils.trimToEmpty(entAppConInfo.getAppConLegRep()));
		map.put("estdate",  StringUtils.trimToEmpty(entAppConInfo.getEntEstDateStr()));
		map.put("regloc",   StringUtils.trimToEmpty(entAppConInfo.getAppConLoc()));
		map.put("unscid",	StringUtils.trimToEmpty(entAppConInfo.getEntUnscId()));
		map.put("taxregno",	StringUtils.trimToEmpty(entAppConInfo.getEntTaxRegNo()));
		map.put("orgno",	StringUtils.trimToEmpty(entAppConInfo.getEntOrgRegNo()));
		return map;
	}

	/**
	 * 描述: 获取查询结果
	 * 
	 * @author 朱勇
	 * @date 2015-10-19
	 * @throws Exception
	 */
	public NameResponse doGetAppConInfoResult(String sc,String searchType,
			String path, int pageSize, int currentPage, int resultSize)
			throws Exception {
		NameResponse nameResponse = new NameResponse();
		// 构建索引查询对象
		IndexSearcher indexSearcher = new IndexSearcher(SearchObject
				.getInstance().getSearcherRead());
		// 排序
		Sort sort = new Sort(new SortField("entname", SortField.Type.STRING));
		// TopDocs 搜索返回的结果，只返回前resultSize条记录
		TopDocs topDocs = indexSearcher.search(assembleQuery(sc,searchType),
				resultSize, sort);
		// 搜索结果总数量
		int totalCount = topDocs.totalHits;
		// 搜索的结果集合
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		// 查询起始记录位置
		int begin = pageSize * (currentPage - 1);
		// 查询终止记录位置
		int end = Math.min(begin + pageSize, scoreDocs.length);

		List<AppConInfo> appConInfoList = new ArrayList<AppConInfo>();
		// 进行分页查询
		for (int i = begin; i < end; i++) {
			int docID = scoreDocs[i].doc;
			Document doc = indexSearcher.doc(docID);
			AppConInfo appConInfo = new AppConInfo();
			appConInfo.setCorpid(AESEUtil.encryptContext(doc.get("corpid")));
			appConInfo.setName(doc.get("entname"));
			appConInfo.setRegno(doc.get("regno"));
			appConInfo.setLegrep(doc.get("legrep"));
			appConInfo.setEstdate(doc.get("estdate").substring(0, 10));
			appConInfo.setRegloc(doc.get("regloc"));
			appConInfoList.add(appConInfo);
		}
		nameResponse.setTotalCount(totalCount);

		Collections.sort(appConInfoList, new Comparator<AppConInfo>() {
			public int compare(AppConInfo arg0, AppConInfo arg1) {
				int i = arg0.getName().length();
				int j = arg1.getName().length();
				if (i == j) {
					return arg1.getEstdate().compareTo(arg0.getEstdate());
				} else if (i > j) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		nameResponse.setAppConInfoList(appConInfoList);
		return nameResponse;
	}

	/**
	 * 描述：创建查询解析器
	 * 
	 * @author zhuyong
	 * @date 2015-10-19
	 * @return
	 */
	private BooleanQuery assembleQuery(String sc,String searchType) {
		// 创建查询解析器(实现对多Field查询),并将查询关键词解析成Lucene的Query对象,最终构建查询逻辑
		BooleanQuery booleanQuery = new BooleanQuery();
		// 企业名称/注册号等查询
		if (StringUtils.isBlank(sc)) {
			return booleanQuery;
		}
		if(searchType.equals("")){
			Query nameQuery = new WildcardQuery(new Term("entname", "*" + sc + "*"));
			booleanQuery.add(nameQuery, BooleanClause.Occur.SHOULD);
			Query regnoQuery = new WildcardQuery(new Term("regno", "*" + sc + "*"));
			booleanQuery.add(regnoQuery, BooleanClause.Occur.SHOULD);
			Query unscidQuery = new WildcardQuery(new Term("unscid", "*" + sc + "*" ));
			booleanQuery.add(unscidQuery, BooleanClause.Occur.SHOULD);
			Query taxregnoQuery = new WildcardQuery(new Term("taxregno", "*" + sc + "*"));
			booleanQuery.add(taxregnoQuery, BooleanClause.Occur.SHOULD);
			Query orgnoQuery = new WildcardQuery(new Term("orgno",  "*" + sc + "*"));
			booleanQuery.add(orgnoQuery, BooleanClause.Occur.SHOULD);
		}else{
			Query nameQuery = new WildcardQuery(new Term("entname", "*" + sc + "*"));
			booleanQuery.add(nameQuery, BooleanClause.Occur.SHOULD);
		}
		return booleanQuery;
	}

	private void closeAll(IndexWriter indexWriter) throws IOException {
		// 提交
		SearchEngineCore.commitIndex(indexWriter);
		// 关闭
		SearchEngineCore.closeIndexWriter(indexWriter);
	}

	public EntAppConService getEntAppConService() {
		return entAppConService;
	}

	public void setEntAppConService(EntAppConService entAppConService) {
		this.entAppConService = entAppConService;
	}

	
	
}
