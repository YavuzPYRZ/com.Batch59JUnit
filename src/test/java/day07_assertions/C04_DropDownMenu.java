package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /* amazon'a gidip
   dropdown'dan books secenegini secip
   Java aratalim
   ve arama sonuclarinin Java icerdigini test edelim
 */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.amazon.com"); // amazon'a git
        // dropdown dan bir option secmek için 3 adım var.
        // 1) dropdown u locate edelim.
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //Yeni bir select objesi olusturalım. ona locte ettiğimiz dropdown elementini ekleyelim/verelim.
        Select select = new Select(ddm);
        select.selectByIndex(14);

        // arama kutusuna java yazdıralalım.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER) ;

        // arama Java iceriyor mu?

        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualYazi  = aramaSonucYazisi.getText();
        String expectedYazi = "Java";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        Thread.sleep(5000);


    }

}
