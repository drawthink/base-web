package com.wmsp.test;

import com.drawthink.common.exception.BusinessException;
import com.drawthink.common.exception.ErrorCode;

/**   
* @author drawthink   
* @date 2017年7月10日  
* @Description: TODO(用一句话描述该文件做什么) 
*/
public class ExceptionTest {

	public static void main(String[] args) {
		
			if(1 == 1){
				throw new BusinessException(ErrorCode.DATA_ERROR_CODE,"test");
			}
		

	}

}

