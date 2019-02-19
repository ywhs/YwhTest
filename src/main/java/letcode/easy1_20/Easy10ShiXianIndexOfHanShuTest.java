package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-18 16:44
 * ClassName: Easy10ShiXianIndexOfHanShuTest
 * Package: letcode.easy1_20
 * Describe:
 * 实现indexOf函数
 *
 * @author YWH
 */
public class Easy10ShiXianIndexOfHanShuTest {


    /**


         实现 strStr() 函数。

         给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

         示例 1:

         输入: haystack = "hello", needle = "ll"
         输出: 2
         示例 2:

         输入: haystack = "aaaaa", needle = "bba"
         输出: -1
         说明:

         当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

         对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

     */

    @Test
    public void main(){
        String haystack = "mississippi";
        String needle = "issipp";
        String haystack1 = "1223";
        String needle1 = "232";
        System.out.println(strStr(haystack,needle));
    }


    /**
     * 自解
     * 思路：
     *  评论中有说要用KMP算法，但是作为简单题，应该是不用那么难的算法，
     *  也算是暴力搜索吧，拿每一列的字符与主字符串相比较，如果最后退出的时候，j的值与匹配字符串长度一致，代表找到了存在的位置。
     * @param haystack 被查找的字符串
     * @param needle 查找的字符串
     * @return 返回第一次出现的位置
     */
    private int strStr(String haystack, String needle) {
        // 首先判断特殊情况
        if(needle.length() == 0){return 0;}
        // 当一个字符存在另一个字符时，必然存在首尾字符
        // 小于等于 主字符串长度-匹配字符串长度，是因为后面的字符长度都不够匹配字符串的长度了，自然不可能匹配。
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            int j = 0;
            for(; j < needle.length(); j++){
                // 判断匹配字符串和主字符串的每一列匹配，如果不相等则退出循环。
                if(needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            // j == 匹配字符串长度，代表找到了第一个出现的位置，直接返回i的位置即可
            if(j == needle.length()){return i;}
        }

        return -1;
    }


}
