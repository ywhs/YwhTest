package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-20 10:45
 * ClassName: Easy12BaoShuTest
 * Package: letcode.easy1_20
 * Describe:
 * 报数
 *
 * @author YWH
 */
public class Easy12BaoShuTest {

    /**

        报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 被读作  "one 1"  ("一个一") , 即 11。
        11 被读作 "two 1s" ("两个一"）, 即 21。
        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

        注意：整数顺序将表示为一个字符串。



        示例 1:

        输入: 1
        输出: "1"
        示例 2:

        输入: 4
        输出: "1211"

     */


    @Test
    public void main(){
        int n = 6;
        System.out.println(countAndSay(n));
    }


    /**
     * 自解
     * 思路：
     *  如果相同数字，我们先记录相同数字的个数，当不相等时，把个数*10 + 数字拼接到String类型当中，再把个数清零，当前字符替换掉
     *  退出时，个数不为0即剩余字符相同
     * @param n 第几层   1 <= x <= 30
     * @return 返回第几层数据  String类型
     */
    private String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            // 每次查询都取第一个作为比较对象
            char c = s.charAt(0);
            int z = 1;
            StringBuilder newStr = new StringBuilder("");
            // 因为j的起始值为1，代表只要进入for循环，个数相同的肯定要加1
            for(int j = 1; j < s.length(); j++){
                if(c != s.charAt(j)){
                    // 当c与当前值不相等时，我们就把当前的个数z和c拼接到一个新的字符串中
                    int a = z * 10 + Integer.valueOf(String.valueOf(c));
                    newStr.append(String.valueOf(a));
                    c = s.charAt(j);
                    z = 0;
                }
                // 相同数字加1
                z += 1;
            }
            // 当退出内层循环时，z值没有被清0，代表退出时剩余的字符全部一样，要把个数和数值拼接在一起
            if(z != 0){
                int a = z * 10 + Integer.valueOf(String.valueOf(c));
                newStr.append(String.valueOf(a));
            }
            s = String.valueOf(newStr);
        }
        return String.valueOf(s);
    }





}
