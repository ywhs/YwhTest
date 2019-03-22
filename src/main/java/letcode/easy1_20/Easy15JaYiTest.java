package letcode.easy1_20;

import org.junit.Test;

import java.util.Arrays;

/**
 * CreateTime: 2019-03-21 10:47
 * ClassName: Easy15JaYiTest
 * Package: letcode.easy1_20
 * Describe:
 * 加一
 *
 * @author YWH
 */
public class Easy15JaYiTest {

    /*
        给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例 1:

        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。
        示例 2:

        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。
     */


    @Test
    public void main(){
        int[] digits = new int[]{9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }


    /**
     * 加一要在后面开始加起，当等于10时，则当前位置0，向前进位，特殊的就是第一位如果也需要进位则需要先把数组扩容后再进位。
     * @param digits 目标数组
     * @return 返回加一后的数组
     */
    private int[] plusOne(int[] digits) {
        // 初始化
        int flag = 1;
        int n = digits.length - 1;
        int maxValue = 10;

        // 给数组加最后一位加一，如果等于10 则进位
        for(int i = n; i > 0; i--){
            digits[i] += flag;
            if(digits[i] == maxValue){
                digits[i] = 0;
            }else {
                return digits;
            }
        }
        // 如果运行到这一步代表前面的数字都进位了。现在需要判断首位是否等于10，等于10需要扩容数组向前进位
        digits[0] += flag;
        if(digits[0] == maxValue){
            digits[0] = 0;
            // 在分配空间之前先把数据复制出去
            int[] tmp = digits;
            // 重新位数组分配空间
            digits = new int[n + 2];
            // 向前进位
            digits[0] = flag;
        }
        return digits;
    }


}
