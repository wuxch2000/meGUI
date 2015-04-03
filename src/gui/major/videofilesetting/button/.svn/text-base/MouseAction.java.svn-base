package gui.major.videofilesetting.button;

import gui.major.videofilesetting.VFS_VideoFile;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * User: 吴晓春
 * Date: 11-6-9
 * Time: 下午4:08
 */
public class MouseAction implements MouseListener {

    final private JComponent jComponent;

    public MouseAction(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        VFS_VideoFile vfs_videoFile = (VFS_VideoFile) jComponent.getParent();
        if (vfs_videoFile == null) {
            return;
        }
        vfs_videoFile.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        VFS_VideoFile vfs_videoFile = (VFS_VideoFile) jComponent.getParent();
        if (vfs_videoFile == null) {
            return;
        }
        vfs_videoFile.mouseExited(e);

    }
}
