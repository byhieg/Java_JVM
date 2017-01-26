package classpath;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public abstract class Entry {

    public Entry(String path) {

    }

    static String pathListSeparator = ";";

    abstract byte[] readClass(String className);

    public static Entry getEntry(String path) {
        if (path.contains(pathListSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildCardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith("ZIP")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }

    public String getPathListSeparator() {
        return pathListSeparator;
    }

    public void setPathListSeparator(String pathListSeparator) {
        this.pathListSeparator = pathListSeparator;
    }

    public byte[] getByteFromFile(int size, InputStream in) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) size);
        BufferedInputStream inputStream = new BufferedInputStream(in);
        int buffSize = 1024;
        byte[] bytes = new byte[buffSize];
        int len;
        while (-1 != (len = inputStream.read(bytes, 0, buffSize))) {
            bos.write(bytes, 0, len);
        }
        return bos.toByteArray();

    }
}
