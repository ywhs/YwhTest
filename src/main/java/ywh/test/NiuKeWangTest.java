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
        super("123","123");
        super.protected1();
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

    @Test
    public void test2(){
        String s = "123";
        System.out.println("s => " + s);
        FatherClass fatherClass1 = new NiuKeWangTest();
        FatherClass fatherClass2 = new FatherClass();
        // 如果是父类对象调用被覆盖的方法，会找自己的方法，如果是子类对象也会找到自己方法调用
        fatherClass1.protected1();
        // 当子类中没有这个方法时，才会去找父类中的方法,父类并不具备子类中的方法
        fatherClass1.duYou();
        fatherClass2.str1 = "123";
        // 通过super关键字只能调用不是静态的成员变量， 实例化的引用也不能调用静态的成变量
        System.out.println("" + super.str1);
        // 静态的成员变量，只能通过类名直接访问
        System.out.println("" + FatherClass.str2);
//        System.out.println("" + super.str2);
        LinkedList<String> lianbiao = new LinkedList<>();
        lianbiao.add("123123");
        lianbiao.add("456");
        lianbiao.add("789");
        ArrayList<String> lianbiao1 = new ArrayList<>();
        lianbiao1.add("123");
        lianbiao1.add("456");
        lianbiao1.add("789");
        String second = lianbiao.get(1);
        String second1 = lianbiao1.get(1);
        int size = 3;
        System.out.println("size => " + (size >> 1));
        System.out.println("peek => " + lianbiao.peek());

        NiuKeWangTest niuKeWangTest = new NiuKeWangTest();
    }
}
