package ch.unige.pinfo.bakery.oven;

import ch.unige.pinfo.bakery.dish.IDish;

public interface IOven {

	void setDish(IDish gateau);
	IDish getDish();

}
