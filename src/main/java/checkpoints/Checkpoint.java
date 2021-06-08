package checkpoints;

public interface Checkpoint {
	public String getName();
	public void setProcessed(boolean processed);
	public boolean isProcessed();

}
