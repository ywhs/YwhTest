package letcode.easy1_20;

import org.junit.Test;
import org.openqa.selenium.interactions.SourceType;

/**
 * CreateTime: 2019-02-27 17:41
 * ClassName: Easy13ZuiDaZiXuHeTest
 * Package: letcode.easy1_20
 * Describe:
 * 最大子序和
 *
 * @author YWH
 */
public class Easy13ZuiDaZiXuHeTest {

    /*
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

        示例:

        输入: [-2,1,-3,4,-1,2,1,-5,4]
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        进阶:

        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    @Test
    public void main(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("最大子序和 => " + maxSubArray(nums));
    }

    /**
     *
     * @param nums 数组
     * @return 最大和
     */
    private int maxSubArray(int[] nums) {



        return 1;
    }

}
