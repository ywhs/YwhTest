package ywh.erchashu;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Stack;

/**
 * CreateTime: 2019-02-19 11:16
 * ClassName: Ywh01EeChaShuTest
 * Package: ywh
 * Describe:
 * 二叉树遍历
 *
 * @author YWH
 */
public class Ywh01EeChaShuTest {


    /**

        实现二叉树的前序、中序、后序遍历

        三种遍历方法的考查顺序一致，得到的结果却不一样，原因在于：
        先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
        中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
        后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)


     */

    private TreeNode node;

    /**
     * 初始化数据
     */
    public Ywh01EeChaShuTest(){
        this.node = new TreeNode(1);
        this.node.left = new TreeNode(2);
        this.node.right = new TreeNode(3);
        this.node.left.left = new TreeNode(4);
        this.node.left.left.right = new TreeNode(6);
        this.node.left.left.right.left = new TreeNode(7);
        this.node.left.left.right.right = new TreeNode(8);
        this.node.right.right = new TreeNode(5);
    }


    @Test
    public void main(){
        System.out.print("递归先序遍历：");
        frontForeach(this.node);

        System.out.println("");

        System.out.print("非递归先序遍历：");
        frontForeach1(this.node);

        System.out.println("");

        System.out.print("递归中序遍历：");
        middleForeach(this.node);

        System.out.println("");

        System.out.print("非递归中序遍历：");
        middleForeach1(this.node);

        System.out.println("");

        System.out.print("递归后序遍历：");
        backForeach(this.node);

        System.out.println("");

        System.out.print("递归后序遍历：");
        backForeach1(this.node);
    }


    /**
     * 二叉树的先序遍历 （递归遍历）  根左右
     * @param node 二叉树链表
     */
    private void frontForeach(TreeNode node){
        if(node != null){
            System.out.print(node.val);
            frontForeach(node.left);
            frontForeach(node.right);
        }
    }

    /**
     * 二叉树的先序遍历（非递归遍历） 根左右
     *
     * 思路：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)，把不输出的右节点暂时存储到栈内。
     *
     * @param node 二叉树链表
     */
    private void frontForeach1(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        // 只要该节点不为空和栈不为空都应该进入循环
        while(root != null || !stack.isEmpty()){
            // 顺着头节点查找左节点，直到没有左节点再也没有左节点，顺便把左节点的兄弟节点右节点放入栈内
            while(root != null){
                // 先序遍历就是查到一个左节点输出一个节点
                System.out.print(root.val);
                // 把暂时不输出的右节点存起来，通过栈的工作方式（后进先出），先进去一般为最后输出的
                stack.push(root.right);
                // 把当前节点的左孩子（左节点）提到前面，向下遍历
                root = root.left;
            }
            // 栈内如果不为空，则弹出栈顶元素
            if(!stack.isEmpty()){
                root = stack.pop();
            }
        }
    }

    /**
     * 二叉树的中序遍历（递归遍历） 左根右
     *
     * @param node 二叉树链表
     */
    private void middleForeach(TreeNode node){
        if(node != null){
            middleForeach(node.left);
            System.out.print(node.val);
            middleForeach(node.right);
        }
    }


    /**
     * 二叉树的中序遍历（非递归遍历） 左根右
     *
     * 思路:这个主要是判断在没有左孩子节点时就是输出的时候了，在第二个while退出的时候就是左孩子节点为空了
     * 把栈顶数据弹出，输出节点数据，并把右节点拿出来
     *
     * @param node 二叉树链表
     */
    private void middleForeach1(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        // 只要该节点不为空和栈不为空都应该进入循环
        while (root != null || !stack.isEmpty()){
            // 当节点不为空的时候，假如栈，并继续寻找左节点
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // 当上面的while退出的时候，代表左节点为空，输出栈顶数据，并把右节点拿出来
            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val);
                root = root.right;
            }
        }
    }


    /**
     * 二叉树的后序遍历（递归遍历） 左右根
     *
     * @param node 二叉树链表
     */
    private void backForeach(TreeNode node){
        if(node != null){
            backForeach(node.left);
            backForeach(node.right);
            System.out.print(node.val);
        }
    }


    /**
     * 二叉树的后序遍历（非递归遍历） 左右根
     *
     * @param node 二叉树链表
     */
    private void backForeach1(TreeNode node){
        Stack<Object> stack = new Stack<>();
        // 1.把整个对象都放入栈内
        stack.push(node);
        // 2.while判断栈内是否有数据
        while (!stack.isEmpty()){
            // 3.弹出栈顶数据
            Object t = stack.pop();
            // 4.判断t是否为TreeNode类型数据，如果不是则输出
            if(t instanceof TreeNode){
                // 5.如果是的话，把当前节点的数据放入栈内，并且判断是否有左右节点
                stack.push(((TreeNode) t).val);
                if(((TreeNode) t).right != null){stack.push(((TreeNode) t).right);}
                if(((TreeNode) t).left != null){stack.push(((TreeNode) t).left);}
            }else{
                System.out.print(t);
            }
        }
    }
}
