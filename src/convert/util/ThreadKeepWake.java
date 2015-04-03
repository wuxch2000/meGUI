package convert.util;

import log.Trace;

import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-12-17
 * Time: 下午9:53
 */
public class ThreadKeepWake extends Thread {

    private static final int THREAD_SLEEP_PERIOD_SECOND = 60;


    public ThreadKeepWake() {
    }

    @Override
    public void run() {
        Trace.debug("ThreadKeepWake.run(): start");
        int x_offset = 1;

        Robot hal;
        try {
            hal = new Robot();
            //noinspection InfiniteLoopStatement
            while (true) {
                Thread.sleep(THREAD_SLEEP_PERIOD_SECOND*1000);
                if (x_offset == 1) {
                    x_offset = -1;
                } else {
                    x_offset = 1;
                }

                Point p = MouseInfo.getPointerInfo().getLocation();

                hal.mouseMove((int) p.getX() + x_offset, (int) p.getY());

                Trace.debug("ThreadKeepWake.run():mouse move to ", p);


            }
        } catch (AWTException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            Trace.debug("ThreadKeepWake.run(): is stopped by interrupt");
        }

    }

}
