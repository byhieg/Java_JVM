package classpath;

import utils.bprint.FullPrint;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public class WildCardEntry extends Entry {

    private List<Entry> entries = new ArrayList<>();

    public WildCardEntry(String path) {
        super(path);
        String baseDir = path.substring(0,path.length() - 1);
        File file = new File(baseDir);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0 ; i< files.length;i++){
                File item = files[i];
                if (!item.isDirectory()){
                    if (item.getPath().endsWith(".jar") || item.getPath().endsWith(".JAR")){
                        Entry jarEntry = new ZipEntry(item.getPath());
                        entries.add(jarEntry);
                    }
                }
            }

        }
    }

    @Override
    byte[] readClass(String className) {
        for (int i = 0 ; i < entries.size();i ++){
            byte[] bytes = entries.get(i).readClass(className);
            if (bytes != null){
                return bytes;
            }
        }
        return null;
    }
}
