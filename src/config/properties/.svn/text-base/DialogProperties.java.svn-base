package config.properties;

import config.LocalConfig;
import log.Trace;

import java.util.ResourceBundle;

import static java.lang.String.format;

/**
 * User: 吴晓春
 * Date: 11-3-26
 * Time: 下午3:33
 */
public class DialogProperties {

    public enum Key {
        OK("OK"),
        Cancel("Cancel"),
        Yes("Yes"),
        No("No"),
        Open("Open"),
        Save("Save"),
        Warning("Warning"),
        Error("Error"),
        Infor("Infor"),
        Question("Question"),
        Add("Add"),
        Default("Default"),

        ChangeName("ChangeName"),
        Normalize("Normalize"),
        NormalizeAll("NormalizeAll"),

        RemoveSingleVideoFileConfirm("RemoveSingleVideoFileConfirm"),
        RemoveMultiVideoFilesConfirm("RemoveMultiVideoFilesConfirm"),
        RemoveRunningVideoFileConfirm("RemoveRunningVideoFileConfirm"),

        ChangeNamePrompt("ChangeNamePrompt"),

        Processing("Processing"),
        Progress("Progress"),
        QuitNow("QuitNow"),

        About("About"),
        AddVideoFile("AddVideoFile"),
        Convert("Convert"),
        Down("Down"),
        EditProfile("EditProfile"),
        File("File"),
        Help("Help"),
        Remove("Remove"),
        StopConvert("StopConvert"),
        Up("Up"),
        GUIForMecoder("GUIForMecoder"),
        BrowseLog("BrowseLog"),


        TotalLength("TotalLength"),
        begin("begin"),
        end("end"),

        ApplyToAll("ApplyToAll"),

        videoFile("videoFile"),

        copyCss("copyCss"),
        xslt("xslt"),
        openhtml("openhtml"),

        UI("UI"),
        editConvertOption("editConvertOption"),

        FontChooser("FontChooser"),

        Container("Container"),
        Audio("Audio"),
        Video("Video"),
        Font("Font"),
        AddingVideoFiles("AddingVideoFiles"),
        InitialingFontChooserDialog("InitialingFontChooserDialog"),

        ShowOnStartUp("ShowOnStartUp"),
        Tutorial("Tutorial"),
        OpenTutorialDialog("OpenTutorialDialog"),
        Quit("Quit"),
        OpenFileError("OpenFileError"),
        OpenSourceFilePath("OpenSourceFilePath"),
        OpenDestinationFilePath("OpenDestinationFilePath");

        private final String str;

        public String value() {
            return str;
        }

        Key(final String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }


    private static DialogProperties dialogProperties = null;

    public static DialogProperties instance() {
        if (dialogProperties == null) {
            dialogProperties = new DialogProperties();

            Trace.debug("DialogProperties.instance():",
                    "init OK");

        }
        return dialogProperties;
    }


    private ResourceBundle getBundle() {
        return ResourceBundle.getBundle("properties.Dialog",
                LocalConfig.instance().getLocal());
    }

    private String getString(String str) {
        return getBundle().getString(str);
    }

    public String getString(Key key) {
        return getString(key.toString());
    }

    public String getString(Key key, String addstr) {
        return format(getString(key), addstr);
    }


}


