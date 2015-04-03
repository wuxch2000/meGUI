package gui.major.videofilesetting;

import config.properties.VideoFileFieldProperties;

/**
 * User: 吴晓春
 * Date: 11-6-9
 * Time: 下午2:13
 */
public enum ColumnType {
    SOURCE_FILE,
    DEST_DIR,
    DEST_NAME,
    PROFILE,
    SCRIPT,
    TIME_RANGE;

    @Override
    public String toString() {
        String ret;
        switch (this) {
            case SOURCE_FILE:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.SOURCE_FILE);
                break;
            case DEST_DIR:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.DEST_DIR);
                break;
            case DEST_NAME:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.DEST_NAME);
                break;
            case PROFILE:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.PROFILE);
                break;
            case SCRIPT:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.SCRIPTION);
                break;
            case TIME_RANGE:
                ret = VideoFileFieldProperties.instance().getString(VideoFileFieldProperties.Key.RANGE);
                break;
            default:
                ret = "";
                break;
        }
        return ret;
    }
}
