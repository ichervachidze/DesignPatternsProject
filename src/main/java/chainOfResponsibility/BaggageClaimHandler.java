package chainOfResponsibility;

import callback.Callback;
import checkpoints.BaggageClaim;
import checkpoints.Checkpoint;

public class BaggageClaimHandler extends ChainOfResponsibility {
	
	public BaggageClaimHandler(ChainOfResponsibility handler) {super(handler);}
	
	public void processCheckpoint(Checkpoint checkpoint, Callback callback) {
		if (checkpoint.getClass().equals(BaggageClaim.class)) {
			logger.trace("exiting to baggage claim");
			checkpoint.setProcessed(true);
			callback.call();
		}
		else {
			super.processCheckpoint(checkpoint, callback);
		}
	}

}
