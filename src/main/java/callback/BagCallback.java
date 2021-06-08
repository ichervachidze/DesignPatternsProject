package callback;

import java.util.ArrayList;

import baggageTrackingSystem.Bag;
import baggageTrackingSystem.BaggageTrackingSystem;
import checkpoints.Checkpoint;

public class BagCallback implements Callback {
	String bagID;
	String checkpointName;
	ArrayList<String> reports;
	
	
	public BagCallback(Bag bag, Checkpoint checkpoint, BaggageTrackingSystem system) {
		this.bagID = bag.getId();
		this.checkpointName = checkpoint.getName();
		this.reports = system.getBagCallbacks().get(bagID);
	}

	@Override
	public void call() {
		reports.add(this.checkpointName);
		logger.trace("<<callback of bag" + this.bagID + ": at " + this.checkpointName + ">>");
	}

}
