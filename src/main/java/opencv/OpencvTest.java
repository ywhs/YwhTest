package opencv;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

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
    public void test1(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture voide = new VideoCapture("F:\\tmp\\voide\\beijing1.mp4");
        //获取fps，意思是每一秒刷新图片的数量
        double fps = voide.get(5);
        //视频中帧的总数量
        double countFrames = voide.get(7);
        System.out.println("帧的总数量：" + countFrames + "---------" + "fps数:" + fps);
        Mat image = new Mat();
        int framesStep = 50;
        for(int i = 50; i < countFrames; i+=framesStep){
            voide.set(1,i);
            voide.read(image);
            Imgcodecs.imwrite("F:\\tmp\\StationMark\\images\\" + "stationMark_" + i + ".jpg",image);
        }
//        Rect rect = new Rect(115,60,370,100);
//        Mat newImage = new Mat(image,rect);
//        HighGui.imshow("ceshi",newImage);
//        HighGui.waitKey();

    }

}
