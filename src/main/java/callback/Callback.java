package callback;

import org.apache.log4j.Logger;

public interface Callback {
	
	Logger logger = Logger.getLogger(Callback.class);
	public void call();

}
