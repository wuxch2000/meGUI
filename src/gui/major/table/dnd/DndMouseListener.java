package gui.major.table.dnd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * User: 吴晓春
 * Date: 11-12-26
 * Time: 下午8:36
 */
public class DndMouseListener extends MouseAdapter {
//    private JPanel panel;

    public DndMouseListener() {
//        this.panel = panel;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
//        Trace.debug("mouse released.");
//        BorderUtil.addBorder(panel,"mouse released");
//        TransferHandler handler = panel.getTransferHandler();
//        handler.exportAsDrag( panel, e, TransferHandler.COPY );
//        String data = handler.getTransferData();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
//        Trace.debug("mouse pressed.");
//        BorderUtil.addBorder(panel,"mouse pressed");
    }
}
