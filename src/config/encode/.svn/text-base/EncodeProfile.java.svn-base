package config.encode;

import org.w3c.dom.*;
import xml.*;
import xml.domutil.*;

import javax.xml.xpath.*;
import java.io.File;

public class EncodeProfile {
    public File getProfileFile() {
        return profileFile;
    }

    private final File profileFile;
    private Document dom;

	public EncodeProfile(File profileFile) {
        this.profileFile = profileFile;
        if(profileFile != null) {
            try {
                dom = DomUtil.build(profileFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public String toString() {
		String fileName = profileFile.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
	}

    public String getValueByPath(String xmlPath) {
        String value;
        try{
            value = XmlUtil.xpath(xmlPath,dom);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return "";
        }
        return value;
    }

    public void setValueByPath(String xmlPath, String value) {
        try {
            XmlUtil.updateElementValue(value,xmlPath,dom);
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            XmlUtil.dom2xml(dom,profileFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
