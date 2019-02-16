package com.space.exception;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHelper implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext(){  
        return applicationContext;  
    }  
      
    /**  
     * 这是一个便利的方法，帮助我们快速得到一个BEAN  
     * @param beanName bean的名字  
     * @return 返回一个bean对象  
     * @author wangdf 
     */    
    public static Object getBean( String beanName ) {    
        return applicationContext.getBean( beanName );    
    }   
}
