package ch.unige.pinfo.bakery.baker;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import ch.unige.pinfo.bakery.dish.IDish;
import ch.unige.pinfo.bakery.dish.Macaron;
import ch.unige.pinfo.bakery.oven.IOven;

/*
 * @Default signals that this is the Baker we want to use as standard. To use an alternative, specify it in the beans.xml
 */
@Default
public class FrenchBaker implements IBaker {

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
		oven.setDish(new Macaron());
		return oven.getDish();
	}

	@Override
	public String toString() {
		return "French baker";
	}

}
