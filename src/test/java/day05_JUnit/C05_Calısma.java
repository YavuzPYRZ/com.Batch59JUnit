package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Calısma {
    public static void main(String[] args) {

        //1. http://zero.webappsecurity.com sayfasina gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");


        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        WebElement SignInElementi =driver.findElement(By.xpath("//input[@value='Sign in']"));
        SignInElementi.click();
        driver.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("3000");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();


        //10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin

        WebElement cıkanyazı = driver.findElement(By.xpath("//h2"));

        if (cıkanyazı.isDisplayed()){
            System.out.println("Test PASSED");

        }else System.out.println("Test FAILED");


        driver.close();
    }

}
