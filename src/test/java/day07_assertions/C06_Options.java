package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_Options {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void Test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown"); // siteye git

        //index kullanarak secenek1 i secin ve yadırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); // objenin onceki seçtiklerinin ilki(bir onceki eleman)

        //value kullanrak secenek 2 secin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //visibele Text (gorunur metin) kullanarak secenek i secin ve yazdırın.
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // tüm dropdown options ı yazdırın.
        List<WebElement> tumOpsiyonlar = select.getOptions();
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        //ddm nün boyutunun 4 olup olmadığını test edin.
        int ddmBoyut = tumOpsiyonlar.size();
        if (ddmBoyut==4){
            System.out.println("true");
        }else System.out.println("false");




    }

}
