package ch.unige.pinfo.bakery.baker;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import ch.unige.pinfo.bakery.dish.BlackForrestCake;
import ch.unige.pinfo.bakery.dish.IDish;
import ch.unige.pinfo.bakery.oven.IOven;

/*
 * @Alternative shows that this is an alternative implementation. To use an alternative, specify it in the beans.xml
 */
@Alternative
public class GermanBaker implements IBaker {

	/*
	 * This is the point where we assign (inject) an IOven (GoodOven, BadOven) to the baker.
	 * The choice will define the quality of the dish.
	 */
	@Inject
	IOven oven;

	/*
	 * Baking is the activity of putting a dish in the oven and taking it out again.
	 * (Very simplified)
	 */
	@Override
	public IDish bake() {
		oven.setDish(new BlackForrestCake());
		return oven.getDish();
	}

	@Override
	public String toString() {
		return "German baker";
	}

}
