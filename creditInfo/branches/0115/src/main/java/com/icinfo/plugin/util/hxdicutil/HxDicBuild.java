package com.icinfo.plugin.util.hxdicutil;
/**
 * desc: user method :			 	 run main program
 * 		 support database :		 	 mysql
 * 		 export excel location :	 D:\HXDIC\filename.xls
 * 
 * @author zhuyong
 */
public class HxDicBuild {
	public static void main(String[] args) {
		System.out.println("excel build start ... ");
		ExcelUtil.runExe();
		System.out.println("excel build end ... ");
	}
}
