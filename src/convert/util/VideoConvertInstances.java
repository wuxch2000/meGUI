package convert.util;

import convert.VideoFile;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * User: 吴晓春
 * Date: 11-3-21
 * Time: 上午9:10
 */
public class VideoConvertInstances {
    private HashMap<VideoFile, VideoConvert> runningInstances;
    private static VideoConvertInstances videoConvertInstances;

    public static VideoConvertInstances instance() {
        if (videoConvertInstances == null) {
            videoConvertInstances = new VideoConvertInstances();
        }
        return videoConvertInstances;
    }

    private VideoConvertInstances() {
        runningInstances = new LinkedHashMap<>();
    }

    public void addConvert(VideoFile videoFile, VideoConvert videoConvert) {
        runningInstances.put(videoFile, videoConvert);
    }

    public void stopConvert(VideoFile videoFile) {
        if (videoFile == null) {
            return;
        }
        VideoConvert videoConvert = runningInstances.get(videoFile);
        if (videoConvert == null) {
            return;
        }

        videoConvert.stop();

        runningInstances.remove(videoFile);
    }

    public boolean isEmtpy() {
        return runningInstances.isEmpty();
    }

    public void updateAllStartEndTime(VideoConvert videoConvert, int rate, Date predictEndTime) {
        boolean needUpdatePredictStartEndTime = false;
        Date previousEndtime = predictEndTime;
        for (VideoConvert c : runningInstances.values()) {
            if (needUpdatePredictStartEndTime) {
                previousEndtime = c.updatePredictStartEndTime(rate, previousEndtime);
                if (predictEndTime == null) {
                    return;
                }
            }
            if (c == videoConvert) {
                needUpdatePredictStartEndTime = true;
            }
        }
    }
}
