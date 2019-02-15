package letcode.easy1_20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * CreateTime: 2019-02-14 10:55
 * ClassName: Easy6YouXiaoDeKuoHaoTest
 * Package: letcode.easy1_20
 * Describe:
 * 有效的括号
 *
 * @author YWH
 */
public class Easy6YouXiaoDeKuoHaoTest {


    /**

         给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

         有效字符串需满足：

         左括号必须用相同类型的右括号闭合。
         左括号必须以正确的顺序闭合。
         注意空字符串可被认为是有效字符串。

         示例 1:

         输入: "()"
         输出: true
         示例 2:

         输入: "()[]{}"
         输出: true
         示例 3:

         输入: "(]"
         输出: false
         示例 4:

         输入: "([)]"
         输出: false
         示例 5:

         输入: "{[]}"
         输出: true

     */


    @Test
    public void main(){
        System.out.println(isValid("(([]){})"));
        System.out.println(isValid("{}{}()[]"));
        System.out.println(isValid("(([]){})"));
    }

    /**
     * 自解   采用官方算法
     *
     * 思路：当我们碰到字符串中的开区间时，我们放入栈内，碰到闭区间时，则把栈顶中的数据弹出，最后如果栈是空时，那么代表着有效括号 否则无效。
     * @param s  输入的字符串
     * @return 返回是否为有效括号
     */
    private boolean isValid(String s) {

        Map<Character, Character > map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            // 取出一个字符，判断是否是开括号 还是闭括号，如果是开括号入栈，闭括号则需要把栈顶中的数据弹出
            char c = s.charAt(i);
            // 如果这个闭区间存在与map表中为key值，继续
            if (map.containsKey(c)){
                // 执行到这步意味着，我们碰到了闭区间，则需要弹出一个开区间，如果栈顶不为空的话，则弹出，为空的话任意字符。
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // 如果栈顶数据与map中的数据不相等，则意味着无效的括号，因为相挨着的括号是不可能无效的。
                if(topElement != map.get(c)){
                    return false;
                }
            }else{
                // 开括号放入栈内
                stack.push(c);
            }
        }
        // 如果栈内无数据代表着所有的开括号都已经找到了我们的闭括号，如果有数据代表无效数据
        return stack.isEmpty();
    }






}
