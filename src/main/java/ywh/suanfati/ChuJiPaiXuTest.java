package ywh.suanfati;

import org.junit.Test;

public class ChuJiPaiXuTest {


    @Test
    public void main(){
        Integer[] a = new Integer[]{4,7,3,9,1};
//        xuanZePaiXu(a);
        chaRuPaiXu(a);
        MoBanUtils.show(a);
    }


    /**
     * 选择排序
     */
    private void xuanZePaiXu(Comparable[] a){
        int length = a.length;
        for(int i = 0; i < length; i++){
            int min = i;
            for(int j = i + 1; j < length; j++){
                // 与最小值进行判断大小，如果小于最小值，则把最小值的指针改变
                if(MoBanUtils.less(a[j],a[min])){
                    min = j;
                }
                // 交换
                MoBanUtils.exch(a,i, min);
            }
        }
    }

    /**
     * 插入排序
     * @param a
     */
    private void chaRuPaiXu(Comparable[] a){
        int length = a.length;
        for(int i = 1; i < length; i++){
            // 默认左边排序都是有序的
            for(int j = i; j > 0 && MoBanUtils.less(a[j],a[j-1]); j--){
                MoBanUtils.exch(a,j,j-1);
            }
        }
    }



}
