package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-03-21 10:11
 * ClassName: Easy14ZuiHouYiGeDanCiDeChangDuTest
 * Package: letcode.easy1_20
 * Describe:
 * 最后一个单词的长度
 *
 * @author YWH
 */
public class Easy14ZuiHouYiGeDanCiDeChangDuTest {


    /*
        给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

        如果不存在最后一个单词，请返回 0 。

        说明：一个单词是指由字母组成，但不包含任何空格的字符串。

        示例:

        输入: "Hello World"
        输出: 5
     */


    @Test
    public void main(){
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }


    /**
     *
     * @param s 操作字符串
     * @return 最后一个字符串的长度
     */
    private int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }

}
