package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
      driver.quit();

    }

    @Test
    public void test01(){
        // herhangi bir web stesine gidince veya bir web stesinde herhangi bir işlem yaptıgımızda
        // ortaya cıkan uyarılara alert diyoruz.

      //  Eger bir alert inspect yapılabiliyorsa o alert otomasyon ile kullanılabilir.
        // bu tür alertlere HTML alert denir. ve bunlar için extra bir işlam yapmaya gerek yokut
        // tüm webelementleri gibi locate edip istediğimiz işlemleri yapabiliriz.
        // driver.get("https://www.facebook.com");  gibi vb.

        /*

        Ancak J script alert de olabilir bunlar locate edilemezler.
        buna ozel bir yontem vardır.
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // alert'te OK tusuna basın
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        // alert te OK tuşuna basın ve result kısmında "You successfully clicked an alert" yazdıgını test edin.

        String expectedResult = "You successfully clicked an alert";
      //  String excualResult = "You successfully clicked an alert";

    WebElement sonucYazisiElementi = driver.findElement(By.xpath("//p[@id=\"result\"]"));
    String excualResultYazısı = sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResult,excualResultYazısı);


    }

}
