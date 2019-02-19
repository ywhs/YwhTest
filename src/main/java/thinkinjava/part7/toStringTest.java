package thinkinjava.part7;

import org.junit.Test;
import thinkinjava.part6.Dinner;

/**
 * CreateTime: 2019-02-18 17:54
 * ClassName: toStringTest
 * Package: thinkinjava.part7
 * Describe:
 * 测试toString方法会自动调用吗
 *
 * @author YWH
 */
public class toStringTest {


    /**
     * 当我们在一个类中重写toString方法时，我们使用引用输出时，他会自动调用toString方法，隐式调用
     * 返回String类型并输出，当我们没有重写toString方法，他会输出类的权限定名加地址的形式,就算显示调用toString，也是输出权限定名的形式，
     * 因为他默认也是隐式调用了默认的toString方法
     */
    @Test
    public void main(){
        Dinner dinner = new Dinner();
        System.out.println("dinner:" + dinner.toString());
    }



}
