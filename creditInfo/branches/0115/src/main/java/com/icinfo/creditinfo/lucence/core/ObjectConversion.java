/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 对象转换
 * @author 徐建军
 * @date 2014-1-20
 * @version 1.0
 */
package com.icinfo.creditinfo.lucence.core;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.plugin.common.HxDateUtil;

/**
 * 描述: 对象转换
 * 
 * @author 徐建军
 * @date 2014-1-20
 */
public class ObjectConversion {

	/**
	 * 描述: 转换内容对象为Document对象(业务数据)
	 * 
	 * @author 朱勇
	 * @date 2015-01-26
	 * @param map
	 * @return Document
	 */
	public static Document convertContentToDoc(Map<String, String> map) {
		Document document = new Document();
		for (String key : map.keySet()) {
			document.add(new StringField(key, map.get(key), Field.Store.YES));
		}
		return document;
	}

}
