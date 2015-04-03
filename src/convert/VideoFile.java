package convert;

import config.encode.EncodeProfile;
import convert.util.VideoFileClip;
import convert.util.VideoFileInfor;
import gui.util.FileUtil;
import gui.util.VideoFileFilter;
import gui.util.command.Status;
import gui.util.time.VideoRange;
import xml.StringUtil;

import java.io.File;

import static gui.util.command.Status.IDLE;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-18
 * Timex: 下午5:11
 * <p/>
 * find length:
 * mplayer -identify file.avi
 * And look al the ID_LENGTH property.
 * If you want it to show this info and exit use:
 * mplayer -frames 0 -identify file.avi
 * <p/>
 * <p/>
 * single=<PNG filename>
 * <p/>
 * Eg./ mplayer -vo png:z=0:single=<PNG filename> my_movie.mpg
 * <p/>
 * mplayer -vo jpeg -sstep 30 -frames 10 yourfile
 * add -vf scale=320:240 if you want smaller image size...
 * use -vf framestep if sstep does not work on your source.
 * <p/>
 * mplayer -nosound -vo jpeg -ss 60 -sstep 60 -frames 10 Greys.Anatomy.716.m4v
 */
public class VideoFile {

    final private File sourceFile;
    private File destinFile;
    private VideoFileClip clip;
    private File scriptFile;
    private EncodeProfile encodeProfile;

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    private Status status;

    public VideoRange getVideoRange() {
        return videoRange;
    }

    static public boolean isVideoFile(File file) {
        return VideoFileFilter.isVideoFile(file);
    }

    public void setVideoRange(final VideoRange videoRange) {
        this.videoRange = videoRange;
    }

    private VideoRange videoRange;

    public static VideoFile build(File sourceFile) {
        return new VideoFile(sourceFile);
    }

    protected VideoFile(File sourceFile) {
        this.sourceFile = sourceFile;
        destinFile = null;
        status = IDLE;
    }

    public int getLength() {
        if (info == null) {
            return 0;
        }
        return info.getItemIntValue(VideoFileInfor.LENGTH);
    }

    public void initVideoFile() {
        info = VideoFileInfor.build(sourceFile);
        clip = VideoFileClip.build(sourceFile, getLength());
        scriptFile = null;
        videoRange = VideoRange.build(getLength());
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public File getDestinFile() {
        return destinFile;
    }

    public void setDestinFile(File destinFile) {
        this.destinFile = destinFile;
    }


    public VideoFileInfor getInfo() {
        return info;
    }

    private VideoFileInfor info;

    public VideoFileClip getClip() {
        return clip;
    }


    private static final String DEST_EXT = "m4v";

    public String guessDestinFileName() {
        String name;

        name = StringUtil.concat(FileUtil.getFileWithoutExt(sourceFile),
                ".", DEST_EXT);

        return name;
    }

    @Override
    public String toString() {
        return getSourceFile().getName();
    }

    public File getScriptFile() {
        return scriptFile;
    }

    public void setScriptFile(final File scriptFile) {
        this.scriptFile = scriptFile;
    }

    public EncodeProfile getEncodeProfile() {
        return encodeProfile;
    }

    public void setEncodeProfile(final EncodeProfile encodeProfile) {
        this.encodeProfile = encodeProfile;
    }
}
