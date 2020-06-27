import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    public void signUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("Alexandru");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Gabi");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Nemes");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("alexgabriel_n@yahoo.com ");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        driver.quit();


    } public void invalidsignUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("Alexandru");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Nemes");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("alexgabriel_n@yahoo.com ");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
    public void notCompleteaMandatoryfield() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("Alexandru");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Nemes");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("alexgabriel_n@yahoo.com ");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}
