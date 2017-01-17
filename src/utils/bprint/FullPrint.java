package utils.bprint;


import java.util.List;

/**
 * Created by byhieg on 16/11/19.
 * Mail to byhieg@gmail.com
 */
public class FullPrint {

    public static <T> void printList(List<T> lists){
        System.out.println("该数组的长度是 " + lists.size());
        if(lists.size() == 0){
            System.out.println("没有元素打印出来");
            return;
        }
        System.out.println("下面为数组的值");
        int i = 1;
        for (T list : lists) {
            System.out.println("第 " + (i++) + " 项 " + list);
        }
    }

    public static void printArrays(Object[] objects){
        System.out.println("该数组的长度是 " + objects.length);
        if(objects.length == 0){
            System.out.println("没有元素打印出来");
            return;
        }
        System.out.println("下面为数组的值");
        for(int i = 0; i < objects.length;i++){
            System.out.println("第 " + (i + 1) + " 项 " + objects[i]);
        }
    }

    public static void printIntArrays(int[] arrays){
        System.out.println("该数组的长度是 " + arrays.length);
        if(arrays.length == 0){
            System.out.println("没有元素打印出来");
            return;
        }
        System.out.println("下面为数组的值");
        for(int i = 0; i < arrays.length;i++){
            System.out.println("第 " + (i + 1) + " 项 " + arrays[i]);
        }
    }

    public static void printIntArrays(int [][] arrays){
        int fLength = arrays.length;
        if(fLength == 0){
            System.out.println("没有元素");
        }
        int sLength = arrays[0].length;
        System.out.println("一共有" + fLength * sLength + "个元素");
        for(int i = 0 ; i < fLength;i++){
            System.out.print("第" + (i + 1)+ "排元素为：");
            for(int j = 0; j < sLength;j++){
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
