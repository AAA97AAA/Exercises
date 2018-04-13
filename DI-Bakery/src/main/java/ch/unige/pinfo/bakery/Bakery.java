package ch.unige.pinfo.bakery;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ch.unige.pinfo.bakery.baker.IBaker;
import ch.unige.pinfo.bakery.dish.IDish;

/*
 * Base-class of our app.
 * We define (inject) here which baker we want to use (GermanBaker, FrenchBaker).
 * Depending on our choice we will receive different dishes.
 */

@Path("/")
public class Bakery {
	
	/*
	 * We specify the baker by injection. There is a default (French) and an alternative (German).
	 */
	@Inject
	IBaker baker;
	
	public Bakery() {}
	
	/*
	 * Simple routine listening to the /bake URL, call it and the injected baker will bake a dish.
	 */
	@GET
	@Path("/bake")
	public String bake(){
		IDish d = baker.bake();
		return "You were served a <b>" + d.toString() + "</b> prepared by the <b>" + baker.toString() + "</b>";
	}
	
	/*
	 * Test routine to check that the server works.
	 */
	@GET
	@Path("/")
	public String test(){
		return "The server is up and the App works. Yay!";
	}
}
