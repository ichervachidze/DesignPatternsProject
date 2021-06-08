package client;

import org.apache.log4j.Logger;

import baggageTrackingSystem.Bag;
import baggageTrackingSystem.BaggageTrackingSystem;
import checkpoints.BaggageClaim;
import checkpoints.Destination;
import checkpoints.Transfer;

public class Client {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(BaggageTrackingSystem.class);
		
		// ========== Instantiate the system =======
		BaggageTrackingSystem system = new BaggageTrackingSystem();
		
		
		// =========== Create bags ==========
		Bag bag1 = new Bag("1", "John");
		bag1.addCheckpoints(new Destination("JFK"), 
							new Transfer(), 
							new Destination("MUC"), 
							new Transfer(), 
							new Destination("KBP"), 
							new BaggageClaim());
		
		Bag bag2 = new Bag("2", "Jerry");
		bag2.addCheckpoints(new Destination("HOU"), 
							new BaggageClaim());
		
		// =========== Process bags ==========
		system.trackBag(bag1);
		system.trackBag(bag2);
		
		// ========= Check callbacks of a bag =========
		logger.trace(system.getBagCallbacks().get(bag1.getId().toString()));
		
		
	
		
	}

}
