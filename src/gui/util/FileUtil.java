package gui.util;

import log.*;
import xml.*;

import java.io.*;
import java.net.*;
import java.nio.channels.*;

public class FileUtil {

    public final static String sep = File.separator;
    private static String rootPath = null;

    public static String getRootPath() {
        if (rootPath == null) {
            File directory = new File("");
            try {
                rootPath = directory.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rootPath;
    }

    private static final String TEMP_NAME = "TEMP";

    public static String getSystemTempPath() {
        String cmd = null;
        String os = null;
        BufferedReader commandResult = null;
        String line = null;

        //getting the OS name
        os = System.getProperty("os.name").toLowerCase();

        // according to OS set the command to execute
        if (os.startsWith("windows")) {
            cmd = "cmd /c SET";
        } else {
            cmd = "env";
        }

        try {
            //execute the command and get the result in the form of InputStream
            Process p = Runtime.getRuntime().exec(cmd);

            //parse the InputStream data
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            commandResult = new BufferedReader(isr);

            while ((line = commandResult.readLine()) != null) {
                if (line.contains(TEMP_NAME)) {
                    return line.substring(line.indexOf(TEMP_NAME) + TEMP_NAME.length() + 1);
                }

            }
        } catch (Exception e) {
            Trace.error(e);
        }

        return "";
    }

    public static void del(String filepath) throws IOException {
        File f = new File(filepath);//定义文件路径
        if (f.exists() && f.isDirectory()) {//判断是文件还是目录
            if (f.listFiles().length == 0) {//若目录下没有文件则直接删除
                f.delete();
            } else {//若有则把文件放进数组，并判断是否有下级目录
                File delFile[] = f.listFiles();
                int i = f.listFiles().length;
                for (int j = 0; j < i; j++) {
                    if (delFile[j].isDirectory()) {
                        del(delFile[j].getAbsolutePath());//递归调用del方法并取得子目录路径
                    }
                    delFile[j].delete();//删除文件
                }
            }
        }
    }

    /**
     * 生成指定目录下的所有文件
     *
     * @param dir     目录名
     * @param pattern 正则表达式定义的限制。如jpg文件为".*\\.jpg"
     * @return 文件列表。
     */
    public static File[] getFiles(File dir, String pattern) {
        if (!dir.isDirectory()) {
            return new File[0];
        }
        return dir.listFiles(new FilenameFilter() {
            @Override()
            public boolean accept(File file, String name) {
                return name.matches(".*\\.jpg");
            }
        });
    }

    /**
     * 生成指定目录下的所有文件
     *
     * @param dir 目录名
     * @param ext 文件的扩展名
     * @return 文件列表。
     */
    public static File[] getFilesByExt(File dir, String ext) {
        return getFiles(dir, StringUtil.concat(".*\\." + ext));
    }

    public static String getFileExt(final File file) {
        String name = file.getName();
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return "";
        }
        return name.substring(index + 1, name.length());
    }

    public static String getFileWithoutExt(final File file) {
        String name = file.getName();
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name;
        }
        return name.substring(0, index);
    }

    public static String quoteName(final File file) {
        String name = file.getPath();
        return StringUtil.concat("\"", name, "\"");
    }

    public static File buildFile(final String path, final String name) {
        return new File(StringUtil.concat(path, FileUtil.sep, name));
    }

    public static File buildFile(final File path, final String name) {
        return buildFile(path.getPath(), name);
    }

    public static URI buildURI(final File file) {
        String fileName = file.getAbsolutePath().replaceAll("\\\\", "/").replaceAll(" ", "%20");
        String UriString = StringUtil.concat("file:///", fileName);
        try {
            return new URI(UriString);
        } catch (URISyntaxException e) {
            Trace.error(e);
        }
        return null;
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new RandomAccessFile(sourceFile, "rw").getChannel();
            destination = new RandomAccessFile(destFile, "rw").getChannel();

            long position = 0;
            long count = source.size();

            source.transferTo(position, count, destination);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
}
