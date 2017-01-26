package classpath;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public class DirEntry extends Entry{

    private String absPath;

    public DirEntry(String path) {
        super(path);
        File file = new File(path);
        absPath = file.getAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) {
        String path = absPath + "/" + className;
        File file = new File(path);
        if (!file.exists()){
            throw new RuntimeException("文件找不到");
        }else{
            try {
                return getByteFromFile((int)file.length(),new FileInputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return absPath;
    }
}
