package com.drawthink.common.exception;

/**
 * @author drawthink
 * @date 2017年7月10日
 * @Description: 自定义错误code
 */
public interface ErrorCode {

	  String NETWORK_ERROR_CODE = "0001";
	  String NETWORK_ERROR_MSG = "网络错误...";

	  String DATA_ERROR_CODE = "0002";
	  String DATA_ERROR_MSG = "数据加载失败...";

	  String LOGIN_UNAME_ERROR_CODE = "0003";
	  String LOGIN_UNAME_ERROR_MSG = "用户不存在...";

	  String LOGIN_PD_ERROR_CODE = "0004";
	  String LOGIN_PD_ERROR_MSG = "密码错误...";
	
	  String UNDEFINED_ERROR_MSG = "未知错误...";

}
