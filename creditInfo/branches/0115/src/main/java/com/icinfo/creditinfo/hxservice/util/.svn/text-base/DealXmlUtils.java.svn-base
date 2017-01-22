package com.icinfo.creditinfo.hxservice.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/** 
 * 描述: xml处理类
 * @author gqf
 * @date 2015年12月29日  
 */
public class DealXmlUtils {
	 private static final Log LOG = LogFactory.getLog(DealXmlUtils.class);
	 /** 
	 * 描述: 组装xml
	 * @auther gqf
	 * @date 2015年12月29日 
	 * @param t
	 * @param clazz
	 * @param headerFlag
	 * @param encoding
	 * @return 
	 */
	public static <T> String toRequestXml(T t,Class<T> clazz,boolean headerFlag, String encoding){
		 try {
	            JAXBContext context = JAXBContext.newInstance(clazz);
	            Marshaller marshaller = context.createMarshaller();
	            StringWriter sw = new StringWriter();
	            if (!headerFlag) { // xml是否需要head
	                marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
	            }
	            if (encoding != null && !"".equals(encoding)) { // 默认的encoding 是UTF-8
	                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
	            }
	            marshaller.marshal(t, sw);
	            return sw.toString();
	        } catch (Exception e) {
	            LOG.error("toRequestXML 异常", e);
	            return null;
	        }
	}
	
	
	/** 
	 * 描述: 把xml转换为obj
	 * @auther gqf
	 * @date 2015年12月31日 
	 * @param clazz
	 * @param xml
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toResponseObject(Class<T> clazz, String xml) {
	        try {
	            if (StringUtils.isEmpty(xml)) {
	                return null;
	            }
	            JAXBContext context = JAXBContext.newInstance(clazz);
	            Unmarshaller unMarshaller = context.createUnmarshaller();
	            return (T) unMarshaller.unmarshal(new StringReader(xml));
	        } catch (Exception e) {
	            LOG.error("toResponseObject 异常", e);
	            return null;
	        }
	    }


}
