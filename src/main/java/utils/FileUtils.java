package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * CreateTime: 2019-03-06 15:24
 * ClassName: FileUtils
 * Package: utils
 * Describe:
 * 文件工具类
 *
 * @author YWH
 */
public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 根据系统分隔符创建文件目录
     * @param path 文件路径
     */
    public static void createFile(String path){
        // 存储磁盘路径
        File diskPath = new File(path);
        if(!diskPath.exists()&& !diskPath.isDirectory()){
            if ("/".equals(File.separator)) {
                log.debug("Liunx下创建");
                diskPath.setWritable(true, false);
                diskPath.mkdirs();
            } else {
                log.debug("windows下创建");
                diskPath.mkdirs();
            }
        }
    }

}
