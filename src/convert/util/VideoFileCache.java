package convert.util;

import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-21
 * Time: 下午2:52
 */
public class VideoFileCache<E> {
    private HashMap<String, E> cache;

    private static VideoFileCache<VideoFileInfor> infoCache;
    private static VideoFileCache<VideoFileClip> clipCache;

    public static VideoFileCache<VideoFileInfor> instanceOfInfo() {
        if (infoCache == null) {
            infoCache = new VideoFileCache<>();
        }

        return infoCache;
    }

    public static VideoFileCache<VideoFileClip> instanceOfClip() {
        if (clipCache == null) {
            clipCache = new VideoFileCache<>();
        }
        return clipCache;
    }

    public VideoFileCache() {
        cache = new HashMap<>();
    }

    private String key(File videoFile) {
        return videoFile.getPath();
    }

    public void add(File videoFile, E e) {
        cache.put(key(videoFile), e);
    }

    public boolean contain(File videoFile) {
        return cache.containsKey(key(videoFile));
    }

    public E get(File videoFile) {
        return cache.get(key(videoFile));
    }

}
