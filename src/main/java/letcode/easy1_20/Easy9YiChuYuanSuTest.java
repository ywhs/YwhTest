package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-18 11:12
 * ClassName: Easy9YiChuYuanSuTest
 * Package: letcode.easy1_20
 * Describe:
 * 移除元素
 *
 * @author YWH
 */
public class Easy9YiChuYuanSuTest {

    /**

         给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

         不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

         元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

         示例 1:

         给定 nums = [3,2,2,3], val = 3,

         函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

         你不需要考虑数组中超出新长度后面的元素。
         示例 2:

         给定 nums = [0,1,2,2,3,0,4,2], val = 2,

         函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

         注意这五个元素可为任意顺序。

         你不需要考虑数组中超出新长度后面的元素。

     */

    @Test
    public void main(){
        int[] nums = new int[]{3};
        int len = removeElement(nums,3);
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 自解  用法相当粗糙
     * 思路：定义一个i 为数组中的最后一位，循环判断数组中每一位是否跟目标值相等，如果相等把最后一位换到相等的位置，并且相应的减一
     * 当i <= j的时候代表已经换位到了一半，后面的也就不用判断了，因为都是相等才换到后面的。长度为i
     * @param nums
     * @param val
     * @return
     */
    private int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = nums.length;
        for(int j = 0; j < i; j++){
            while (nums[j] == val){
                i--;
                nums[j] = nums[i];
                if(i <= j){return i;}
            }
        }
        return i;
    }

    /**
     * 官方解题地址：https://leetcode-cn.com/problems/remove-element/solution/
     */


}
