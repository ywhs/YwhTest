package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

/**
 * CreateTime: 2019-03-12 13:53
 * ClassName: ImgUtils
 * Package: utils
 * Describe:
 * 图片处理
 *
 * @author YWH
 */
public class ImgUtils {



    /**
     * 在指定图片中写入指定的文字
     * @param background 背景图片
     * @param outSrc 输出路径
     */
    public static void test01(String background,String outSrc){
        int width = 1000;
        int height = 1000;
        String s = "大嘴猴:";
        String s1 = "您提交的作品《那幅画》已完成作品信息的区块链登";
        String s2 = "记，并通过小犀版权链联盟的审核与认证。";
        System.out.println(s1.length());
        File file = new File(outSrc);

        Font font = new Font("Serif", Font.BOLD, 10);
        //创建一个画布
        BufferedImage bi;
        try {
            bi = ImageIO.read(new FileInputStream(background));
            //BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //获取画布的画笔
            Graphics2D g2 = (Graphics2D)bi.getGraphics();
            g2.setColor(Color.BLUE);
            g2.setStroke(new BasicStroke(3));
            g2.setFont(new Font("宋体",Font.PLAIN, 48));

            //绘制字符串
            g2.drawString(s, 240, 940);
            g2.drawString(s1, 330, 1070);
            g2.drawString(s2, 240, 1125);
            //将生成的图片保存为jpg格式的文件。ImageIO支持jpg、png、gif等格式
            ImageIO.write(bi, "png", file);
            System.out.println("生成jpg完成！！！！！！");
        }catch (Exception ex){
            System.out.println("生成图片出错");
        }





    }

}
