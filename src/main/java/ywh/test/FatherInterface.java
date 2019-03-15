package ywh.test;

/**
 * CreateTime: 2019-03-15 11:54
 * ClassName: FatherInterface
 * Package: ywh.test
 * Describe:
 * 父类接口
 *
 * @author YWH
 */
public interface FatherInterface<T> {

    /**
     *  设置字符串
     * @param arg 参数
     * @return 返回String类型
     */
    String setStr(T arg);

}
