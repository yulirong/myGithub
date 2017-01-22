package com.icinfo.creditinfo.hxservice.util;
import java.lang.reflect.Method;

public class BeanUtil {
	
	 /** 
	 * 描述: 两个bean复制
	 * @auther gqf
	 * @date 2015年12月29日 
	 * @param obj1
	 * @param obj2
	 * @return
	 * @throws Exception 
	 */

	public static Object CopyBeanToBean(Object fromObj, Object tarObj)
			throws Exception {
		Method[] method1 = fromObj.getClass().getMethods();
		Method[] method2 = tarObj.getClass().getMethods();
		String methodName1;
		String methodFix1;
		String methodName2;
		String methodFix2;
		//Class fromClz = fromObj.getClass();  
	    //Class tarClz = tarObj.getClass();  
		for (int i = 0; i < method1.length; i++) {
			methodName1 = method1[i].getName();
			methodFix1 = methodName1.substring(3, methodName1.length());
			if (methodName1.startsWith("get")) {
				for (int j = 0; j < method2.length; j++) {
					methodName2 = method2[j].getName();
					methodFix2 = methodName2.substring(3, methodName2.length());
					if (methodName2.startsWith("set")) {
						if (methodFix2.equals(methodFix1)) {
							Object[] objs1 = new Object[0];
							Object[] objs2 = new Object[1];
							objs2[0] = method1[i].invoke(fromObj, objs1);// 激活obj1的相应的get的方法，objs1数组存放调用该方法的参数,此例中没有参数，该数组的长度为0
							method2[j].invoke(tarObj, objs2);// 激活obj2的相应的set的方法，objs2数组存放调用该方法的参数
							continue;
						}
					}
				}
			}
		}
		return tarObj;
	}
	
	
	

}
