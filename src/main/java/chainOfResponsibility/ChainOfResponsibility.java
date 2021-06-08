package chainOfResponsibility;
import org.apache.log4j.Logger;

import callback.Callback;
import checkpoints.Checkpoint;

public abstract class ChainOfResponsibility {
	Logger logger = Logger.getLogger(ChainOfResponsibility.class);
	private ChainOfResponsibility next;
	
	
	public ChainOfResponsibility(ChainOfResponsibility next) {
		this.next = next;
	}
	
	public void processCheckpoint(Checkpoint checkpoint, Callback callback) {
		if (next != null) {
			next.processCheckpoint(checkpoint, callback);
		}
	}
}
