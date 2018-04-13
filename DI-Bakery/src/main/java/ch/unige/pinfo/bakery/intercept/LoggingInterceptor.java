package ch.unige.pinfo.bakery.intercept;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggingInterceptor {

	@AroundInvoke
	public Object interceptorMethod(InvocationContext ictx) throws Exception{
		String logme = getLogMessage(ictx);
		System.out.println(logme);
		return ictx.proceed();
	}

	private String getLogMessage(InvocationContext ictx) {
		StringBuilder sb = new StringBuilder();
		sb.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		sb.append(" --- ");
		sb.append(ictx.getMethod().getName());
		sb.append(" called by somebody");
		String logme = sb.toString();
		return logme;
	}
	
}
