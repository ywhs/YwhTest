package ywh.shujujiegou;

import org.junit.Test;
import org.openqa.selenium.interactions.SourceType;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;

/**
 * CreateTime: 2019-03-15 16:06
 * ClassName: STest
 * Package: ywh.shujujiegou
 * Describe:
 * 测试
 *
 * @author YWH
 */
public class STest {


    @Test
    public void stackTest(){
        MyStack<String> myStack = new MyStack<>();

        myStack.push("123");
        myStack.push("456");
        myStack.push("789");

        System.out.println("栈的大小 => " + myStack.size());
        System.out.println("栈顶元素 => " + myStack.showFirst());
        while(!myStack.isEmpty()){
            System.out.println("出栈的元素 => " + myStack.pop());
        }
        System.out.println("栈的大小 => " + myStack.size());
    }


    @Test
    public void queueTest(){
        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.push("我是第一个进入的");
        myQueue.push("我是第二个进入的");
        myQueue.push("我是第三个进入的");
        myQueue.push("我是第四个进入的");

        while (!myQueue.isEmpty()){
            System.out.println("元素 => " + myQueue.pop());
        }
    }



}
