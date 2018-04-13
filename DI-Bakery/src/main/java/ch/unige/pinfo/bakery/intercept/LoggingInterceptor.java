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
		StringBuilder sb = new StringBuilder();
		sb.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		sb.append(" --- ");
		sb.append(ictx.getMethod().getName());
		System.out.println(sb.toString());
		return ictx.proceed();
	}
}
