package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-02-18 10:16
 * ClassName: Easy8ShanChuPaiXuChongFuDeShuTest
 * Package: letcode.easy1_20
 * Describe:
 * 删除重复的数字，并且返回数组新的长度
 *
 * @author YWH
 */
public class Easy8ShanChuPaiXuChongFuDeShuTest {


    /**
         给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

         不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

         示例 1:

         给定数组 nums = [1,1,2],

         函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

         你不需要考虑数组中超出新长度后面的元素。
         示例 2:

         给定 nums = [0,0,1,1,1,2,2,3,3,4],

         函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

         你不需要考虑数组中超出新长度后面的元素。
         说明:

         为什么返回数值是整数，但输出的答案是数组呢?

         请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

         你可以想象内部操作如下:

         // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
         int len = removeDuplicates(nums);

         // 在函数里修改输入数组对于调用者是可见的。
         // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
         for (int i = 0; i < len; i++) {
         print(nums[i]);
         }

     */

    @Test
    public void main(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for(int i = 0;i < len; i++){
            System.out.println(nums[i]);
        }
    }


    /**
     *  官方解法：双指针法， 这个题主要是输出数组中不重复的数据，并不是真正的删除了数组中重复的数据。
     *
     *  思路：默认指针i为数组不重复的长度并且指向第一位，指针j指向第二位，两数相比较，当两个数值不相等意味着数组有两位是可以输出的，所以i加一
     *  两数相等，直接跳过，因为代表着相等了，等找到不相等的数字时，把i的后一位覆盖掉
     *
     *  不用考虑数组后面的元素会有前面的元素，因为这是一个排序数组
     *
     *
     * @param nums 数组
     * @return 不重复数组的长度
     */
    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                // 两个数不相等时，把不相等的数值提前
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
