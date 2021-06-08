package checkpoints;

public class Destination implements Checkpoint {
	private String name = "";
	private boolean isProcessed = false;
	
	
	public Destination(String name) {
		this.name = name;
	}
	
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
