package baggageTrackingSystem;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import callback.BagCallback;
import callback.Callback;
import chainOfResponsibility.BaggageClaimHandler;
import chainOfResponsibility.ChainOfResponsibility;
import chainOfResponsibility.DestinationHandler;
import chainOfResponsibility.TransferHandler;
import checkpoints.Checkpoint;

public class BaggageTrackingSystem {
	Logger logger = Logger.getLogger(BaggageTrackingSystem.class);
	HashMap <String, ArrayList<String>> bagCallbacks = new HashMap<>();
	ChainOfResponsibility chain;
	
	
			
	public BaggageTrackingSystem() {
		chain = new DestinationHandler(new TransferHandler(new BaggageClaimHandler(null)));
	}
	
	public void trackBag(Bag bag) {
		logger.trace("\nTracking bag: " + bag.getId());
		ArrayList<String> reports = new ArrayList<>(); //create empty array
		bagCallbacks.put(bag.getId(), reports); // array will serve as container to collect callbacks for that bag
		
		// iterate through all checkpoints and process them
		for (Checkpoint checkpoint: bag.getCheckpoints()) {
			Callback callback = new BagCallback(bag, checkpoint, this); //callback object will trigger response from the bag
			chain.processCheckpoint(checkpoint, callback);
			}
		}
	
	public HashMap <String, ArrayList<String>> getBagCallbacks(){
		return this.bagCallbacks;
	}
}
