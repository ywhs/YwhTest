package letcode.day01;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * CreateTime: 2019-02-12 13:57
 * ClassName: Numofsum
 * Package: letcode.day01
 * Describe:
 * 两数之和，
 *
 * @author YWH
 */
public class Numofsum {

    /**
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */


    /**
     * Arrays.toString 能输出数组中的各项数据，
     * 假如a是一个数组 a.toString()只能输出地址 并不能输出数组内容。
     */
    @Test
    public void main(){
        int[] nums = {2,7,11,15};
        int target = 22;
        int[] response = twoSum3(nums, target);
        System.out.println(Arrays.toString(response));
    }

    /**
     *  自解   用了非常笨的方法，为暴力法，还做了非常多不必要的操作，比如 第二个for循环中
     *  j的起始值可以是i + 1 ,这样就不用判断i==j了，因为索引中的[0,1]和[1，0] 是重复的，没有必要跟之前的值相加
     *  还有 当判断两个值等于目标值时，可以直接返回return index即可
     * @param nums 数组
     * @param target 目标值
     * @return 返回坐标值
     */
    private int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        a: for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++) {
                if(i == j){
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    break a;
                }
            }
        }
        return index;
    }

    /**
     *  官方暴力法, 虽说怎么实现都行，但是这个就是充分利用了java的知识，以及代码非常简洁。
     * @param nums  数组
     * @param target 目标值
     * @return 返回坐标值
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 官方 两遍哈希表
     *
     * 首先把数组中的值跟索引值放到hash表中，key值为数组中的值，value值为下标索引值；
     * 通过第二次for循环，目标值减去数组中的值，得到的结果在hash表中是否有对应，不能是本身
     * 如果有对应，则把当前索引值返回去。
     *
     * map.containsKey(complement) 判断这个值 在hash表中是否有这个key值。
     *
     * @param nums 数组
     * @param target 目标值
     * @return 返回坐标值
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     *  官方 一遍哈希表
     *
     * 一遍哈希表的思路是，当我们碰到目标值减去相应的数值后得到的complement 存在数组nums中，但是不存在map中，这时我们只是得到了一个数值的下标，
     * 往下走再次碰到目标值减去相应的数值后得到的complement必然要存在map中，这时把当前i值和获取到的map中key值返回即可
     *
     * 例如 9 - 2 = 7 这时的7 在map中肯定没有这个key值，那么继续往下走 把当前的2存入到map中。
     *  当 9 - 7 = 2 时，2这个值肯定在 map中有这个key值  就把当前i值   7 的索引，和 2为key值获取的value返回就是两个数的索引值了。
     *
     * @param nums 数组
     * @param target 目标值
     * @return 返回坐标值
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
