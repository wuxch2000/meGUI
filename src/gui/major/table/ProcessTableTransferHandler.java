package gui.major.table;

import convert.*;
import gui.*;
import log.*;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-21
 * Time: 上午11:18
 */
public class ProcessTableTransferHandler extends TransferHandler {
    public ProcessTableTransferHandler() {
    }

    /**
     * We only support importing strings.
     */
    public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }

    /**
     * We support both copy and move actions.
     */
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY;

    }

    /**
     * Perform the actual import.  This demo only supports drag and drop.
     */
    public boolean importData(TransferHandler.TransferSupport info) {
        Trace.debug("importData");
//
//        if (!info.isDrop()) {
//            return false;
//        }

        // Get the string that is being dropped.
        Transferable t = info.getTransferable();
        List<File> importFiles;
        try {
            importFiles = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

            if (importFiles == null) {
                return false;
            }

            ArrayList<VideoFile> importVideoFiles = new ArrayList<>();
            for (File file : importFiles) {
                if (VideoFile.isVideoFile(file)) {
                    VideoFile videoFile = VideoFile.build(file);
                    importVideoFiles.add(videoFile);
                }
            }

            MainPanel.instance().getMajorPanel().
                addVideoFile(importVideoFiles.toArray(
                    new VideoFile[importVideoFiles.size()]));


        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
