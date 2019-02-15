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
        for(int i = 0; i <= 2; i++){
            ListNode l1 = new ListNode(1 + i * 2 + 1);
            ListNode l2 = new ListNode(2 + i);
            System.out.println(mergeTwoLists(l1, l2).val);
            System.out.println(mergeTwoLists(l1, l2).next.val);
        }
    }


    /**
     * 自解
     * @param l1   输入的第一个链表
     * @param l2   输入的第二个链表
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode item = dummyHead;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                item.next = l1;
                l1 = l1.next;
            }else{
                item.next = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            item.next = l2;
        }else{
            item.next = l1;
        }
        return item;
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
