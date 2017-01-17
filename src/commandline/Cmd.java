package commandline;

import java.util.Arrays;

/**
 * Created by byhieg on 17/1/18.
 * Mail to byhieg@gmail.com
 */
public class Cmd {

    private String helpFlag = "help";
    private String versionFlag = "0.0.1";

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
        } else if (cpOption.equals(args[0]) && args.length > 2){
            String [] temp = new String[args.length - 1];
            System.arraycopy(args,1,temp,0,args.length - 1);
            startJVM(temp);
        }else{
            System.out.println("Usage: " + args[0] +" [-options] class [args...] \n");
        }
    }

    private void startJVM(String [] args){
        String temp = "";
        for (int i = 2; i < args.length;i++){
            temp += args[i] + " ";
        }
        String str = String.format("classPath:%s, class:%s ,args:%s",args[0],args[1],temp);
        System.out.println(str);
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
