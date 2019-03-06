package ywh.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * CreateTime: 2019-02-20 16:38
 * ClassName: Ywh02SeleniumTest
 * Package: ywh.selenium
 * Describe:
 * selenium测试用例
 *
 * @author YWH
 */
public class Ywh02SeleniumTest {


    private WebDriver driver;

    public Ywh02SeleniumTest(){
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
        this.driver  = new ChromeDriver();
        driver.get("http://video.sina.com.cn/");
    }


    @Test
    public void main(){
        int i = 0;
        // 1.查找所有链接
        List<WebElement> link = driver.findElements(By.xpath("//div[3]"));
        WebElement s = link.get(2);
        String url = s.getAttribute("href");
        s.click();
        System.out.println(url);
    }



}
