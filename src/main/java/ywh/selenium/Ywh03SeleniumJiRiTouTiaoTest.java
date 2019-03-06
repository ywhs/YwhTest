package ywh.selenium;

import common.Consts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CreateTime: 2019-03-01 17:34
 * ClassName: Ywh03SeleniumJiRiTouTiaoTest
 * Package: ywh.selenium
 * Describe:
 * 今日头条app
 *
 * @author YWH
 */
public class Ywh03SeleniumJiRiTouTiaoTest {

    private static final Logger LOG = LoggerFactory.getLogger(Ywh03SeleniumJiRiTouTiaoTest.class);

    /**
     * 使用之前先清空
     */
    private byte[] screenshotContent = null;
    private static AndroidDriver androidDriver;

    @BeforeClass
    public static void setUpDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "192.168.74.101:5555");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("app", "F:/YIDEAWorker/ximonitor/apk/jinritoutiao.apk");
        capabilities.setCapability("appPackage", "com.ss.android.article.news");
        capabilities.setCapability("appActivity", "com.ss.android.article.news.activity.SplashBadgeActivity");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("newCommandTimeout","80");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }


    @Test
    public void test() throws InterruptedException {
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int width = androidDriver.manage().window().getSize().width;
        System.out.println("窗口宽度 => " + width);
        TimeUnit.SECONDS.sleep(8);
        WebElement newsInfo = androidDriver.findElement(By.id("com.ss.android.article.news:id/title"));
        WebElement view = androidDriver.findElement(By.xpath("//android.view.View[@content-desc='视频']"));
        if(newsInfo != null){
            System.out.println("新闻标题 => " + newsInfo.getText());
        }
        if(view != null){
            System.out.println("buweikong===========");
            view.click();
        }
        List<WebElement> elements = androidDriver.findElements(By.id("com.ss.android.article.news:id/a_t"));
        System.out.println("list的size => " + elements.size());
        // 视频播放
        List<WebElement> tapList = androidDriver.findElements(By.id("com.ss.android.article.news:id/is"));
        List<WebElement> san = androidDriver.findElements(By.id("com.ss.android.article.news:id/aiv"));
        if(!san.isEmpty()){
            san.get(0).click();
        }
        WebElement links =  androidDriver.findElement(By.id("com.ss.android.article.news:id/yw")).findElement(By.className("android.widget.RelativeLayout[6]"));
        links.click();
        Swipe.swipeDown(androidDriver);


    }


    /**
     * 从元素中获取链接地址
     *
     * @return String if failed, return null
     */
    private  String findUrlFromElement(AndroidDriver driver, WebElement shareElement) {
        String articleUrl = null;
        try {
            shareElement.click();
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_TINY_SMALL, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(1);
            WebElement opBtn = driver.findElementById("com.ss.android.article.news:id/yw");
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_TINY_SMALL, TimeUnit.SECONDS);
            List<WebElement> operationBtnList = opBtn.findElements(By.className("android.widget.RelativeLayout"));
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_TINY_SMALL, TimeUnit.SECONDS);
            LOG.debug("operationBtnList size :{}",operationBtnList.size());
            if (CollectionUtils.isNotEmpty(operationBtnList)) {
                LOG.debug("找到了复制链接按钮...");
                WebElement copyBtn = operationBtnList.get(operationBtnList.size()-1);
                driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_TINY_SMALL, TimeUnit.SECONDS);
                copyBtn.click();
                driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_TINY_SMALL, TimeUnit.SECONDS);
                LOG.debug("链接复制到粘贴板成功");
            }else {
                LOG.debug("未找到复制链接按钮...忽略此条新闻");
                return null;
            }
            // 截图
            LOG.debug("开始截图");
            TimeUnit.SECONDS.sleep(4);
            screenshotContent = driver.getScreenshotAs(OutputType.BYTES);
            LOG.debug("截图成功大小：{}", screenshotContent.length);

            // 在搜索框中处理url
            TimeUnit.SECONDS.sleep(4);
            LOG.debug("获取粘贴板中的链接");
            WebElement inputBtn = driver.findElementById("com.ss.android.article.news:id/a9b");
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            inputBtn.click();
            TimeUnit.SECONDS.sleep(1);

            WebElement textInput = driver.findElementById("com.ss.android.article.news:id/ws");
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            LOG.debug("点击评论框");
            textInput.click();
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            LOG.debug("清空内容");
            textInput.clear();
            LOG.debug("粘贴链接");
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_V, AndroidKeyMetastate.META_CTRL_ON);
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(2);
            // 获取链接
            articleUrl = textInput.getText();
            LOG.debug("textInput.getText() = {}", articleUrl);
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(2);
            LOG.debug("return articleUrl...");
            driver.manage().timeouts().implicitlyWait(Consts.TIMEOUT_SMALL, TimeUnit.SECONDS);
            //driver.pressKey();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            LOG.error("获取新闻连接错误,返回null ", e);
        }
        boolean flag1 = articleUrl.contains("m.toutiaocdn.com");
        boolean flag2 = articleUrl.contains("m.toutiaocdn.cn");
        if (StringUtils.isNotBlank(articleUrl) && (flag1 || flag2)) {
            LOG.debug("记录合法");
            return articleUrl;
        }
        return null;
    }


}
