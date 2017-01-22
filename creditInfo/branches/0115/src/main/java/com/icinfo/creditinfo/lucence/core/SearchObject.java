/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 搜索核心代码
 * @author 徐建军
 * @date 2013-8-15
 * @version 1.0
 */
package com.icinfo.creditinfo.lucence.core;

import java.io.IOException;
import java.util.Date;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;

import com.icinfo.creditinfo.lucence.common.PathUtil;
import com.icinfo.plugin.common.DateUtil;
import com.icinfo.plugin.common.ProUtil;

/**
 * 描述: 搜索核心代码
 * 
 * @author 徐建军
 * @date 2013-8-15
 */
public class SearchObject {
	
	private static Date date = new Date();
	// 声明一个IndexReader对象
	private static IndexReader indexReader = null;
	// 声明一个IndexSearcher对象
	private static IndexSearcher indexSearcher = null;
	
	private static SearchObject instance;
	
    /** 
     * 描述: 初始化对象
     * @author 徐建军
     * @date 2014-10-28 
     * @return 
     */
    public static SearchObject getInstance(){
		String changeTime = DateUtil.getCurrentSimpleTime();
		if(changeTime!=null && changeTime.length()>2){
			changeTime = changeTime.substring(0,5);
		}
        if(instance==null||"24:24".equals(changeTime)||"05:24".equals(changeTime)){
            init();
            instance = new SearchObject();
        }
        return instance;
    }
    
    /** 
     * 描述: 创建Lucene索引对象
     * @author 徐建军
     * @date 2014-10-28  
     */
    public static void init(){
        try{
			String rootPath = PathUtil.getRealSearchIndexPath();
			String entIndexPath = ProUtil.ENTINDEX_PATH;
			Directory directory = SearchEngineCore.getDirectory(rootPath+entIndexPath);
			indexReader = SearchEngineCore.getIndexReader(directory);
			indexSearcher = new IndexSearcher(indexReader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	/**
	 * 描述: 取得多索引查询对象
	 * 
	 * @author 徐建军
	 * @date 2013-8-27
	 * @param strings 索引目录
	 * @return IndexReader[]
	 * @throws IOException
	 */
	public static IndexReader[] getIndexReaders(String... strings)
			throws IOException {
		int iSize = strings.length;
		IndexReader[] indexReaders = new IndexReader[iSize];

		int i = 0;
		for (String indexPath : strings) {
			indexReaders[i] = DirectoryReader.open(SearchEngineCore
					.getDirectory(indexPath));
			i++;
		}

		return indexReaders;
	}
	
    /** 
     * 描述: 取得查询对象
     * @author 徐建军
     * @date 2014-10-28 
     * @return 
     */
    public  IndexSearcher getSearcher(){
        if(indexSearcher==null){
        	 init();
        }
        return indexSearcher;
    }

    /** 
     * 描述: 取得查询对象Reader
     * @author 徐建军
     * @date 2014-10-28 
     * @return 
     */
    public  IndexReader getSearcherRead(){
        if(indexReader==null){
        	init();
        }
        return indexReader;
    }

}
