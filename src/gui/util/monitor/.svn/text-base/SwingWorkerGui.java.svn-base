package gui.util.monitor;

import log.*;

import javax.swing.*;

public class SwingWorkerGui extends SwingWorker<Void, Void> {
	private final NeedUsingSwingWorker actualWorker;

	public SwingWorkerGui(NeedUsingSwingWorker actualWorker) {
		super();
		this.actualWorker = actualWorker;
	}

	@Override
	protected Void doInBackground() throws Exception {
		actualWorker.doInBackground();
		return null;
	}

	@Override
	protected void done() {
		super.done();
		try {
			actualWorker.done();
		} catch (Exception e) {
			Trace.error(e);
		}
	}

}
