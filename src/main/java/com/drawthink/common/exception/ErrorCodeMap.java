package com.drawthink.common.exception;

import java.util.HashMap;
import java.util.Map;

/**   
* @author drawthink   
* @date 2017年7月10日  
* @Description: 封装错误信息为map
*/
public class ErrorCodeMap {
	private static Map<String,String> errorMap;
	
	static{
		errorMap = new HashMap<>();
		errorMap.put(ErrorCode.DATA_ERROR_CODE, ErrorCode.DATA_ERROR_MSG);
		errorMap.put(ErrorCode.LOGIN_PD_ERROR_CODE, ErrorCode.LOGIN_PD_ERROR_MSG);
	}

	public static String getErrorMsg(String errorCode){
		if(errorMap.containsKey(errorCode)){
			return errorMap.get(errorCode);
		}
		return ErrorCode.UNDEFINED_ERROR_MSG;
	}
}

