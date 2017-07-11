package com.drawthink.common.exception;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
* @author drawthink   
* @date 2017年7月10日  
* @Description: TODO(用一句话描述该文件做什么) 
*/

public class DtHandlerExceptionResolver implements HandlerExceptionResolver {
	
	@Override
	 public ModelAndView resolveException(HttpServletRequest request,
	            HttpServletResponse response, Object object, Exception exception) {
	        // 判断是否ajax请求
	        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
	                .getHeader("X-Requested-With") != null && request.getHeader(
	                "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
	            // 如果不是ajax，JSP格式返回
	            // 为安全起见，只有业务异常我们对前端可见，否则否则统一归为系统异常
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("success", false);
	            if (exception instanceof BusinessException) {
	                map.put("errorMsg", exception.getMessage());
	            } else {
	                map.put("errorMsg", "系统异常！");
	            }
	            //这里需要手动将异常打印出来，由于没有配置log，实际生产环境应该打印到log里面
	            exception.printStackTrace();
	            //对于非ajax请求，我们都统一跳转到error.jsp页面
	            return new ModelAndView("/error", map);
	        } else {
	            // 如果是ajax请求，JSON格式返回
	            try {
	                response.setContentType("application/json;charset=UTF-8");
	                PrintWriter writer = response.getWriter();
	                Map<String, Object> map = new HashMap<String, Object>();
	                map.put("success", false);
	                // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
	                if (exception instanceof BusinessException) {
	                    map.put("errorMsg", exception.getMessage());
	                } else {
	                    map.put("errorMsg", "系统异常！");
	                }
	                writer.write(new JSONObject().fromObject(map).toString());
	                writer.flush();
	                writer.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	    }

}

