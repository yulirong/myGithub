package com.icinfo.creditinfo.lucence.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.plugin.common.ProUtil;

public class PathUtil {
	/**
	 * 描述: 获取WEB项目下的WEB-INF目录
	 * 
	 * @author 徐建军
	 * @date 2013-9-26
	 * @return String
	 */
	public String getWebInfPath() {
		URL url = getClass().getProtectionDomain().getCodeSource()
				.getLocation();
		String path = url.toString();
		int index = path.indexOf("WEB-INF");

		if (index == -1) {
			index = path.indexOf("classes");
		}

		if (index == -1) {
			index = path.indexOf("bin");
		}

		path = path.substring(0, index);

		if (path.startsWith("zip")) {// 当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		} else if (path.startsWith("file")) {// 当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(6);
		} else if (path.startsWith("jar")) {// 当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(10);
		}
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return path;
	}

	/**
	 * 描述: 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @author 徐建军
	 * @date 2013-9-30
	 * @param sPath 要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false
	 */
	public static boolean DeleteFolder(String sPath) {
		boolean flag = true;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 描述: 删除单个文件
	 * 
	 * @author 徐建军
	 * @date 2013-9-30
	 * @param sPath 被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 描述: 删除目录（文件夹）以及目录下的文件
	 * 
	 * @author 徐建军
	 * @date 2013-9-30
	 * @param sPath 被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		/*// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}*/
		return true;
	}
	
	/** 
	 * 描述: 获取真正生成索引地址
	 * @author 徐建军
	 * @date 2014-6-13 
	 * @return 
	 */
	public static String getRealIndexPath(){
	    Calendar rightNow = Calendar.getInstance();
        String[] data = rightNow.getTime().toString().split(" ");
        int day = Integer.parseInt(data[2].toString());
        if(day % 2 == 0)
        	return ProUtil.getROOTINDEX_PATH_EVEN();
        else
        	return ProUtil.getROOTINDEX_PATH_ODD();
	}
	
	/** 
	 * 描述: 获取真正查询索引地址
	 * @author 徐建军
	 * @date 2014-6-13 
	 * @return 
	 */
	public static String getRealSearchIndexPath(){
		String indexPath = getRealIndexPath();
		if(StringUtils.isNotBlank(indexPath)){
			boolean ent = emptyFile(indexPath+ProUtil.getENTINDEX_PATH());
//			boolean alter = emptyFile(indexPath+ProUtil.getALTERINDEX_PATH());
			if(ent){
				if(ProUtil.getROOTINDEX_PATH_EVEN().equals(indexPath)){
					return ProUtil.getROOTINDEX_PATH_ODD();
				}else{
					return ProUtil.getROOTINDEX_PATH_EVEN();
				}
			}else{
				return indexPath;
			}
			
		}
		return null;
	}
	
	/** 
	 * 描述: 获取真正生成索引地址
	 * @author 徐建军
	 * @date 2014-6-13 
	 * @return 
	 */
	public static String getRealCreateIndexPath(){
		String indexPath = getRealIndexPath();
		if(StringUtils.isNotBlank(indexPath)){
			if(ProUtil.getROOTINDEX_PATH_EVEN().equals(indexPath)){
				indexPath = ProUtil.getROOTINDEX_PATH_ODD();
			}else{
				indexPath = ProUtil.getROOTINDEX_PATH_EVEN();
			}
			
			boolean ent = emptyFile(indexPath+ProUtil.getENTINDEX_PATH());
//			boolean alter = emptyFile(indexPath+ProUtil.getALTERINDEX_PATH());
			if(ent){
				return indexPath;
			}else{
				if(ProUtil.getROOTINDEX_PATH_EVEN().equals(indexPath)){
					return ProUtil.getROOTINDEX_PATH_ODD();
				}else{
					return ProUtil.getROOTINDEX_PATH_EVEN();
				}
			}
			
		}
		return null;
	}
	
	/** 
	 * 描述: 判断文件夹是否为空或者不存在
	 * @author 徐建军
	 * @date 2014-6-13 
	 * @return 文件夹为空或者不存在时返回true，文件夹不为空时返回false
	 */
	public static boolean emptyFile(String file) {
		try {
			return 0 == new File(file).listFiles().length ? true : false;
		} catch (RuntimeException e) {
			return true;
		}
	}
	
}
