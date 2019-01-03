package utils;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

/**
 * CreateTime: 2019-01-03 15:35
 * ClassName: CascadeClassifierUtil
 * Package: utils
 * Describe:
 * 级联训练器
 *
 * @author YWH
 */
public class CascadeClassifierUtil {

    public static Mat trainer(Mat src){
        Mat dst = src.clone();
        //   E:\opencv\opencv\opencv\build\etc\haarcascades\
        CascadeClassifier objDetector = new CascadeClassifier("F:\\tmp\\class\\xml\\cascade.xml");
        MatOfRect objDetections = new MatOfRect();
        //检测
        objDetector.detectMultiScale(src,objDetections,1.1,6,
                Objdetect.CASCADE_DO_CANNY_PRUNING,new Size(100,70),new Size(150,150));
        if(objDetections.toArray().length <= 0){
            return src;
        }
        //检测出来后  画出区域
        for(Rect rect : objDetections.toArray()){
            Imgproc.rectangle(dst,new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height)
                    ,new Scalar(0,255,0),2);
        }
        return dst;
    }

}
