package com.space.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    @ResponseBody
    public ActionResult handleAndReturnData(HttpServletRequest request, HttpServletResponse response, Exception ex) {
    		ActionResult result = new ActionResult();
    		result.setMsg(ex.getMessage());
    		result.setRet(-1);
    		result.setData(null);
    		logger.error(ex.getMessage());
    		
        return result;
    }
}
