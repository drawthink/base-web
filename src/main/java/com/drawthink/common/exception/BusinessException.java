package com.drawthink.common.exception;

import com.drawthink.common.logger.DtLog;

/**
 * @author drawthink
 * @date 2017年7月10日
 * @Description: 自定义异常处理类
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -2670518076706966292L;

	public BusinessException(){
		super();
	}
	
	public BusinessException(String errorCode){
		super("the error is ->["+errorCode+"] msg: "+ ErrorCodeMap.getErrorMsg(errorCode));
		DtLog.error("BusinessException",this);
	}
	
	public BusinessException(String errorCode,String errorMsg){
		super("the error is ->["+errorCode+"] msg: "+errorMsg);
		DtLog.error("BusinessException",this);
	}
	
}
