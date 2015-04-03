package config.encode;

import config.Config;
import gui.util.FileUtil;
import log.Trace;
import xml.StringUtil;
import xml.xslt2.XsltSaxon;

import java.io.File;

/**
 * User: 吴晓春
 * Date: 11-6-8
 * Time: 下午3:39
 */
public class PlainProfile {
    private final EncodeProfile encodeProfile;

    private PlainProfile(EncodeProfile encodeProfile) {
        this.encodeProfile = encodeProfile;
    }

    public static PlainProfile build(EncodeProfile encodeProfile) {
        return new PlainProfile(encodeProfile);
    }

    static private final String FILE_EXT = ".profile";

    private String buildPlainProfileName() {
        String encoderProfileName = encodeProfile.toString();
        File tempFileDir = Config.instance().getVideoTempPath();
        return StringUtil.concat(tempFileDir.getPath(),
                FileUtil.sep,
                encoderProfileName,
                FILE_EXT);
    }

    public File getPlainProfile() {
        File plainProfile = new File(buildPlainProfileName());
        if (plainProfile.exists()) {
            if (plainProfile.lastModified() > encodeProfile.getProfileFile().lastModified()) {
                Trace.debug(plainProfile.getPath(), " is newer than ",
                        encodeProfile.getProfileFile().getPath());
                return plainProfile;
            }
        }

        String xslFileName = Config.instance().getProfileXsl();
        if (xslFileName == null) {
            Trace.error("get profile xsl name error");
            return null;
        }

        XsltSaxon.build().xslt(encodeProfile.getProfileFile(),
                new File(xslFileName), plainProfile);

        return plainProfile;
    }

}
