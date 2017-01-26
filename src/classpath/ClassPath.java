package classpath;

import java.io.File;

/**
 * Created by byhieg on 17/1/26.
 * Mail to byhieg@gmail.com
 */
public class ClassPath {

    private Entry bootClassPath;
    private Entry extClasspath;
    private Entry userClasspath;

    public ClassPath parse(String jreOption,String cpOption){
        ClassPath classPath = new ClassPath();
        classPath.parseBootAndExtClassPath(jreOption);
        classPath.parseUserClassPath(cpOption);
        return classPath;
    }

    public byte[] readClass(String className){
        className = className + ".class";
        if (bootClassPath.readClass(className) != null){
            return bootClassPath.readClass(className);
        }
        if (extClasspath.readClass(className) != null){
            return extClasspath.readClass(className);
        }
        return userClasspath.readClass(className);
    }

    @Override
    public String toString() {
        return userClasspath.toString();
    }

    public void parseBootAndExtClassPath(String jreOption){
        String jreDir = getJreDir(jreOption);
        //jre/lib
        String jreLibPath = jreDir + "/lib" + "/*";
        bootClassPath = new WildCardEntry(jreLibPath);

        //jre/lib/ext/*

        String jreExtPath = jreDir + "/lib/ext/*";
        extClasspath = new WildCardEntry(jreExtPath);
    }

    public void parseUserClassPath(String cpOption){
        if (cpOption == ""){
            cpOption = ".";
        }
        userClasspath = Entry.getEntry(cpOption);
    }

    public String getJreDir(String jreOption){
        if (jreOption != "" && exists(jreOption)){
            return jreOption;
        }
        if (exists("./jre")){
            return "./jre";
        }
        String JAVA_HOME = System.getenv("JAVA_HOME");
        if (JAVA_HOME != null){
            return JAVA_HOME + "/jre";
        }
        return null;
    }

    public boolean exists(String path){
        if (new File(path).exists()){
            return true;
        }else {
            return false;
        }
    }


}
