/**
 *
 */
package junit.command;

import gui.util.*;
import org.junit.*;
import xml.xslt2.*;

import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * @author 吴晓春
 */
public class JUT_Xslt {

    @BeforeClass
    public static void setUp() {

    }

    @Test
    public void xslt() {
        final File source = new File("d:\\JavaCode\\meGUI\\xml\\log.xml");
        final File xsl= new File("d:\\JavaCode\\meGUI\\xml\\log.xsl");
        final File dest = new File("d:\\JavaCode\\meGUI\\xml\\log.html");

        XsltSaxon.build().xslt(source,xsl,dest);
    }

    @Test
    public void uri() throws IOException {
        URI uri = FileUtil.buildURI(new File("d:\\JavaCode\\meGUI\\xml\\log.html"));
        Desktop.getDesktop().browse(uri);
    }

}
