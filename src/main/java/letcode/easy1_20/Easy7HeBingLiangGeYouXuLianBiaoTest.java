package letcode.easy1_20;

import org.junit.Test;

import java.util.List;

/**
 * CreateTime: 2019-02-15 13:44
 * ClassName: Easy7HeBingLiangGeYouXuLianBiaoTest
 * Package: letcode.easy1_20
 * Describe:
 * 合并两个有序链表
 *
 * @author YWH
 */
public class Easy7HeBingLiangGeYouXuLianBiaoTest {


    /**

        将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

        示例：

        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4

     */

    @Test
    public void main(){
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(1);
            l1.next = new ListNode(1);
            l2.next = new ListNode(1);
            l1.next.val = 2;
            l2.next.val = 3;
            l1.next.next = new ListNode(1);
            l2.next.next = new ListNode(1);
            l1.next.next.val = 4;
            l2.next.next.val = 4;
            System.out.println(mergeTwoLists(l1, l2).val);
    }


    /**
     * 自解   采用评论的方式，
     *
     * 思路：之前一直没搞懂这个链表是如何工作的，在debug之后才搞明白，
     *
     *
     * 在单链表中的next变量就是指向下一个值的，而在下方为什么需要两个变量来存储我们结合后的链表的原因是：
     *
     * 第一个dummyHead代表着最后我们的容器，而item代表着新容器的指针，当 l1 的指针指向第一个值与 l2 的指针指向的第一个值作比较
     * 把小的值赋值给item.next，这是因为如果直接改变item的值，则每一次都会被覆盖掉，不会保存下来，
     * 而item和dummyHead在初始化时指向的地址为同一个，在第一次进行判断时把item.next赋值为小的数值，则dummyHead.next也为同样的指向了小的那个地址，
     * 再把小的那个链表指针往后移，相应的我们的新容器的指针item也要往后移动，最后结合后的链表存储在dummyHead.next中
     *
     *
     * 这个思路只是解释了以下的代码，而且解释的非常差，但是我自己在debug后，知道是怎样运行的，写出来反而不会写了
     *
     *
     *
     *
     *
     * @param l1   输入的第一个链表
     * @param l2   输入的第二个链表
     * @return 返回结合后的节点
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 默认头节点为0
        ListNode dummyHead = new ListNode(0);
        ListNode item = dummyHead;
        while(l1 != null && l2!= null){
            // 当前值作比较
            if(l1.val <= l2.val){
                // 把小值放入容器的下一位，因为默认头节点为0   指针自然为next。
                item.next = l1;
                // l1的值往后移动一位
                l1 = l1.next;
            }else{
                item.next = l2;
                l2 = l2.next;
            }
            // 新容器的指针往后移动
            item = item.next;
        }
        // 当有一个链表为空时，意味着另一个有序链表都是大的数，直接链接到末尾就行了。
        if(l1 == null){
            item.next = l2;
        }else{
            item.next = l1;
        }
        // 因为默认的头节点为0，我们要去掉这个我们默认的头节点
        return dummyHead.next;
    }


    /**
     * 单链表
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
