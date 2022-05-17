package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void test02() {
        driver.get("https://www.amazon.com");

    }

}
