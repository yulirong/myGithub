package com.icinfo.creditinfo.action.sys.kaptcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.icinfo.creditinfo.action.HxBaseAction;

/** 
 * 描述: google 验证码 
 * 
 * @author zhuyong
 * @date 2016-1-6  
 */
public class KaptchaAction extends HxBaseAction {

	private static final long serialVersionUID = 1L;
	//kaptcha 提供的生产类
	private Producer captchaProducer = null;

	/**
	 * 描述: 生成验证码
	 * 
	 * @author zhuyong
	 * @date 2016-1-6
	 * @return
	 */
    public String doReadKaptchaAction() {
    	try
    	{
    		doGetResponse().setDateHeader("Expires", 0);     
    		doGetResponse().setHeader("Cache-Control", "no-store, no-cache, must-revalidate");    
    		doGetResponse().addHeader("Cache-Control", "post-check=0, pre-check=0");    
    		doGetResponse().setHeader("Pragma", "no-cache");    
    		doGetResponse().setContentType("image/jpeg");    
            String capText = captchaProducer.createText();    
            doSetSession(Constants.KAPTCHA_SESSION_KEY, capText);    
            BufferedImage bi = captchaProducer.createImage(capText);    
            ServletOutputStream out = doGetResponse().getOutputStream();    
            ImageIO.write(bi, "jpg", out);
            try{    
              out.flush();
            }finally{    
              out.close();
            }
    	}catch(IOException er){
    		
    	}
    	return null;
    }  
    
    
	public Producer getCaptchaProducer()
	{
		return captchaProducer;
	}

	public void setCaptchaProducer(Producer captchaProducer)
	{
		this.captchaProducer = captchaProducer;
	}  
	
	
	
	

}
