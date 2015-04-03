package junit.gui.profile;

import config.encode.*;
import gui.profile.right.basetype.*;
import gui.util.*;

import javax.swing.*;

public class JUT_CfgItems {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiUtil.createAndShowGUI("", initFramePanel());
            }
        });
    }

    static class Item extends JLabel implements I_ConfigItem {

        Item(final String text) {
            super(text);
        }

        @Override
        public void updateFromFile(final EncodeProfile file) {
        }

        @Override
        public void updateToFile(final EncodeProfile file) {
        }

        @Override
        public String toCmdLineArg() {
            return null;
        }

        @Override
        public void setDefault() {
        }

        @Override
        public JComponent getGUI() {
            return this;
        }
    }

    static class Items extends A_CfgItems {
        private final int MAX_ITEMS = 21;
        Items() {
            super(A_CfgItems.MAX_ITEM_IN_ROW);
            for(int i = 0;  i < MAX_ITEMS; i++) {
                String s = String.format("LABEL-%d",i);
                Item label = new Item(s);
                BorderUtil.addSolidBorder(label.getGUI());
                super.addItem(label);
            }
            super.layout();

            SizeUtil.sameSize(getGUI(),600,400);
        }
    }

    private static JComponent initFramePanel() {

        return new Items().getGUI();

    }
}

