package com.cn.ask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sdf {
	@Bean
	public com.google.code.kaptcha.impl.DefaultKaptcha getKaptcha(){
		com.google.code.kaptcha.impl.DefaultKaptcha dk=new com.google.code.kaptcha.impl.DefaultKaptcha();
		java.util.Properties properties=new java.util.Properties();
		properties.put("kaptcha.border", "no");
		properties.put("kaptcha.border.color", "105,179,90");
		properties.put("kaptcha.textproducer.font.color", "blue");
		properties.put("kaptcha.textproducer.font.size", "85");
		properties.put("kaptcha.image.width", "250");
		properties.put("kaptcha.image.height", "90");
		properties.put("kaptcha.session.key", "code");
		properties.put("kaptcha.textproducer.char.length", "4");
		properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		/**
		 * <prop key="kaptcha.border">no</prop>
                        <prop key="kaptcha.border.color">105,179,90</prop>
                        <prop key="kaptcha.textproducer.font.color">blue</prop>
                        <prop key="kaptcha.textproducer.font.size">85</prop>
                        <prop key="kaptcha.image.width">250</prop>
                        <prop key="kaptcha.image.height">90</prop>
                        <prop key="kaptcha.session.key">code</prop>
                        <prop key="kaptcha.textproducer.char.length">4</prop>
                        <prop key="kaptcha.textproducer.font.names">宋体,楷体,微软雅黑</prop>
		 */
		com.google.code.kaptcha.util.Config config=new com.google.code.kaptcha.util.Config(properties);
		dk.setConfig(config);
		return dk;
	}
}
