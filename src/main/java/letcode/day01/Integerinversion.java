package letcode.day01;

import org.junit.Test;

/**
 * CreateTime: 2019-02-12 15:39
 * ClassName: Integerinversion
 * Package: letcode.day01
 * Describe:
 * 整数反转
 *
 * @author YWH
 */
public class Integerinversion {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */


    public void gg(int num){
        int wanWei=num/10000;
        int qianWei=num%10000/1000;
        int baiWei=num%1000/100;
        int shiWei=num%100/10;
        int geWei=num%10;
    }


    @Test
    public void main(){
        int x = 4321;
        int y = reverse(x);
        System.out.println(y);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 自解 完全使用的是官方的算法，
     *  思路为：通过取余10把最后一位拿出来，把原本的数整出10去掉最后一位，rev * 10 + 拿出来的就可以把数倒过来了
     *  而判断是否超出范围，则是通过，再没有加最后一位的情况下跟最大范围的数/10进行判断，如果大于则代表不加最后一位也超过了
     *  或者 等于最大范围/10 就要判断最后一位是否大于7 如果大于7 也是代表超过了   最大数范围是：2147483647
     *
     *  判断最小范围时，与最大范围相似，最小范围是：-2147483648
     *
     *
     *  而为什么要与刨除最后一位判断呢，是因为要在加最后一位之前判断才能判断出是否超出了范围，否则直接超出或者根本没法判断（位数不同）
     * @param x 给定的值
     * @return 返回反转的值
     */
    @SuppressWarnings("all")
    private int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }



    /**
     * 官方
     * @param x 给定的值
     * @return 返回反转的值
     */
    private int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
