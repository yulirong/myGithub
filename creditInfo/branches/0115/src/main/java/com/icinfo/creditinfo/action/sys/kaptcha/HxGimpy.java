/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 验证码文件 <br/>
 * @author zhuyong
 * @date 2016-01-06
 * @version 1.0
 */
package com.icinfo.creditinfo.action.sys.kaptcha;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;
import com.jhlabs.image.RippleFilter;
import com.jhlabs.image.TransformFilter;
import com.jhlabs.image.WaterFilter;

/** 
 * 描述: 实现验证码自定义样式引擎<br>
 * 
 * @author zhuyong
 * @date 2016-01-06  
 */
public class HxGimpy extends Configurable implements GimpyEngine
{
	  public BufferedImage getDistortedImage(BufferedImage baseImage)
	  {
			NoiseProducer noiseProducer = getConfig().getNoiseImpl();
			BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(),
					baseImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Graphics2D graphics = (Graphics2D) distortedImage.getGraphics();

			RippleFilter rippleFilter = new RippleFilter();
			rippleFilter.setWaveType(RippleFilter.SINE);
			rippleFilter.setXAmplitude(2.6f);
			rippleFilter.setYAmplitude(1.7f);
			rippleFilter.setXWavelength(15);
			rippleFilter.setYWavelength(5);
			rippleFilter.setEdgeAction(TransformFilter.NEAREST_NEIGHBOUR);

			WaterFilter waterFilter = new WaterFilter();
			//waterFilter.setAmplitude(1.5f);
			waterFilter.setAmplitude(0f); 
			waterFilter.setPhase(10);
			waterFilter.setWavelength(1);

			BufferedImage effectImage = waterFilter.filter(baseImage, null);
			effectImage = rippleFilter.filter(effectImage, null);

			graphics.drawImage(effectImage, 0, 0, null, null);

			graphics.dispose();

			noiseProducer.makeNoise(distortedImage, .1f, .1f, .25f, .25f);
			noiseProducer.makeNoise(distortedImage, .1f, .25f, .5f, .9f);
			return distortedImage;
	  }
}
