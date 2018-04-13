package ch.unige.pinfo.bakery.oven;

import javax.enterprise.inject.Default;
import javax.interceptor.Interceptors;

import ch.unige.pinfo.bakery.dish.IDish;
import ch.unige.pinfo.bakery.intercept.LoggingInterceptor;

/*
 * @Default signals that this is the Oven we usually want use. To use an alternative, specify it in the beans.xml
 */
@Default
public class BadOven implements IOven {
	
	IDish dish;

	public IDish getDish() {
		return dish;
	}

	/*
	 * A bad oven will render the quality of the dish bad.
	 */
	@Interceptors(LoggingInterceptor.class)
	public void setDish(IDish dish) {
		this.dish = dish;
		dish.setQuality("bad");
	}
	
}
