package junit.gui.UI.toolbar;

import gui.util.*;

import javax.swing.*;
import java.awt.*;

public class ToolBarTest extends JToolBar {


    public ToolBarTest() {
        setRollover(true);
        setBorderPainted(false);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Dimension size = getSize();

        Graphics2D g2 = (Graphics2D) graphics;

        g2.setPaint(GradUtil.buildGrad(this));

        g2.fill(new Rectangle(size));

    }

}
