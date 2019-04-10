package ywh.test;

import org.junit.Test;
import ywh.other.Person;

import java.util.*;
import java.util.concurrent.BlockingQueue;

/**
 * CreateTime: 2019-03-19 10:24
 * ClassName: ListTest
 * Package: ywh.test
 * Describe:
 * 集合测试
 *
 * @author YWH
 */
public class ListTest {

    /**
     * 在Map/Set中   自定义对象作为Key值时必须重写hashcode和equals方法才能保证数据的不重复
     * 测试 是否可以存储重复的数据
     */
    @Test
    public void setListTest(){
        Set<Person> set = new HashSet<>();

        set.add(new Person("张三",12));
        set.add(new Person("李四",13));
        set.add(new Person("王五",22));
        set.add(new Person("张三",12));
        System.out.println("qweqweqweqw" + " " + "1");
        for(Person str : set){
            System.out.println("人 =>" + str);
        }
    }

    /**
     * 在一个字符串中查找每个字符重复的次数
     */
    @Test
    public void test(){
        String a = "1185564686682";
        HashMap<Character,Integer> map = new HashMap<>(100);
        Integer count = 1;
        for(int i = 0; i < a.length(); i++){
            if(map.containsKey(a.charAt(i))){
                Integer count1 = map.get(a.charAt(i));
                count1++;
                map.put(a.charAt(i),count1);
            }else {
                map.put(a.charAt(i),count);
            }
        }
        for(Character key : map.keySet()){
            System.out.println("字符 => " + key + " = 重复的有" + map.get(key) + "个");
        }
    }

    /**
     * 包装类型应该一直使用equals来比较值，基本类型可以使用==来比较值的大小
     */
    @Test
    public void test1(){
        String s = "123";
        String s1 = "1231";
        Integer n1 = 1;
        Integer n2 = 1;

        int i = 1;
        int i1 = 1;

        Person a = new Person("ywh",23);
        Person b = new Person("ywh",23);
        if(!s.equals(s1)){
            System.out.println("字符串不相等");
        }
        if(!n1.equals(n2)){
            System.out.println("数值不相等");
        }
        if(a != b){
            System.out.println("对象不相等");
        }
        if(i != i1){
            System.out.println("数值不相等");
        }
        System.out.println(s.compareTo(s1));
    }

    /**
     * 测试arrList和linkedList
     */
    @Test
    public void test2(){
        LinkedList<String> lianbiao = new LinkedList<>();
        lianbiao.add("123123");
        lianbiao.add("456");
        lianbiao.add("789");
        ArrayList<String> lianbiao1 = new ArrayList<>();
        lianbiao1.add("123");
        lianbiao1.add("456");
        lianbiao1.add("789");
        lianbiao1.remove("789");
        System.out.println("peek => " + lianbiao.peek());
        System.out.println("lianbiao1 => " + lianbiao1.size());
    }





}
