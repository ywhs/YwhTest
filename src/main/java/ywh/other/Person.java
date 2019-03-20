package ywh.other;

import com.sun.istack.internal.NotNull;

import javax.annotation.CheckForNull;

/**
 * CreateTime: 2019-03-19 8:59
 * ClassName: Person
 * Package: ywh.other
 * Describe:
 * 人的对象实体类
 *
 * @author YWH
 */
public class Person {

    private String name;

    private Integer age;

    public Person(){
        super();
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person [name=" + name + ", age=" + age + "]";
    }


    /**
     * 要让hash表存储不重复的元素，就必须重写hashCode和equals方法
     * @return
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * equals方法两者相同时返回true，
     * @param person
     * @return
     */
    @Override
    public boolean equals(Object person){
        if(!(person instanceof Person)){
            try {
                throw new ClassNotFoundException("类型不正确");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (this == person) {
            return true;
        }
        if (getClass() != person.getClass()){
            return false;
        }
        Person other = (Person) person;
        if (!age.equals(other.age)) {
            return false;
        }
        if (name == null) {
            return other.name == null;
        } else{
            return name.equals(other.name);
        }
    }

}
