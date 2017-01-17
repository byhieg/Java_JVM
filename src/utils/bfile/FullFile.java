package utils.bfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by byhieg on 16/11/19.
 * Mail to byhieg@gmail.com
 */
public class FullFile {

    public static List<File> getAllFiles(File file) {
        ArrayList<File> files = new ArrayList<>();
        if (!file.isDirectory()) {
            files.add(file);
        } else {
            File[] childFields = file.listFiles();
            for (File temp : childFields) {
                files.addAll(getAllFiles(temp));
            }
        }
        return files;
    }


}
