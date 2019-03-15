package ywh.shujujiegou;

import java.util.LinkedList;

/**
 * CreateTime: 2019-03-15 16:37
 * ClassName: MyQueue
 * Package: ywh.shujujiegou
 * Describe:
 * 利用linkedList模拟实现队列
 * 队列的特点就是：先进先出
 * @author YWH
 */
public class MyQueue<T> {

    private LinkedList<T> linkedList = new LinkedList<>();

    /**
     * 进入队列,后来的永远在最后一位
     * @param obj
     */
    public void push(T obj){
        linkedList.addLast(obj);
    }

    /**
     * 获取队列中首先进入的元素
     * @return 返回首先进入的元素
     */
    public T pop(){
        return linkedList.removeFirst();
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }


}
