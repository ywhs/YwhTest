package thinkinjava.part5;

/**
 * CreateTime: 2019-02-14 17:48
 * ClassName: Cups
 * Package: thinkinjava.part5
 * Describe:
 * 15示例的其他类
 *
 * @author YWH
 */
public class Cups {

    static Cup cup1;
    static Cup cup2;

    Cup cup3;
    Cup cup4;

    /**
     * 静态代码块
     */
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    /**
     * 代码块  如果通过类名.静态数据访问，则只会加载静态数据，不会加载此代码块和构造器
     *
     * 只有通过new出来的对象，才会进行先加载静态代码-》代码块-》构造器
     */
    {
        cup3 = new Cup(3);
        cup4 = new Cup(4);

        System.out.println("非静态代码块：Cups()");
    }


    public Cups() {
        System.out.println("Cups()");
    }
}
