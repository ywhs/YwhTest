package ywh.suanfati;

/**
 * CreateTime: 2019-03-13 22:01
 * ClassName: MoBanUtils
 * Package: ywh.suanfati
 * Describe:
 * 模板工具类
 *
 * @author YWH
 */
public class MoBanUtils {

    /**
     * 比较大小
     * @param a 实现了Comparable接口的类型
     * @param b 实现了Comparable接口的类型
     * @return true false
     */
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)  < 0;
    }

    /**
     * 把两个元素交换位置
     * @param a 实现了Comparable接口的类型数组
     * @param i 索引值
     * @param j 索引值
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    /**
     * 输出数组中的内容
     * @param comparable 可排序的数组
     */
    public static void show(Comparable[] comparable){
        for(int i = 0; i< comparable.length; i++){
            System.out.println(comparable[i] + "");
        }
    }

}
