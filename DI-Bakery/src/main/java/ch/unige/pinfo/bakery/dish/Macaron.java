package ch.unige.pinfo.bakery.dish;

public class Macaron implements IDish {

	private String quality;

	@Override
	public void setQuality(String string) {
		this.quality = string;
	}

	@Override
	public String toString() {
		return this.quality + " Macaron";
	}
}
