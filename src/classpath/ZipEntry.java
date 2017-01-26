package classpath;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public class ZipEntry extends Entry{

    private String absPath;

    public ZipEntry(String path) {
        super(path);
        File file = new File(path);
        absPath = file.getAbsolutePath();
        System.out.println(absPath);
    }

    @Override
    byte[] readClass(String className) {
        System.out.println("===========" +   className);
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(absPath);
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()){
                JarEntry entry = (JarEntry)entries.nextElement();
                String name = entry.getName();
                if (name.equals(className)){
                    InputStream input = jarFile.getInputStream(entry);
                    return getByteFromFile(jarFile.size(),input);
                }
            }
//            zf = new JarFile(absPath);
//            InputStream in = new BufferedInputStream(new FileInputStream(absPath));
//            ZipInputStream zin = new ZipInputStream(in);
//            java.util.zip.ZipEntry ze;
//
//            while ((ze = zin.getNextEntry()) != null) {
//                if (className.equals(ze.getName())){
//                    long size = ze.getSize();
//                    if (size > 0) {
//                        return getByteFromFile((int)ze.getSize(),zf.getInputStream(ze));
//                    }
//                }
//            }
//            zin.closeEntry();
        } catch (Exception e) {
            System.out.println("找不到文件，请忽略");
        }
        return null;
    }

    @Override
    public String toString() {
        return absPath;
    }
}
