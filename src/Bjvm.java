import commandline.Cmd;
import utils.bprint.FullPrint;

/**
 * Created by byhieg on 17/1/18.
 * Mail to byhieg@gmail.com
 */
public class Bjvm {

    public static void main(String[] args) {
        Cmd cmd = new Cmd();
        cmd.parseCmd(args);
    }
}
