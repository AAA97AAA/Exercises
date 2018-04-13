package ch.unige.pinfo.bakery.oven;

import javax.enterprise.inject.Alternative;

import ch.unige.pinfo.bakery.dish.IDish;
import ch.unige.pinfo.bakery.intercept.Logged;

/*
 * @Alternative shows that this is an alternative implementation. To use an alternative, specify it in the beans.xml
 */
@Alternative
public class GoodOven implements IOven {
	
	IDish dish;

	public IDish getDish() {
		return dish;
	}

	/*
	 * A good oven will make good dishes.
	 */
	@Logged
	public void setDish(IDish dish) {
		this.dish = dish;
		this.dish.setQuality("good");
	}
	
}
