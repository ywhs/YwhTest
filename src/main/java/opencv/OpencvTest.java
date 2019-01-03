package opencv;

import org.junit.Test;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import utils.StringUtil;

import java.io.File;

/**
 * CreateTime: 2018-12-29 13:12
 * ClassName: OpencvTest
 * Package: opencv
 * Describe:
 * opencv测试用例
 *
 * @author YWH
 */
public class OpencvTest {


    /**
     * 圈出图片上的某一块区域
     */
    @Test
    public void test4(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread("F:\\tmp\\StationMark1\\StationMark1\\images\\stationMark_dongfang457.jpg");
        Mat newImage = image.clone();
        Imgproc.rectangle(newImage,new Point(35,16),new Point(68,48)
                ,new Scalar(0,255,0),2);
        HighGui.imshow("ceshi",newImage);
        HighGui.waitKey();

//        File file = new File("F:\\tmp\\StationMark\\images\\stationMark_50.jpg");
//        String xmlName = file.getName().substring(0,file.getName().indexOf("."));
//        System.out.println("文件名字：" + file.getName());
//        System.out.println("文件路径：" + file.getPath());
//        System.out.println("图片宽度：" + image.width());
//        System.out.println("图片高度：" + image.height());
//        System.out.println("图片深度：" + image.depth());
//        System.out.println("测试：" + xmlName);
    }


    /**
     * 修改指定位置 单个位置
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        String[] aStr = {"/opt/StationMark/images/"};
        String[] bStr = {"/opt/stationmark/images/"};
        StringUtil.lineText("F:\\tmp\\StationMark1\\StationMark1\\valAnnotations\\",aStr,bStr);
    }

    /**
     * 批量生成xml文件
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File[] files = new File("F:\\tmp\\StationMark\\beifen\\beijing").listFiles();
        String[] aStr = {"jpgName","jpgPath","widthValue",
                        "heightValue","depthValue","nameValue",
                        "xminValue","yminValue","xmaxValue","ymaxValue"};
        assert files != null;
        for(File itemFile : files){
            Mat image = Imgcodecs.imread(itemFile.getPath());
            String xmlName = itemFile.getName().substring(0,itemFile.getName().indexOf("."));
            String[] bStr = {itemFile.getName(),
                            "F:/tmp/StationMark/xml/" + itemFile.getName(),
                            String.valueOf(image.width()),
                            String.valueOf(image.height()),
                            "3","beijing","28","18","129","42"};
            StringUtil.createFile(new File("F:\\tmp\\StationMark\\stationMark.xml"),
                    new File("F:\\tmp\\StationMark\\xml\\beijing\\" + xmlName + ".xml"),
                    aStr,bStr);
        }
    }

    /**
     * 从视频中批量生成图片
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture voide = new VideoCapture("F:\\tmp\\StationMark\\voide\\beijing1.mp4");
        //视频中帧的总数量
        double countFrames = voide.get(7);
        System.out.println("帧的总数量：" + countFrames);
        int framesStep = 50;
        for(int i = 1; i <= 5; i++){
            voide.set(1,framesStep);
            Mat srcImage = new Mat();
            Mat dstImage = new Mat();
            voide.read(srcImage);
            Size size = new Size(500,281);
            Imgproc.resize(srcImage,dstImage,size);
            Imgcodecs.imwrite("F:\\tmp\\" + "beijing" + i + ".jpg",dstImage);
            framesStep+=50;
            if(framesStep >= countFrames){
                break;
            }
        }
        //test2();
    }

}
