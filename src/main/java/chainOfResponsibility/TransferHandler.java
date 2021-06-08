package chainOfResponsibility;

import callback.Callback;
import checkpoints.Checkpoint;
import checkpoints.Transfer;

public class TransferHandler extends ChainOfResponsibility {
	
	public TransferHandler(ChainOfResponsibility handler) {
		super(handler);
	}
	
	public void processCheckpoint(Checkpoint checkpoint, Callback callback) {
		if (checkpoint.getClass().equals(Transfer.class)) {;
			logger.trace("transfering to another terminal");
			checkpoint.setProcessed(true);
			callback.call();
		}
		else {
			super.processCheckpoint(checkpoint, callback);
		}
	}


}
