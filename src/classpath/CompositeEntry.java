package classpath;

import javax.security.auth.callback.ConfirmationCallback;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public class CompositeEntry extends Entry{


    private List<Entry> entries = new ArrayList<>();

    public CompositeEntry(String path) {
        super(path);
        String[] paths = path.split(pathListSeparator);
        for(int i = 0 ;i < paths.length;i++){
            entries.add(getEntry(path));
        }
    }

    @Override
    byte[] readClass(String className) {
        for (int i = 0 ; i < entries.size();i++){
            if (entries.get(i).readClass(className) != null){
                return entries.get(i).readClass(className);
            }
        }
        return null;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
