package gui.util;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-3-4
 * Timex: 下午3:33
 * 根据窗口的大小不端跟踪和获取list的部分元素
 */
public class WindowOfListUtil<E> {
    private int windowWith;
    private List<E> list;
    private int cursor;

    public WindowOfListUtil(int windowWith, List<E> list) {
        this.windowWith = windowWith;
        this.list = list;

        cursor = 0;
    }

    public void clear() {
        cursor = 0;
    }

    public List<E> getSubListInWindow() {
        int endCursor = Math.min(cursor + windowWith, list.size());
        return list.subList(cursor, endCursor);
    }

    public boolean isWindowsReachEnd() {
        return (cursor + windowWith >= list.size());
    }

    public boolean isWindowsAtBegin() {
        return (cursor == 0);
    }

    public enum PosOfWindow {
        LEFT, INSIDE, RIGHT, NOT_IN
    }

    public PosOfWindow checkItemPos(E e) {

        if (list.isEmpty()) {
            return PosOfWindow.NOT_IN;
        }
        int pos = list.indexOf(e);
        if (pos == -1) {
            return PosOfWindow.NOT_IN;
        }

        if (pos < cursor) {
            return PosOfWindow.LEFT;
        }

        if (pos >= cursor + windowWith) {
            return PosOfWindow.RIGHT;
        }
        return PosOfWindow.INSIDE;
    }

    public void moveForward() {
        if (isWindowsReachEnd()) {
            return;
        }
        cursor++;
    }

    public void moveBackward() {
        if (isWindowsAtBegin()) {
            return;
        }
        cursor--;
    }

}
