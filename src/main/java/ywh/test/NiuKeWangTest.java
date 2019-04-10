package ywh.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CreateTime: 2019-03-13 17:48
 * ClassName: NiuKeWangTest
 * Package: ywh.test
 * Describe: 牛客网测试题
 *
 * @author YWH
 */
public class NiuKeWangTest extends FatherClass {

    private String s = "456";

    public String str1 = "子类对象";

    private static NiuKeWangTest t;


    public NiuKeWangTest(){
//        super("123","123");
//        super.protected1();
    }


    public void test1(){
        System.out.println("子类的子的方法");
    }



    @Override
    protected void protected1(){
        System.out.println("子类的方法被调用");
    }

    public void duYou(String s){
        System.out.println("子类中独有的方法" + s);
    }


    /**
     * 关于继承的测试
     */
    @Test
    public void test2(){
        String s = "123";

        // 关于继承中相同方法和独有方法的调用

        // 第一种 父类引用，子类对象
        FatherClass fatherClass = new NiuKeWangTest();
        // 如果一个方法被子类覆盖了，调用的就是子类覆盖的方法。
        fatherClass.protected1();
        // 调用的是父类的独有的方法
        fatherClass.duYou();
        // 虽然是子类对象，但是引用确实父类引用，这种情况，只有被覆盖的方法才会调用子类中的方法，其他不覆盖的依旧是父类的方法。
//        fatherClass.duYou("123");

        // 第二种，父类引用，父类对象
        FatherClass fatherClass1 = new FatherClass();
        // 引用和对象都是父类本身，那么就算是方法被覆盖了，也会调用的是自己的方法
        fatherClass1.protected1();
        // 调用的是自己本身有的方法
        fatherClass1.duYou();
        // 父类对象不能调用子类的方法
//        fatherClass.duYou("123");


        // 第三种，子类引用，子类对象
        NiuKeWangTest niuKeWangTest = new NiuKeWangTest();
        // 会调用子类本身的方法
        niuKeWangTest.protected1();
        // 除了父类的私有方法，其他方法都可以调用
        niuKeWangTest.duYou();
        niuKeWangTest.duYou("123");




//        // 通过super关键字只能调用不是静态的成员变量， 实例化的引用也不能调用静态的成变量
//        System.out.println("" + super.str1);
//        // 静态的成员变量，只能通过类名直接访问，不能通过super关键字来获取
//        System.out.println("" + FatherClass.str2);

    }

    /**
     * ^ 这个运算符是 与 运算。
     */
    @Test
    public void test3(){
        System.out.println(9 ^ 13);
    }
}
