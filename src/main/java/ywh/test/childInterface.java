package ywh.test;

/**
 * CreateTime: 2019-03-15 11:57
 * ClassName: childInterface
 * Package: ywh.test
 * Describe:
 * 孩子接口
 *
 * @author YWH
 */
public class childInterface<T> implements FatherInterface<T> {


    @Override
    public String setStr(T arg) {
        return String.valueOf(arg);
    }
}
