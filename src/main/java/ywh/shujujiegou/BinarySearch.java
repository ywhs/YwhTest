package ywh.shujujiegou;

import org.junit.Test;

/**
 * CreateTime: 2019-03-18 16:54
 * ClassName: BinarySearch
 * Package: ywh.shujujiegou
 * Describe:
 * 二分查找,查找目标元素在什么位置
 *
 * @author YWH
 */
public class BinarySearch {

    /*
        1、计算出数组中的中间元素，与目标值相比较，如果相等则返回
        2、否则根据中间元素分为前后两个子标，并且判断中间元素是否大于目标值，如果大于目标值
        3、则查找前一张表
           重复以上三个步骤就是二分查找
     */

    @Test
    public void main(){
        Integer[] srcArray = new Integer[]{1,2,3,4,5,6,7,8,9};
        int des = 8;
        System.out.println("索引值 => " + binarySearch(srcArray, des));
    }





    private int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值 //防止溢出
            int middle = (high + low)>>>1 ;
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

}
