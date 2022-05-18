package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    static WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
