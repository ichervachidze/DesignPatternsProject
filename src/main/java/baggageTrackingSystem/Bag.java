package baggageTrackingSystem;
import java.util.ArrayList;

import checkpoints.Checkpoint;

public class Bag {
	String owner = "";
	String id = "";
	String origin = "BOS";
	private ArrayList<Checkpoint> checkpoints = new ArrayList<>();
	private int checkpointIndex;
	
	public Bag() {
		setCheckpointIndex(0);
	}

	public Bag(String id, String owner) {
		setCheckpointIndex(0);
		this.id = id;
		this.owner = owner;
	}
	
	public void addCheckpoints(Checkpoint ... checkpoints) {
		for (Checkpoint checkpoint: checkpoints)
		this.checkpoints.add(checkpoint);
	}
	
	public void removeCheckpoint(Checkpoint checkpoint) {
		this.checkpoints.remove(checkpoint);
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<Checkpoint> getCheckpoints() {
		return this.checkpoints;
	}

	public int getCheckpointIndex() {
		return checkpointIndex;
	}

	public void setCheckpointIndex(int checkpointIndex) {
		this.checkpointIndex = checkpointIndex;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
		public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
