package gui.profile.right.basetype;

import config.encode.*;
import gui.util.*;
import gui.util.layout.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static gui.util.BorderUtil.*;

/**
 * 所有配置条目的基类。在本类中实现composite模式
 *
 * @author 吴晓春
 */
public abstract class A_CfgItems implements I_ConfigItem {
    public static final int MAX_ITEM_IN_ROW = 4;

    private final int maxItemInRow;

    private final LinkedList<I_ConfigItem> items;
    /**
     * 对于composite模式，组合类也可以看作是一个ConfigItem。
     */
    private final JPanel gui;


    public A_CfgItems(final int maxItemInRow) {
        this.maxItemInRow = maxItemInRow;
        gui = new JPanel();
        items = new LinkedList<>();
    }


    protected void addItem(I_ConfigItem item) {
        items.add(item);
    }

    protected void clearItem() {
        items.clear();
    }

    protected I_ConfigItem[] getAllItems() {
        return items.toArray(new I_ConfigItem[items.size()]);
    }

    protected boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toCmdLineArg() {
        StringBuilder builder = new StringBuilder();
        for (I_ConfigItem item : items) {
            builder.append(item.toCmdLineArg());
        }
        return builder.toString();
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        for (I_ConfigItem item : items) {
            item.updateFromFile(file);
        }
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        Trace.debug("A_CfgItems.updateToFile():", getClass().getName()," ...");
        for (I_ConfigItem item : items) {
            item.updateToFile(file);
        }
        Trace.debug("A_CfgItems.updateToFile():", getClass().getName()," done.");
    }


    @Override
    public JComponent getGUI() {
        return gui;
    }

    protected JPanel getPanel() {
        return gui;
    }

    protected void removeItem(I_ConfigItem item) {
        items.remove(item);
    }

    /**
     * 组合类就是一个组合面版，这里统一提供加框函数
     *
     * @param str
     */
    protected void setBorder(String str) {
        addBorder(getPanel(), str);
    }


    /**
     * 设置多个Box排列。
     */
    private void usingBoxLayout() {
        LayoutManager layout;
        layout = new BoxLayout(getPanel(), BoxLayout.PAGE_AXIS);
        getPanel().setLayout(layout);

        int i = 0;
        Box box = null;
        for (I_ConfigItem item : getAllItems()) {
            if (i % maxItemInRow == 0) {
                box = new Box(BoxLayout.LINE_AXIS);
                getPanel().add(box);
            }
            i++;
            assert box != null;
            box.add(item.getGUI());
            box.add(Box.createHorizontalGlue());
        }
        getPanel().add(Box.createHorizontalGlue());
    }


    private void usingGridbagLayout() {
        LayoutUtil.UsingGridBagLayout(getPanel());

        int line = 0, column = 0;
        int i = 0;
        double weightx,weighty = 0.0;
        int gridwidth;
        for (I_ConfigItem item : getAllItems()) {
            if ((i + 1) % maxItemInRow == 0) {
                // last item in line
                weightx = 1.0;
            } else {
                weightx = 0.0;
            }

            if ((i + 1) == items.size()) {
                weightx = 1.0;
                weighty = 1.0;
                gridwidth = maxItemInRow - (i % maxItemInRow);
            } else {
                gridwidth = 1;
            }


            getPanel().add(item.getGUI(),
                LayoutUtil.buildConstraints(line, column, weightx,weighty, gridwidth));

            i++;
            if (i % maxItemInRow == 0) {
                // first item in line
                line++;
                column = 0;
            } else {
                column++;
            }
        }
    }

    /**
     * 提供一个统一的布局函数
     */
    protected void layout() {
//        usingBoxLayout();
        usingGridbagLayout();
        BorderUtil.addSpaceBorder(getPanel());
    }

    @Override
    public void setDefault() {
        for (I_ConfigItem configItem : items) {
            configItem.setDefault();
        }
    }

}
