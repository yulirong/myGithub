package com.icinfo.plugin.util.hxdicutil;

import java.util.Enumeration;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * desc:read properties
 * 
 * @author zhuyong
 */
public class PropertiesUtil {

	public static Properties property = null;
	public static Properties springProperty = null;

	public static String getProperty(String key){
        if (property == null) {
        	try
        	{
                property = getLoadProperties("hxdicbuild");
        	}
        	catch(Exception er){
        		 System.out.println("no hxdicbuild.property");
        	}
        }

        if(property.get(key)==null){
        	if(key!=null && ( key.equals("layerPath") || key.equals("removeColumnPre") || key.equals("tableDescribe")|| key.equals("isCoverOldFile") || key.equals("dbType") ) ){
        		return "";
        	}
        	else{
        		System.out.println("key:" + key );
        	    return null;
        	}
        }
        else{
        	return property.get(key).toString().trim();
        }
	}
	
	public static String getSpringProperty(String key){
        if(null == springProperty){
        	try{
        	    springProperty = getLoadProperties("entry.dev.spring");
        	}
        	catch(Exception ex){
        		return getProperty(key);
        	}
        }
        if(springProperty.get(key)==null){
        	return null;
        }
        return springProperty.get(key).toString();
	}
	
    public static Properties getLoadProperties(String propertyFileName) {
        Properties prop = new Properties();
        if (propertyFileName == null) {
            return null;
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyFileName);
        Enumeration<?> enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();
            prop.put(key, resourceBundle.getObject((String)key));
        }
        return prop;

    }
}
