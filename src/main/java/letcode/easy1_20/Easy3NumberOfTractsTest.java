package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-13 9:28
 * ClassName: Easy3NumberOfTractsTest
 * Package: letcode.easy1_20
 * Describe:
 * 回文数
 *
 * @author YWH
 */
public class Easy3NumberOfTractsTest {

    /**
        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

        示例 1:
        输入: 121
        输出: true

        示例 2:

        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

        示例 3:

        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。

        进阶:

        你能不将整数转为字符串来解决这个问题吗？

     */

    @Test
    public void main(){
        int x = 12321;
        System.out.println(isPalindrome(x));
    }


    /**
     * 自解  通过把数字反转后与原始数字做对比，如果相同则视为回文数
     *
     * 缺点：
     * 没有考虑到整型的范围，有可能会导致反转后溢出错误。没有考虑到最后一位是0的情况不是回文
     * @param x 输入
     * @return 是否
     */
    private boolean isPalindrome(int x) {
        if(x < 0 || (x % 10) == 0 && x != 0){
            return false;
        }

        int rec = 0;
        int tmp = x;
        try {
            while (tmp != 0) {
                // 取出最后一位
                int pop = tmp % 10;
                // 去除最后一位
                tmp /= 10;
                // 最后一位变为第一位
                rec = rec * 10 + pop;
            }
        }catch (Exception ex){
            return false;
        }

        return rec == x;
    }


    /**
     * 官方
     *
     * 思路：
     *
     * 首先去掉不可能是回文数的
     *  1. 当 < 0 时不可能时回文数
     *  2. 当原始数字最后一位是0的不可能是回文数，
     *  3. 当原始数字为0时不可能时回文数
     * 判断是否回文数，判断一半的数字就可以了，如何确定是否已经反转了过半的数字呢
     *  当原始数字 / 10 小于反转后的数字就代表已经处理了过半的数字了，就可以退出，比较去掉了过半的原始数字和过半的反转数字是否相等
     *
     *  例如 ：
     *      原始数字：1221  反转数字起始：0    条件： 1221 / 10 > 0
     *
     *      原始数字：1221 / 10 = 122
     *      反转数字：0 * 10 + 1221 % 10 = 1
     *
     *      122 > 1  true
     *
     *      原始数字：122 / 10 = 12
     *      反转数字：1 * 10 + 122 % 10 = 12
     *
     *      12 > 12  false
     *
     *      退出
     *      原始数字 == 反转数字  true    是回文数字
     *
     * 以上情况为长度为偶数的情况，当长度为奇数的时候，反转后的数字要去掉最后一位在进行判断，因为中间的数字永远等于自己
     *
     *
     * @param x 输入
     * @return 是否
     */
    public boolean isPalindrome1(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

}
