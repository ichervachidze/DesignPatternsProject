package checkpoints;

public class BaggageClaim implements Checkpoint {
	String name = "baggage claim";
	boolean isProcessed = false;
	
	
	public String getName() {
		return this.name;
	}
	
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public boolean isProcessed() {
		return isProcessed;
	}
	
	
}
