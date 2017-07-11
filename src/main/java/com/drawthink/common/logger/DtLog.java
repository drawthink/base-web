/**
 * 
 */
package com.drawthink.common.logger;

import com.drawthink.common.utils.ReflectionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.slf4j.Logger;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author drawthink
 *         相关：https://segmentfault.com/a/1190000007214708?utm_source=tuicool&
 *         utm_medium=referral
 */
public class DtLog {

	private static Logger logger;
	private static final String FQCN = DtLog.class.getName();

	/**
	 * 让log4j可以正确展示错误的准确位置
	 */
	static {
		try {
			Enhancer eh = new Enhancer();
			eh.setSuperclass(org.apache.log4j.Logger.class);
			eh.setCallbackType(LogInterceptor.class);
			Class c = eh.createClass();
			Enhancer.registerCallbacks(c, new LogInterceptor[] { new LogInterceptor() });

			Constructor<org.apache.log4j.Logger> constructor = c.getConstructor(String.class);
			org.apache.log4j.Logger loggerProxy = constructor.newInstance(Logger.class.getName());

			LoggerRepository loggerRepository = LogManager.getLoggerRepository();
			LoggerFactory lf = ReflectionUtil.getFieldValue(loggerRepository, "defaultFactory");
			Object loggerFactoryProxy = Proxy.newProxyInstance(LoggerFactory.class.getClassLoader(),
					new Class[] { LoggerFactory.class }, new NewLoggerHandler(loggerProxy));

			ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactoryProxy);
			logger = org.slf4j.LoggerFactory.getLogger(DtLog.class.getName());
			ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", lf);
		} catch (Exception e) {
			throw new RuntimeException("初始化Logger失败", e);
		}
	}

	private static class LogInterceptor implements MethodInterceptor {
		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			// 只拦截log方法。
			if (objects.length != 4 || !method.getName().equals("log"))
				return methodProxy.invokeSuper(o, objects);
			objects[0] = FQCN;
			return methodProxy.invokeSuper(o, objects);
		}

	}

	private static class NewLoggerHandler implements InvocationHandler {
		private final org.apache.log4j.Logger proxyLogger;

		public NewLoggerHandler(org.apache.log4j.Logger proxyLogger) {
			this.proxyLogger = proxyLogger;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			return proxyLogger;
		}
	}

	public static void info(String msg) {
		if (StringUtils.isEmpty(msg)) {
			return;
		}
		logger.info(msg);
	}

	public static void error(String msg) {
		if (StringUtils.isEmpty(msg)) {
			return;
		}
		logger.error(msg);
	}
	
	public static void error(String msg,Throwable throwable) {
		if (StringUtils.isEmpty(msg)) {
			return;
		}
		logger.error(msg,throwable);
	}
}
