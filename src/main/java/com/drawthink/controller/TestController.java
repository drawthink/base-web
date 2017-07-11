package com.drawthink.controller;

import com.drawthink.common.exception.BusinessException;
import com.drawthink.common.exception.ErrorCode;
import com.drawthink.entity.Student;
import com.drawthink.services.StudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**   
* @author drawthink   
* @date 2017年7月10日  
* @Description: 测试
*/
@Controller
public class TestController {
	
	@Autowired
	StudentService stuService;

	/**
	 * 对自定义异常的测试
	 * @return
	 */
	@RequestMapping("/exception")
	@ResponseBody
	public String getRes(){
		throw new BusinessException(ErrorCode.LOGIN_PD_ERROR_CODE);
	}
	
	//produces = "text/json;charset=UTF-8"  解决controller返回中文乱码
	@RequestMapping(value="/getname",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	@ResponseBody
	protected String getDevice(@RequestParam String stu_id) throws Exception {
		return stuService.queryStudentNameById(stu_id);
	}

	@RequestMapping(value="/getall",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	@ResponseBody
	protected ModelAndView queryAll() throws Exception {
//		String res = new Gson().toJson().toString();
		List<Student> list = stuService.queryAllStudent();
		return new ModelAndView("test", "list", list);
	}
}

