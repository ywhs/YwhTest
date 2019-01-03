package opencv;

import org.junit.Test;
import org.opencv.core.*;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.Features2d;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.xfeatures2d.SURF;
import utils.StringUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.opencv.core.Core.NORM_L2;

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
     * 取两张图片的相似点
     */
    @Test
    public void test6(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        DescriptorMatcher descriptorMatcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_L1);
        //获取原图片
        Mat imageBase = Imgcodecs.imread("F:\\tmp\\test\\ceshi\\dlrb.jpeg",Imgcodecs.CV_LOAD_IMAGE_COLOR);
        Mat imageTest = Imgcodecs.imread("F:\\tmp\\test\\ceshi\\dlrb2.png",Imgcodecs.CV_LOAD_IMAGE_COLOR);
        Mat image1 = new Mat();
        Mat image2 = new Mat();
        //灰度
        Imgproc.cvtColor(imageBase,image1,Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(imageTest,image2,Imgproc.COLOR_BGR2GRAY);
        //创建URF
        SURF surf = SURF.create();
        //关键点及特征描述矩阵声明
        MatOfKeyPoint matOfKeyPoint1 = new MatOfKeyPoint();
        Mat descMat1 = new Mat();
        MatOfKeyPoint matOfKeyPoint2 = new MatOfKeyPoint();
        Mat descMat2 = new Mat();
        //计算特征关键点,把得到的灰度的图片传入计算
        surf.detect(image1,matOfKeyPoint1);
        surf.detect(image2,matOfKeyPoint2);
        //计算特征描述矩阵
        surf.compute(image1,matOfKeyPoint1,descMat1);
        surf.compute(image2,matOfKeyPoint2,descMat2);
        DMatch dMatch = new DMatch();
        BFMatcher bfMatcher = BFMatcher.create(NORM_L2, true);

        //匹配开始
        MatOfDMatch matOfDMatch = new MatOfDMatch();
        bfMatcher.match(descMat1,descMat2,matOfDMatch);

        double maxDist = Double.MAX_VALUE;
        double minDist = Double.MIN_VALUE;

        DMatch[] mats = matOfDMatch.toArray();

        List<DMatch> goodMatch = new LinkedList<>();
        //for(int i = 0; i <= 20; i++){
        //goodMatch.add(mats);
        //}
        //matOfDMatch.fromList(goodMatch);
        matOfDMatch.fromArray(mats);
        Mat outImage = new Mat();
        Features2d.drawMatches(imageBase,matOfKeyPoint1,imageTest,matOfKeyPoint2,matOfDMatch,outImage);
        //写入
        Imgcodecs.imwrite("F:\\tmp\\test\\ceshi\\ceshi.jpeg",outImage);
//        for(KeyPoint keyPoint : matOfKeyPoint1.toList()){
//            System.out.println("特征点1：" + keyPoint.pt.x + "," + keyPoint.pt.y);
//        }
//        for(KeyPoint keyPoint : matOfKeyPoint2.toList()){
//            System.out.println("特征点2：" + keyPoint.pt.x + "," + keyPoint.pt.y);
//        }
//        System.out.println("特征描述矩阵：" + descMat1);
//        System.out.println("特征点1:" + matOfKeyPoint1.size());
//        System.out.println("特征点2:" + matOfKeyPoint2.size());
    }



    @Test
    public void test5(){

        /**
         *   1.首先:
         *    创建Mat，用于保存图像内容。
         *    使用 imread 读取图像，图像路径为 imageName ，图像按BGR格式读取。
         *   2.其次:
         *    将RGB图像转化为灰度格式。Opencv中有现成的转化函数
         *   3.然后，使用函数 imwrite 将得到的灰度图像 gray_image 保存到硬盘。程序结束时，该灰度图像将会被释放。
         *   4.
         */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //1.读取一个图像文件 图像按BGR格式读取
        Mat image = Imgcodecs.imread("F:\\tmp\\test\\ceshi\\dlrb.jpeg",Imgcodecs.CV_LOAD_IMAGE_COLOR);
        System.out.println(image.depth());
        if(image.empty()){
            System.out.println("没有此图片！！");
        }else{

            /**
             *   2.其次，将RGB图像转化为灰度格式
             *   源图像 (image)
             *   目标图像 (gray_image)，用于保存转换图像。
             *   附加参数，用于指定转换的类型，例子中使用参数 CV_BGR2GRAY
             */
            Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);
            /**
             *   3.该函数，将图像写入到指定的文件夹下，程序执行时需保证该文件夹存在。将得到的灰度图像写到../../images/下，命名为Gray_Image.jpg。
             */
            Imgcodecs.imwrite("E:\\ceshi\\Gray_dlrb.jpeg",image);
        }
    }



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
