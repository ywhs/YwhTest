package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-19 11:12
 * ClassName: Easy11SouSuoChaRuWeiZhiTest
 * Package: letcode.easy1_20
 * Describe:
 * 搜索插入位置
 *
 * @author YWH
 */
public class Easy11SouSuoChaRuWeiZhiTest {


    /**


         给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

         你可以假设数组中无重复元素。

         示例 1:

         输入: [1,3,5,6], 5
         输出: 2
         示例 2:

         输入: [1,3,5,6], 2
         输出: 1
         示例 3:

         输入: [1,3,5,6], 7
         输出: 4
         示例 4:

         输入: [1,3,5,6], 0
         输出: 0


     */


    @Test
    public void main(){
        int[] nums = new int[]{1,3,5,6};
        int target = 3;
        System.out.println(searchInsert(nums,target));
    }

    /**
     * 自解
     * 思路： 前提 数组是有序数组
     *  遍历当前数组，查找与目标值相同的数值，如果找到一个数字比目标值大或者等于就返回当前i
     *  因为如果找到的数字比目标值大，说明后面不可能有目标值了，把目标值插入当前位置返回i即可
     * @param nums 有序数组
     * @param target 目标值
     * @return 返回目标值索引位置，或者插入位置
     */
    private int searchInsert(int[] nums, int target) {

        if(nums.length == 0 || nums[0] >= target){return 0;}
        int i = 1;
        for(; i < nums.length; i++){
            if(nums[i] >= target){return i;}
        }
        return i;
    }

}
