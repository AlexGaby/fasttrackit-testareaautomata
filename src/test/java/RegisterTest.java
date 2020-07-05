import net.bytebuddy.build.ToStringPlugin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.cssSelector("#email_address")).sendKeys("alexgabrielll_n@yahoo.com ");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement registerElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
        Assert.assertTrue(registerElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.",registerElement.getText());
    }

    @Test
    public void invalidsignUp() throws InterruptedException {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Alexandru");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Nemes");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("alexgabriell_n@yahoo.com ");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement registerElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li > span"));
        Assert.assertTrue(registerElement.isDisplayed());
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.",registerElement.getText());
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
        WebElement registerElement = driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertTrue(registerElement.isDisplayed());
        Assert.assertEquals("Please make sure your passwords match.",registerElement.getText());
        TimeUnit.SECONDS.sleep(3);
    }

    @After
    public void exit() {
        driver.quit();
    }
}
