package letcode.easy1_20;

import org.junit.Test;

/**
 * CreateTime: 2019-03-22 13:57
 * ClassName: Easy16ErJinZhiQiuHe
 * Package: letcode.easy1_20
 * Describe:
 * 二进制求和
 *
 * @author YWH
 */
public class Easy16ErJinZhiQiuHe {


    /*

        给定两个二进制字符串，返回他们的和（用二进制表示）。

        输入为非空字符串且只包含数字 1 和 0。

        示例 1:

        输入: a = "11", b = "1"
        输出: "100"
        示例 2:

        输入: a = "1010", b = "1011"
        输出: "10101"

     */


    @Test
    public void main(){
        String a = "100";
        String b = "110010";
        System.out.println(addBinary1(a,b));
    }

    /**
     * 高级解法
     * 思路：  此思路位，统计1的个数，两个数和进位的数字相加，最大为3，相加后的值取余2为当前位的值
     *          整除2为进位的值，
     * @param a 字符串a
     * @param b 字符串b
     * @return 返回两个字符串相加后的value，二进制规则相加
     */
    private String addBinary1(String a, String b){
        StringBuilder res = new StringBuilder();
        int iA = a.length() - 1;
        int iB = b.length() - 1;
        // 进位
        int carry = 0;
        while( 0 <= iA || 0 <= iB || carry == 1){
            // 统计1的个数
            int count = carry;
            // 因为charAt的值为ASCII码，0的为48，减去'0'即可得到十进制的1或者0
            if(0 <= iA){
                count += a.charAt(iA--) - '0';
            }
            if(0 <= iB){
                count += b.charAt(iB--) - '0';
            }
            // 当前位的值
            res.append(count % 2);
            // 大于2, 进位
            carry = count / 2;
        }
        return res.reverse().toString();
    }


    /**
     * 纯暴力解法
     * @param a 字符串a
     * @param b 字符串b
     * @return 返回两个字符串相加后的value，二进制规则相加
     */
    private String addBinary(String a, String b) {
        if(a.isEmpty() || b.isEmpty()){return "";}
        StringBuilder s = new StringBuilder();
        int flag = 0;
        int i = 0;
        while(true){
            if(i != (a.length() > b.length() ? b.length() : a.length())){
                String tmpResult = a.substring(a.length() - i - 1,a.length() - i) + b.substring(b.length() - i - 1, b.length() - i) + flag;
                // 如果两个值相加为2，则把当前位置0，标志位置1
                switch (tmpResult){
                    case "111":
                        s.append("1");
                        flag = 1;
                        break;
                    case "110":
                        s.append("0");
                        flag = 1;
                        break;
                    case "101":
                        s.append("0");
                        flag = 1;
                        break;
                    case "011":
                        s.append("0");
                        flag = 1;
                        break;
                    case "100":
                        s.append("1");
                        flag = 0;
                        break;
                    case "010":
                        s.append("1");
                        flag = 0;
                        break;
                    case "001":
                        s.append("1");
                        flag = 0;
                        break;
                    default:
                        s.append("0");
                        flag = 0;
                        break;
                }
            }else {
                break;
            }
            i++;
        }
        // 把最长字符串和最短字符串比较出来
        if(a.length() > b.length()){
            addResult(i,a,flag,s);
        }else {
            addResult(i,b,flag,s);
        }
        if(flag == 1){
            s.append(flag);
        }

        return String.valueOf(s.reverse());
    }

    private void addResult(int i,String a,int flag,StringBuilder s){
        for(int j = i; j < a.length(); j++){
            String tmpResult = a.substring(a.length() - j - 1,a.length() - j) + flag;
            switch (tmpResult){
                case "11":
                    s.append("0");
                    flag = 1;
                    break;
                case "10":
                    s.append("1");
                    flag = 0;
                    break;
                case "01":
                    s.append("1");
                    flag = 0;
                    break;
                default:
                    s.append("0");
                    flag = 0;
                    break;
            }
        }
    }





}
