package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-13 14:36
 * ClassName: Easy5ZuiChangQianZhuiTest
 * Package: letcode.easy1_20
 * Describe:
 * 最长前缀
 *
 * @author YWH
 */
public class Easy5ZuiChangQianZhuiTest {

    /**

         编写一个函数来查找字符串数组中的最长公共前缀。

         如果不存在公共前缀，返回空字符串 ""。

         示例 1:

         输入: ["flower","flow","flight"]
         输出: "fl"
         示例 2:

         输入: ["dog","racecar","car"]
         输出: ""
         解释: 输入不存在公共前缀。
         说明:

         所有输入只包含小写字母 a-z 。


     */

    @Test
    public void main(){
        String[] strs = {"flower","","xlight"};
        System.out.println(longestCommonPrefix2(strs));
    }

    /**
     *  自解   没有想出来，采用官方的水平扫描法
     *  在这里应用了两个String类型的方法。
     *      indexOf()   返回一个字符串在另一个字符串中是否存在，返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *      charAt()    返回指定索引的字符
     * @param strs 输入的字符串数组
     * @return 返回公共的前缀
     */
    private String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){ return "";}
        // 首先默认取一个字符串作为公共前缀字符串
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 不等于0代表prefix在某个字符串中不存在,如果存在必然存在第一位，索引值为0，进行相应的对比，直到找到公共的前缀字符
            while (strs[i].indexOf(prefix) != 0) {
                // 前缀减去最后一位
                prefix = prefix.substring(0, prefix.length() -1);
                // 如果字符串prefix变为了空，代表着没有任何公共的字符前缀
                if(prefix.isEmpty()){return "";}

            }
        }
        return prefix;
    }

    /**
     * 官方水平扫描法
     *  思路如上
     * @param strs 输入字符数组
     * @return 返回公共字符串
     */
    private String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * 官方水平扫描法2
     * 思路：
     *      一个一个字符相比较，通过使用charAt()方法，先取出一个字符，与其他字符串元素中相同索引的字符相比较，不相同则结束。
     *      一列一列比较。
     * @param strs 输入字符数组
     * @return 返回公共字符串
     */
    private String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // 循环数组中某一个字符串的长度，比较每一个字符在其他字符串中是否有这个字符
        for (int i = 0; i < strs[0].length() ; i++){
            // charAt返回指定索引中的字符
            char c = strs[0].charAt(i);
            // 循环数组，判断每一个字符串元素是否有该字符 c
            for (int j = 1; j < strs.length; j ++) {
                // 判断条件为：当i的值为某一个字符串的长度，代表着此公共前缀的长度最大为i不可能再长了，不需要担心下一个字符串是空的
                // 如果为空的话，则代表没有公共前缀，此时i必然为0，返回的值也就为空值字符串。
                // 或者 某一个元素字符串中相同索引下的字符不等于取出来的字符，代表着没有相同字符串了，此时返回必然是公共前缀了。
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 官方给的还有分治法，通过把数组中的元素分割后各自算各自的，然后再统一算公共部分
     */
    /**
     * 二分查找算法
     */
}

