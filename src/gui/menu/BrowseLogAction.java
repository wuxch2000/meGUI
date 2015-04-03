package gui.menu;

import config.properties.*;
import gui.swingworker.*;
import gui.util.monitor.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BrowseLogAction extends AbstractAction {


    @Override
	public void actionPerformed(ActionEvent arg0) {
        SwingWorkerGui worker = new SwingWorkerGui(new DoBrowseLog());
        worker.execute();
    }

	public BrowseLogAction() {
		super(DialogProperties.instance().getString(DialogProperties.Key.BrowseLog));
    }


}
