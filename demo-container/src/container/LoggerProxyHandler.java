package container;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerProxyHandler implements InvocationHandler
{
	private Object subject;
	private static final Logger LOG = Logger.getLogger(LoggerProxyHandler.class.getName());
	
	public LoggerProxyHandler(Object subject)
	{
		this.subject = subject;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		if(method.isAnnotationPresent(Log.class)) {
			String level = method.getAnnotation(Log.class).level();
			LOG.log(Level.parse(level),">>> DEBUT APPEL "+method.getName());
			Object r = method.invoke(subject, args);
			LOG.log(Level.parse(level),">>> FIN APPEL "+method.getName());
			return r;
		}
		return method.invoke(subject, args);
	}
}
