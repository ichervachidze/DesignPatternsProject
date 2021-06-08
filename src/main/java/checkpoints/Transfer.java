package checkpoints;

public class Transfer implements Checkpoint {
	String name = "transfer";
	private boolean isProcessed = false;

	@Override
	public String getName() {
		return this.name;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	

}
