
package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

        /* Amazon ana sayfaya gidin
        3 farklı test metehodu oluşturarak asagıdaki goreveleri yapın.
        1 url nin amazon içerdigini test edin.
        2 title nin facebook içerdigini test edin.
        3 sol ustte amazon logosu oldugunu test edin.
        */
        static WebDriver driver;
        @BeforeClass
        public static void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.amazon.com");
        }
        @AfterClass
        public static void tearDown(){
                driver.close();
        }

        @Test
    public void test01(){
            String beklenenKelime = "amazon";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(beklenenKelime));
        }

    @Test
    public void test02(){
            //title nin facebook içermedigini test edin.
        String beklenenBaslık = "facebook";
        String actualUrl = driver.getTitle();
        Assert.assertFalse(actualUrl.contains(beklenenBaslık));
    }

    @Test
    public void test03(){
            //sol ustte amazon logosu oldugunu test edin.
     WebElement amazonLogo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
     Assert.assertTrue(amazonLogo.isDisplayed() );


    }


}
