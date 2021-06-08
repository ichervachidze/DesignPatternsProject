package chainOfResponsibility;

import callback.Callback;
import checkpoints.Checkpoint;
import checkpoints.Destination;

public class DestinationHandler extends ChainOfResponsibility {
		
	public DestinationHandler(ChainOfResponsibility handler) {
		super(handler);
	}
	
	public void processCheckpoint(Checkpoint checkpoint, Callback callback) {
		if (checkpoint.getClass().equals(Destination.class)) {
			logger.trace("loading unto plane to " + checkpoint.getName());
			logger.trace("arrived at " + checkpoint.getName());
			checkpoint.setProcessed(true);
			callback.call();
		}
		else {
			super.processCheckpoint(checkpoint, callback);
		}
	}


}
