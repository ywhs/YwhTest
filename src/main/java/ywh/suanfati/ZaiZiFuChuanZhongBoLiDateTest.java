package ywh.suanfati;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * CreateTime: 2019-03-05 9:39
 * ClassName: ZaiZiFuChuanZhongBoLiDateTest
 * Package: ywh.suanfati
 * Describe:
 * 在字符串中剥离日期
 *
 * @author YWH
 */
public class ZaiZiFuChuanZhongBoLiDateTest {





    @Test
    public void main() throws ParseException {
        dateTime();

    }

    /**
        在一个字符串中规定好的前面有日期，请剥离前面的日期
        substring方法是一个半闭半开区间
        valueof()方法会返回一个Integer封装类型
        parseInt()方法会直接返回int类型
     **/
    private LocalDateTime test(){
        try {
            String s = "2019年03月04日发布 央视最漂亮的8位女主持人 董卿只排第3 网友 第1名实在太美了";
            int year = Integer.parseInt(s.substring(0,s.indexOf("年")));
            System.out.println("year => " + year);
            int month = Integer.parseInt(s.substring(s.indexOf("年") + 1,s.indexOf("月")));
            System.out.println("month => " + month);
            int day = Integer.parseInt(s.substring(s.indexOf("月") + 1,s.indexOf("日")));
            System.out.println("day => " + day);
            System.out.println("LocalDateTime时间格式 => " + LocalDateTime.of(year,month,day,0,0));
            System.out.println("LocalDateTime时间格式 => " + LocalDateTime.now());
            return LocalDateTime.of(year,month,day,0,0);
        }catch (Exception e){
            e.printStackTrace();
            return LocalDateTime.now();
        }
    }


    /**
     * 在指定的符合规定的字符串中取出时间并返回以秒为单位的总时间数
     *  指定字符串例如：女子干完农活回家，却失足掉进了河里，被小伙救起后发现不对劲！,629万次播放,02:24
     * @throws ParseException 异常
     */
    private void dateTime() throws ParseException {
        String s = "女子干完农活回家，却失足掉进了河里，被小伙救起后发现不对劲！,629万次播放,02:24";
        String s1 = s.substring(s.lastIndexOf(",") + 1);
        Integer minute = Integer.parseInt(s1.substring(0,s1.lastIndexOf(":")));
        Integer second = Integer.parseInt(s1.substring(s1.lastIndexOf(":") + 1));
        int time = minute * 60 + second;
        System.out.println(time);

    }
}
