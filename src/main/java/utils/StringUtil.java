package utils;

import java.io.*;

/**
 * CreateTime: 2018-12-29 10:15
 * ClassName: StringUtil
 * Package: TensorFlow16.util
 * Describe:
 * 文本工具类
 *
 * @author YWH
 */
public class StringUtil {


    /**
     * 批量修改文件中的指定文字
     * @param aStr 待替换的文本
     * @param bStr 替换的文本
     * @param path 文件路径
     * @throws Exception
     */
    public static void lineText(String aStr,String bStr,String path) throws Exception{
//        String path = "F:\\tmp\\tensorflow\\raccoon_dataset-master\\annotations\\";
        //读取文件内容
//        //待替换的文本
//        String aStr = "/Users/datitran/Desktop/raccoon/images/";
//        //替换的文本
//        String bStr = "F:/tmp/tensorflow/raccoon_dataset-master/images/";
        //File file = new File(path);
        File[] files = new File(path).listFiles();
        assert files != null;
        for(File file : files){
            //字符内存流
            CharArrayWriter caw=new CharArrayWriter();
            String line = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf8"));
            while ((line= br.readLine()) != null){
                //替换每一行中符合被替换字符条件的字符串
                line = line.replaceAll(aStr,bStr);
                caw.write(line);
                //添加换行符
                caw.append(System.getProperty("line.separator"));
            }
            FileWriter fw = new FileWriter(file);
            caw.writeTo(fw);
            br.close();
            fw.close();
            caw.close();
        }
    }

}
