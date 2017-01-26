package commandline;

import classpath.ClassPath;
import utils.bprint.FullPrint;

import java.util.Arrays;

/**
 * Created by byhieg on 17/1/18.
 * Mail to byhieg@gmail.com
 */
public class Cmd {

    private String helpFlag = "help";
    private String versionFlag = "0.0.1";
    private String xJreOption = "Xjre";
    private String cpOption = "cp";
    private String className;
    private String[] args;

    public void parseCmd(String [] args) {
        if (args.length == 0) {
            System.out.println("输入相应的参数");
        } else if ("help".equals(args[0]) && args.length == 1) {
            System.out.println("help");
        } else if ("version".equals(args[0]) && args.length == 1){
            System.out.println("bjvm version " + versionFlag);
        } else if ((findArgs(args,cpOption)|| findArgs(args,xJreOption)) && args.length > 2){
            startJVM(args);
        }else{
            System.out.println("Usage: " + args[0] +" [-options] class [args...] \n");
        }
    }

    private void startJVM(String [] args){
        FullPrint.printArrays(args);
        ClassPath cp = new ClassPath().parse(args[1],"");
        String className = args[2].replace(".","/");
        byte[] bytes = cp.readClass(className);
        FullPrint.printeByteArrays(bytes);

//        String temp = "";
//        for (int i = 2; i < args.length;i++){
//            temp += args[i] + " ";
//        }
//        String str = String.format("classPath:%s, class:%s ,args:%s",args[0],args[1],temp);
//        System.out.println(str);
    }

    private boolean findArgs(String[] args,String arg){
        int length = args.length;
        for (int i = 0 ;i < length;i++){
            if (arg.equals(args[i])){
                return true;
            }
        }

        return false;
    }


    public String isHelpFlag() {
        return helpFlag;
    }

    public void setHelpFlag(String helpFlag) {
        this.helpFlag = helpFlag;
    }

    public String isVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(String versionFlag) {
        this.versionFlag = versionFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public void setCpOption(String cpOption) {
        this.cpOption = cpOption;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

}
