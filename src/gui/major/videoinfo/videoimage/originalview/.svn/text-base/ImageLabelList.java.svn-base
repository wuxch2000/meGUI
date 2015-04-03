package gui.major.videoinfo.videoimage.originalview;

import gui.util.button.*;
import log.*;

import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-11
 * Timex: 上午9:28
 */
public class ImageLabelList extends ArrayList<ImageLabel> {
    public void setCurrentSelectedLabel(final ImageLabel currentSelectedLabel) {
        if (!contains(currentSelectedLabel)) {
            Trace.debug("ImageLabelList.setCurrentSelectedLabel() error!");
        }
        this.currentSelectedLabel = currentSelectedLabel;
    }

    private HashMap<ImageLabel,File> fileHash;

    public boolean add(final ImageLabel imageLabel,File file) {
        fileHash.put(imageLabel, file);
        return super.add(imageLabel);
    }

    public File getCurrentSelectFile() {
        if (getCurrentSelectedLabel() != null) {
            return fileHash.get(getCurrentSelectedLabel());
        }
        return null;
    }

    private ImageLabel currentSelectedLabel;

    public ImageLabelList() {
        super();
        this.currentSelectedLabel = null;
        fileHash = new HashMap<ImageLabel, File>();
    }

    public boolean isHead() {
        return indexOf(currentSelectedLabel) == 0;
    }

    public boolean isTail() {
        return indexOf(currentSelectedLabel) == (size() - 1);
    }

    public void selectFirst() {
        if (!isEmpty()) {
            currentSelectedLabel = get(0);
        }
    }

    public boolean selectNext() {
        if (currentSelectedLabel == null && !isEmpty()) {
            currentSelectedLabel = get(0);
            return true;
        }

        if (!isTail()) {
            currentSelectedLabel = get(indexOf(currentSelectedLabel) + 1);
            return true;
        }
        return false;
    }

    public boolean selectPrev() {
        if (!isHead()) {
            currentSelectedLabel = get(indexOf(currentSelectedLabel) - 1);
            return true;
        }
        return false;
    }

    public ImageLabel getCurrentSelectedLabel() {
        return currentSelectedLabel;
    }
}
