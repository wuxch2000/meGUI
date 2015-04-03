package gui.major.videoinfo.videodetail.items;

import convert.*;
import gui.major.videoinfo.videodetail.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午4:28
 */
public class Detail_Name extends A_Detail {

    static private final String TITLE = "name";

    public Detail_Name() {
        super(TITLE);
    }

    protected void buildGridBagConstraints() {
        gridBagConstraints = GridBagConstraintBuilder.instance().build(this);
    }

    @Override
    public void update(final VideoFile videoFile) {
        setContentText(videoFile.getSourceFile().getName());
    }
}
