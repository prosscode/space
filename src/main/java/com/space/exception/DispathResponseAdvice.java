package com.space.exception;

import java.io.File;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @describe:统一结果返回
 * @author:郑锴 kayle.zheng@huolala.cn
 * @date:2018年8月17日 下午7:29:57
 */
//@ControllerAdvice
public class DispathResponseAdvice implements ResponseBodyAdvice<Object>{

	public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass) {
		return MappingJackson2HttpMessageConverter.class.isAssignableFrom(paramClass);
	}

	public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType paramMediaType,
			Class<? extends HttpMessageConverter<?>> paramClass, ServerHttpRequest request,
			ServerHttpResponse reponse) {
		if(body instanceof ActionResult || body instanceof String) {
			return body;
		}else if(body instanceof File) {
			return body;
		}else if(body instanceof PageEntity || body instanceof PageEntity){
			if(body instanceof PageEntity) {
				PageEntity pageEntity = null;
				pageEntity = (PageEntity)body;
				ActionResult result = new ActionResult();
				result.setRet(0);
				result.setMsg("");
				result.setData(pageEntity.getList());
				result.setCount(pageEntity.getCount());
				return result;
			}
			
			if(body instanceof PageEntity) {
				PageEntity pageEntity = null;
				pageEntity = (PageEntity)body;
				ActionResult result = new ActionResult();
				result.setRet(0);
				result.setMsg("");
				result.setData(pageEntity.getList());
				result.setCount(pageEntity.getCount());
				return result;
			}
			
			return null;
		}else {
			ActionResult result = new ActionResult();
			result.setRet(0);
			result.setMsg("");
			result.setData(body);
			return result;
		}
		
	}

}
