package opencv;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
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


    @Test
    public void test2() throws Exception{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat image = Imgcodecs.imread("F:\\tmp\\StationMark\\images\\stationMark_50.jpg");
//        File file = new File("F:\\tmp\\StationMark\\images\\stationMark_50.jpg");
//        String xmlName = file.getName().substring(0,file.getName().indexOf("."));
//        System.out.println("文件名字：" + file.getName());
//        System.out.println("文件路径：" + file.getPath());
//        System.out.println("图片宽度：" + image.width());
//        System.out.println("图片高度：" + image.height());
//        System.out.println("图片深度：" + image.depth());
//        System.out.println("测试：" + xmlName);

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

    @Test
    public void test1() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture voide = new VideoCapture("F:\\tmp\\StationMark\\voide\\beijing1.mp4");
        //视频中帧的总数量
        double countFrames = voide.get(7);
        System.out.println("帧的总数量：" + countFrames);
        int framesStep = 50;
        for(int i = 1; i <= 500; i++){
            voide.set(1,framesStep);
            Mat srcImage = new Mat();
            Mat dstImage = new Mat();
            voide.read(srcImage);
            Size size = new Size(500,281);
            Imgproc.resize(srcImage,dstImage,size);
            Imgcodecs.imwrite("F:\\tmp\\StationMark\\images\\beijing\\" + "stationMark_beijing" + i + ".jpg",dstImage);
            framesStep+=50;
            if(framesStep >= countFrames){
                break;
            }
        }
        //test2();
//        Rect rect = new Rect(115,60,370,100);
//        Mat newImage = new Mat(image,rect);
//        HighGui.imshow("ceshi",dstImage);
//        HighGui.waitKey();

    }

}
