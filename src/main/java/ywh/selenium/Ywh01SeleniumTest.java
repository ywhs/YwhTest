package ywh.selenium;

import common.Consts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CreateTime: 2019-02-20 15:01
 * ClassName: Ywh01SeleniumTest
 * Package: ywh.selenium
 * Describe:
 * selenium的测试用例1
 *
 * @author YWH
 */
public class Ywh01SeleniumTest {

    private static final Logger LOG = LoggerFactory.getLogger(Ywh01SeleniumTest.class);

    private WebDriver driver;

    public Ywh01SeleniumTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
        this.driver  = new ChromeDriver();
        driver.get("http://www.baidu.com");
        // 查找元素，根据id
        WebElement searchBox = driver.findElement(By.id("kw"));
        // 发送内容
        searchBox.sendKeys("Cheese!");
        // 根据id查找button按钮
        WebElement searchButton = driver.findElement(By.id("su"));
        // 点击提交
        searchButton.submit();

    }


    @Test
    public void main(){
        // 输出当前网页的标题
        System.out.println("Page title is: " + driver.getTitle());

        // 显示等待，在页面没有加载完成之前，等待，在抛出TimeoutException之前等待最多10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());
        ((JavascriptExecutor)driver).executeScript("alert('Test Case Execution is started Now!!')");

//        driver.quit();
    }


    @Test
    public void main1(){

        // 显示等待，在页面没有加载完成之前，等待，在抛出TimeoutException之前等待最多10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // 输出当前网页的标题
        System.out.println("Page title is: " + driver.getTitle());

        // 根据标签的名称查询，这样会返回所有这样的标签
        WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
        System.out.println("按钮：" + button.getText());


        // 查找id为1的节点，并输出文本内容
        WebElement text = driver.findElement(By.id("1"));
        System.out.println("id为1:" + text.getText());


        // 模糊查找带有cheese的链接，并输出内容
        List<WebElement> link = driver.findElements(By.partialLinkText("cheese"));
        for(WebElement str : link){
            System.out.println("模糊查询链接："+ str.getText());
            // 点击链接
            //str.click();
        }

        driver.quit();

    }






}
