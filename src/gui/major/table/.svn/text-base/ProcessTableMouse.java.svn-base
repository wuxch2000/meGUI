package gui.major.table;

import gui.menu.PopMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * User: 吴晓春
 * Date: 11-3-21
 * Time: 下午5:09
 */
public class ProcessTableMouse extends MouseAdapter {
    private final ProcessTable table;
    private final PopMenu popMenu;

    public ProcessTableMouse(final ProcessTable table, PopMenu popMenu) {
        this.table = table;
        this.popMenu = popMenu;
    }

    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);

        if (mouseEvent.getClickCount() == 2) {
            table.openInfoPanel();
        }

//        if (mouseEvent.isShiftDown()) {
//            table.changeVideoFileSetting();
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        if (e.isPopupTrigger()) {
            int row = table.rowAtPoint(e.getPoint());
            int column = table.columnAtPoint(e.getPoint());

            if (!table.isRowSelected(row))
                table.changeSelection(row, column, false, false);

            popMenu.show(e.getComponent(),
                    e.getX(), e.getY());
        }
    }
}
