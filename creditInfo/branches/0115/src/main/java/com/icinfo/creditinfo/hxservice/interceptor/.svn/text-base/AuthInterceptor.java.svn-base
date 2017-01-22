package com.icinfo.creditinfo.hxservice.interceptor;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private  static  final Log  logger = LogFactory.getLog(AuthInterceptor.class);

    private static final String DEPTCODE = "33068201";

    //private static final String HEADERS = "sy:serviceHeader";
    
    private static final String USERPWD = "95270608";
    
	public AuthInterceptor() {
		 super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		 logger.info("接口验证开始....");
		 
		 List<Header> headers = soapMessage.getHeaders();
		 System.out.println("f::"+headers.size());
		 Header header = headers.get(0);
		 //String localPart = header.getName().getLocalPart();  
	     Element el = (Element) header.getObject();
	     System.out.println("nodeName:"+el.getNodeName());
//	     if (!HEADERS.equals(el.getNodeName())) {
//	            throw new Fault(new IllegalArgumentException(" 请求信息中设置头部信息错误"));
//	        }
	     NodeList deptCodeNodes = el.getElementsByTagName("deptCode");
	     String deptCodeValue = deptCodeNodes.item(0).getTextContent().trim();
	     if(!DEPTCODE.equals(deptCodeValue)){
	    	 throw new Fault(new IllegalArgumentException(" 请求信息中设置头部信息错误--部门编码错误！"));
	     }
//	     NodeList userNameNodes = el.getElementsByTagName("userName");
//	     String userNameValue = userNameNodes.item(0).getTextContent().trim();
//	     if(!USERNAME.equals(userNameValue)){
//	    	 throw new Fault(new IllegalArgumentException(" 请求信息中设置头部信息错误--用户名错误！"));
//	     }
	     NodeList PwdNodes = el.getElementsByTagName("userPwd");
	     String pwdValue = PwdNodes.item(0).getTextContent().trim();
	     if(!USERPWD.equals(pwdValue)){
	    	 throw new Fault(new IllegalArgumentException(" 请求信息中设置头部信息错误--验证密码错误！"));
	     }
	     logger.info("验证通过："+"deptcode:"+deptCodeValue+" pwd:"+pwdValue);
	}

}
