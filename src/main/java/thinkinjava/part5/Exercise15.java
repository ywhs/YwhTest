package thinkinjava.part5;

import java.util.Stack;

/**
 * CreateTime: 2019-02-14 17:17
 * ClassName: Exercise15
 * Package: thinkinjava.part5
 * Describe:
 * 初始化，静态和非静态
 *
 * @author YWH
 */
public class Exercise15 {

    /**
     * 初始化的加载顺序
     *
     * 1.先加载静态数据
     * 2.加载非静态数据
     * 3.构造器
     *
     *
     */

//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();

    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        //
        System.out.println("Inside main()");
        Cups.cup1.f(99);

        // 基本类型用 == 代表比较的是值本身是否相等，而复合类型（其他类）表示对比的是引用，当Integer类型超过-128~127的范围则会新new一个对象
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }


    void bite(){
        System.out.println("测试用例，可以访问此方法。");
    }



}
