package ywh.inputandoutput;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * CreateTime: 2019-03-20 14:40
 * ClassName: File01
 * Package: ywh.inputandoutput
 * Describe:
 * 操作文件
 *
 * @author YWH
 */
public class File01 {

    private static final Logger LOG = LoggerFactory.getLogger(File01.class);

    private final String[] s = new String[]{"1","2","3","4"};

    @Test
    public void test1(){
        try{
            File file = new File("/Ywh");
            String regex = ".rar";
            String[] list = file.list(new DirFilter(regex));
            assert list != null;
            for(String str : list){
                System.out.println(str);
            }
        }catch (Exception e){
            LOG.error("操作文件出错！！",e);
        }
    }

    /**
     * 文件 过滤器，过滤掉不想要的，返回想要的，会为每一个文件都执行accept方法。
     */
    public static class DirFilter implements FilenameFilter{
        private String type;
        public DirFilter(String regex){
            type = regex;
        }
        @Override
        public boolean accept(File dir, String name) {
            System.out.println("name =>" + name);
            return name.endsWith(type);
        }
    }

    /**
     * String类型中内建的正贼表达式
     */
    @Test
    public void patternTest(){
        String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!";
        System.out.println("-123".matches("-?\\d+"));
        System.out.println("123".matches("-?\\d+"));
        System.out.println("+123".matches("-?\\d+"));
        System.out.println("+123".matches("([-+])?\\d+"));
        System.out.println("+123".matches("(-|\\+)?\\d+"));
        System.out.println("以空字符串为分隔符 => " + Arrays.toString(knights.split(" ")));
        System.out.println("以非单词字符为分隔符 => " + Arrays.toString(knights.split("\\W+")));
        System.out.println("以指定字符后面跟着非字符为隔符 => " + Arrays.toString(knights.split("n\\W+")));

        System.out.println("替换指定的字符 => " + knights.replaceFirst("f\\w+\\W+","ywh"));
        System.out.println("替换指定的字符 => " + knights.replaceAll("f\\w+\\...","ywh"));

        System.out.println("匹配手机号 => " + "1554733931".matches("^1[34578]\\d{9}$"));

    }



}
