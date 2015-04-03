package xml.xslt2;

import config.*;
import gui.util.*;
import gui.util.command.*;
import log.*;
import xml.*;

import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-5-18
 * Time: 下午1:51
 */
public class XsltSaxon implements Xslt{
    private static XsltSaxon saxon =null;

    private boolean isUsable = false;
    private String command;
    private String sourceTag;
    private String xslFileTag;
    private String destinationTag;


    private XsltSaxon() {
        try {
            Config config = Config.instance();
            command = config.getString("/config/xslt/command");
            sourceTag = config.getString("/config/xslt/source-tag");
            xslFileTag = config.getString("/config/xslt/xsl-file-tag");
            destinationTag = config.getString("/config/xslt/destination-tag");
            isUsable = true;
        } catch (Exception e) {
            Trace.error(e);
            isUsable = false;
        }
    }

    public static XsltSaxon build() {
        if (saxon == null) {
            saxon = new XsltSaxon();
        }
        return saxon;
    }

    @Override
    public void xslt(final File inputXml, final File xslFile, final File outputXml) {
        if (!isUsable) {
            return;
        }
        LinkedList<String> list = new LinkedList<String>();
        Collections.addAll(list, command.split(" "));

        list.addLast(StringUtil.concat(sourceTag,FileUtil.quoteName(inputXml)));
        list.addLast(StringUtil.concat(xslFileTag,FileUtil.quoteName(xslFile)));
        list.addLast(StringUtil.concat(destinationTag,FileUtil.quoteName(outputXml)));

        CommandInfo info = CommandInfo.build(Config.instance().getVideoTempPath(),
            list);

        Command.instance().runSyn(info);

    }
}
