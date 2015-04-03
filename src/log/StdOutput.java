package log;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class StdOutput extends StreamHandler {

	public StdOutput() {
		super(System.out, new StdOutputFormat());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.StreamHandler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public synchronized void publish(LogRecord arg0) {
		super.publish(arg0);
		super.flush();
	}

}
