package gui.major.table.dnd;

import convert.VideoFile;
import gui.MainPanel;
import gui.util.VideoFileFilter;
import log.Trace;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * User: 吴晓春
 * Date: 11-12-26
 * Time: 下午9:08
 */
public class DnDTransferHandler extends TransferHandler {
    public DnDTransferHandler() {
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }

    @Override
    public boolean importData(TransferSupport support) {
        //If we cannot handle the import, bail now.
        if (!canImport(support)) {
            return false;
        }

// Fetch the Transferable and its data
        Transferable t = support.getTransferable();
        try {
            List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
            Vector<VideoFile> videoFiles = new Vector<>();
            for (File file : files) {
                Trace.debug("import from:", file.getName());


                if (VideoFileFilter.isVideoFile(file)) {
                    videoFiles.add(VideoFile.build(file));
                } else {
                    Trace.error("File [", file.getPath(),
                            File.separator, file.getName(), "] is not a video file");
                }
            }

            MainPanel.instance().getMajorPanel().
                    addVideoFile(videoFiles.toArray(new VideoFile[videoFiles.size()]));

        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}
