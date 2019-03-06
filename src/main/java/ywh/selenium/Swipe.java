package ywh.selenium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * CreateTime: 2019-03-01 15:15
 * ClassName: Swipe
 * Package: ywh.selenium
 * Describe:
 * app滑动
 *
 * @author YWH
 */
public class Swipe {



    /**
     * 下滑
     * x轴不变，y轴由小到大
     * @param driver Android驱动
     */
    public static void swipeUp(AndroidDriver driver) {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        new TouchAction(driver).press(PointOption.point(width / 2, height / 2))
                .moveTo(PointOption.point(width / 2, height - 200)).release()
                .perform();
    }

    /**
     * 上滑
     * x轴不变 y轴由大变到小
     * @param driver Android驱动
     */
    public static void swipeDown(AndroidDriver driver) throws InterruptedException {
        WaitOptions waitOptions = new WaitOptions();
        int height = driver.manage().window().getSize().height;
        System.out.println("要操作的位置y坐标 => " + height);
        int width = driver.manage().window().getSize().width;
        System.out.println("要操作的位置X坐标 => " + width);
        TimeUnit.SECONDS.sleep(1);
        new TouchAction(driver)
                // 指定一个位置按住
                .longPress(PointOption.point(width / 2, height - 500))
                // 移动
                .moveTo(PointOption.point(width / 2, height - 300 - 500))
                // 结束屏幕上的一系列动作的命令操作
                .release()
                //  讲执行的操作发送到服务器的命令操作
                .perform();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * 左滑动
     * y轴不变，x轴方向   从大变化到小  为左滑
     * @param driver Android驱动
     */
    public static void swipeLeft(AndroidDriver driver) throws InterruptedException {
        int height = driver.manage().window().getSize().height;
        System.out.println("要操作的位置y坐标 => " + height);
        int width = driver.manage().window().getSize().width;
        System.out.println("要操作的位置X坐标 => " + width);
        TimeUnit.SECONDS.sleep(1);
        new TouchAction(driver)
                .longPress(PointOption.point(width * 3 /4,height))
                .moveTo(PointOption.point(width / 11, height)).release().perform();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * 右滑
     * @param driver Android驱动
     */
    public static void swipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }


    /**
     * 根据节点点击任意位置
     * @param driver 安卓驱动
     * @param element 操作节点
     */
    private void pressAction(AndroidDriver driver, WebElement element){
        int width = element.getRect().x - 50;
        int height = element.getRect().y;
        new TouchAction(driver).press(PointOption.point(width,height))
                .release().perform();
    }

}
