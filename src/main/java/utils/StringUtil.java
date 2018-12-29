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


    public static void createFile(File basePath,File dstFile,String[] aStr,String[] bStr) throws Exception{
        CharArrayWriter caw = null;
        caw =  wirteText(basePath,aStr,bStr);
        FileWriter fw = new FileWriter(dstFile);
        assert caw != null;
        caw.writeTo(fw);
        fw.close();
        caw.close();
    }



    /**
     * 批量修改已经存在的文件中的指定文字
     * @param path 文件路径
     * @param aStr 被替换的文本
     * @param bStr 替换的文本
     * @throws Exception
     */
    public static void lineText(String path,String[] aStr,String[] bStr) throws Exception{
        File[] files = new File(path).listFiles();
        assert files != null;
        for(File file : files){
            CharArrayWriter caw = wirteText(file,aStr,bStr);
            FileWriter fw = new FileWriter(file);
            caw.writeTo(fw);
            fw.close();
            caw.close();
        }
    }


    public static CharArrayWriter wirteText(File file, String[] aStr, String[] bStr){
        //字符内存流
        CharArrayWriter caw=new CharArrayWriter();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf8"));
            while ((line= br.readLine()) != null){
                //替换每一行中符合被替换字符条件的字符串
                for(int i = 0; i < aStr.length; i++){
                    line = line.replaceAll(aStr[i],bStr[i]);
                }
                caw.write(line);
                //添加换行符
                caw.append(System.getProperty("line.separator"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return caw;
    }

}
