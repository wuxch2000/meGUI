package junit.stub;

import config.encode.*;
import convert.*;
import gui.util.time.*;

import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-23
 * Time: 上午9:07
 */
public class StubVideoFile extends VideoFile {

    public void setLength(final int length) {
        this.length = length;
    }

    private int length = 1260;

    @Override
    public int getLength() {
        return length;
    }

    private StubVideoFile(File sourceFile) {
        super(null);
        SOURCE_FILE = sourceFile;
        videoRange = VideoRange.build(length);
    }

    public static StubVideoFile build(File sourceFile) {
        return new StubVideoFile(sourceFile);
    }

    @Override
    public void initVideoFile() {

    }

    private File SOURCE_FILE =
        new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi");

    private final static File DEST_FILE =
        new File("D:\\JavaCode\\meGUI\\examples\\m4v\\Modern.Family.217.m4v");

    private final static File SCRIPT_FILE =
        new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.srt");

    private VideoRange videoRange;

    public void setSOURCE_FILE(File file) {
        SOURCE_FILE = file;
    }

    @Override
    public File getSourceFile() {
        return SOURCE_FILE;
    }

    @Override
    public VideoRange getVideoRange() {
        return videoRange;
    }

    @Override
    public File getDestinFile() {
        return DEST_FILE;
    }

    public static final EncodeProfile ENCODE_PROFILE = new StubEncodeProfile(null);

    @Override
    public EncodeProfile getEncodeProfile() {
        return ENCODE_PROFILE;
    }

    @Override
    public File getScriptFile() {
        return SCRIPT_FILE;
    }
}
