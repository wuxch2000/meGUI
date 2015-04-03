package junit.stub;

import convert.*;
import convert.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-23
 * Time: 上午9:09
 */
public class StubVideoConvert extends VideoConvert{
    private StubVideoConvert(final VideoFile videoFile) {
        super(videoFile);
    }

    public static StubVideoConvert build(final VideoFile videoFile) {
        return new StubVideoConvert(videoFile);
    }

}
