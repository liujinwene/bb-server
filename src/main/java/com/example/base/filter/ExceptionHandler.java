package com.example.base.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.example.base.RestResp;
import com.example.base.RestRunningException;
import com.example.base.utils.JsonUtil;

public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exception) {
		exception.printStackTrace();
		RestResp resp = new RestResp("额,不知道哪里又错了!");

		if(exception instanceof RestRunningException) {
			RestRunningException excep = (RestRunningException) exception;
			resp = new RestResp(excep.getScope(), excep.getStatus(), excep.getErrorMsg());
		}

		try {
			response.setStatus(HttpStatus.SC_OK);
			response.getOutputStream().write(JsonUtil.toJsonString(resp).getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}

}
