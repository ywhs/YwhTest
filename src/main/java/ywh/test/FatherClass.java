package ywh.test;

/**
 * CreateTime: 2019-03-13 17:48
 * ClassName: FatherClass
 * Package: ywh.test
 * Describe:
 * 父类
 *
 * @author YWH
 */
public class FatherClass {

    private String str;

    public String str1 = "父类的成员变量";
    public static String str2 = "父类的静态成员变量";

    public FatherClass(){
        System.out.println("无参构造器！！！");
    }

    private FatherClass(String str){
        System.out.println("私有的有参构造器 => " + str);
    }

    FatherClass(String str, String str1){
        System.out.println(String.format("默认修饰符的两参构造器 => {%s},{%s}",str,str1));
    }



    private void private1(){
        System.out.println("私有方法1！！！！！");
    }

    protected void protected1(){
        System.out.println("父类方法被调用");
    }

    public void duYou(){
        System.out.println("父类独有的方法！！");
    }

}
