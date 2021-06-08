package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import baggageTrackingSystem.Bag;
import baggageTrackingSystem.BaggageTrackingSystem;
import checkpoints.BaggageClaim;
import checkpoints.Checkpoint;
import checkpoints.Destination;
import checkpoints.Transfer;

public class BaggageTrackingSystemTest {
	Logger logger = Logger.getLogger(BaggageTrackingSystemTest.class);
	BaggageTrackingSystem system = new BaggageTrackingSystem();
	ArrayList<String> callbacks = new ArrayList<>();
	Bag bag1 = new Bag("1", "John");
	
	@Before
	public void setUp() {
	// ======= Create a bag and add checkpoints ======
	bag1.addCheckpoints(new Destination("JFK"), 
						new Transfer(), 
						new Destination("MUC"), 
						new Transfer(), 
						new Destination("KBP"), 
						new BaggageClaim());
	}
	
	@Test
	public void checkpointsTest() {
	// ====== Check that all checkpoints are flagged false before the bag is processed.
		for (Checkpoint checkpoint: bag1.getCheckpoints()) {
			assertFalse(checkpoint.isProcessed());
		}
	}
	
	@Test
	// ======= Check if the bag's owner and number of checkpoints are correct =======
	public void bagTest() {
		int size = bag1.getCheckpoints().size();
		assertEquals(bag1.getOwner(), "John");
		assertEquals(size, 6);
	}
	
	@Test
	public void lastCheckpointTest() {
	// ======= Check if the last checkpoint is baggage claims checkpoint ========
		int size = bag1.getCheckpoints().size();
		assertEquals(bag1.getCheckpoints().get(size - 1).getClass(), BaggageClaim.class);
	}
	
	
	@Test
	public void trackBagTest() {
	// ======= Check bag handling (all checkpoints are flagged true after processing) =========
	system.trackBag(bag1);
	for (Checkpoint checkpoint: bag1.getCheckpoints()) {
		assertTrue(checkpoint.isProcessed());
		}
	
	}
	
	@Test
	public void callbackTest2() {
	// ======= Check bag callbacks are empty before handling the bag =========
	system.getBagCallbacks().put(bag1.getId(), callbacks);
	assertTrue(callbacks.isEmpty());
	
	}
	
	@Test
	public void callbackTest3() {
	// ======= Check that number of callbacks in the system after handling is the same as number of checkpoints  =========
	int size = bag1.getCheckpoints().size();
	system.getBagCallbacks().put(bag1.getId(), callbacks);
	system.trackBag(bag1);
	assertEquals(system.getBagCallbacks().get(bag1.getId()).size(), size);
	
	}
	
}
