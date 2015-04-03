package gui.major.videoinfo.videodetail.items;

import convert.*;
import gui.major.*;
import gui.util.font.FontUtil;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午4:41
 */
abstract public class A_Detail extends JPanel implements I_Update {
    private JButton content;
    protected GridBagConstraints gridBagConstraints;

    protected A_Detail(final String titleStr) {
        LayoutManager layoutManager = new FlowLayout();
        setLayout(layoutManager);

        JLabel title = new JLabel(titleStr + ":");
        content = new JButton("NULL");
        content.setEnabled(false);

        FontUtil.setLocalFont(title);
        FontUtil.setLocalFont(content);
        FontUtil.enlargeFont(title,1);
        FontUtil.enlargeFont(content,1);

        add(title);
        add(content);

        buildGridBagConstraints();

    }

    protected abstract void buildGridBagConstraints();


    protected void setContentText(String str) {
        content.setText(str);
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    public static void update(A_Detail detail, VideoFile videoFile) {
        if (videoFile == null) {
            detail.setContentText("");
            return;
        }
        detail.update(videoFile);
    }
}
