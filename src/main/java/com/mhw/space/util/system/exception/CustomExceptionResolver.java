package com.mhw.space.util.system.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.mhw.space.util.common.CommonResp;
import com.mhw.space.util.system.validate.ValidateException;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ex.printStackTrace();
		// 校验失败
		if(ex instanceof ValidateException) {
			return resolveValidateException(response ,(ValidateException)ex);
		}else {
			String requestedWith = request.getHeader("x-requested-with");
			if(requestedWith == null) {
				
			}else {
				return getAjaxReturn(response, 500, ex.getMessage());
			}
		}
		
		return new ModelAndView();
	}
	
	private ModelAndView resolveValidateException(HttpServletResponse response, ValidateException ex) {
        return getAjaxReturn(response, ex.getErrorCode(), ex.getErrorMsg());
	}

	private ModelAndView getAjaxReturn(HttpServletResponse response, int errorCode, String errormSG) {
		ModelAndView mv = new ModelAndView();
		/*	使用response返回	*/
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
        		CommonResp resp = new CommonResp(errorCode, errormSG);
            response.getWriter().write(JSONObject.toJSONString(resp));
        } catch (IOException e) {
           //log.error("与客户端通讯异常:"+ e.getMessage(), e);
        }
        
        return mv;
	}
}
