package log;

import gui.util.time.DateUtil;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class StdOutputFormat extends Formatter {

	@Override
	public synchronized String format(LogRecord logRecord) {
		// return super.format(logRecord);
		StringBuilder builder = new StringBuilder();
		Date date = new Date(logRecord.getMillis());
		builder.append(DateUtil.toTimeWithNS(date));
		builder.append(":");
		builder.append(logRecord.getMessage());
		builder.append("\n");
		return builder.toString();
	}
}
