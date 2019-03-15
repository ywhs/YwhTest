package ywh.shujujiegou;

import org.junit.Test;

import java.util.LinkedList;

/**
 * CreateTime: 2019-03-15 15:36
 * ClassName: MyStack
 * Package: ywh.shujujiegou
 * Describe:
 * 利用LinkedList实现的栈
 * 栈的特点：先进后出
 * @author YWH
 */
public class MyStack<T> {

    private LinkedList<T> linkedList = new LinkedList<>();


    /**
     * 压栈
     * @param obj 压栈的数据
     */
    public void push(T obj){
        // 因为栈的工作方式就是入栈的元素一般都在栈顶，直到下一个元素加入进来
        linkedList.addFirst(obj);
    }

    /**
     * 出栈
     */
    public T pop(){
        // 遵循 先进后出的原则，   在最后一个进入的一定是最先出去的，所以移除栈顶元素即可
        return linkedList.removeFirst();
    }

    /**
     * 查看栈顶数据
     */
    public T showFirst(){
        return linkedList.peek();
    }

    /**
     * 栈的大小
     * @return 返回int类型的栈大小
     */
    public int size(){
        return linkedList.size();
    }

    /**
     * 判断栈内是否为空
     * @return 布尔值 为空返回true，不为空返回false
     */
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }


}
