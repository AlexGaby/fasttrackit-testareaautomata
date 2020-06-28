import net.bytebuddy.build.ToStringPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    private WebDriver driver;
    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void signUp(){
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

    }

    @Test
    public void invalidsignUp() throws InterruptedException {
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
    }

    @Test
    public void notCompleteaMandatoryfield() throws InterruptedException {
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
    }

    @After
    public void exit() {
        driver.quit();
    }
}
