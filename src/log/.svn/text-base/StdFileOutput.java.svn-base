package log;

import java.io.IOException;
import java.util.logging.FileHandler;

public class StdFileOutput extends FileHandler {
	private static final String fileName = "log.txt";

	public StdFileOutput() throws IOException, SecurityException {
		super(fileName, false);
		super.setFormatter(new StdOutputFormat());
	}

}
