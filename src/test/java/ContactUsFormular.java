import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ContactUsFormular {
    private static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void ContactUsValidEmail(){
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#email")).sendKeys("alexgabriel_n@yahoo.com");
        driver.findElement(By.cssSelector("#comment")).sendKeys("Buna ziua! As avea o intrebare.");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        WebElement contactElement = driver.findElement(By.cssSelector("#messages_product_view > ul > li > ul > li > span"));
        Assert.assertTrue(contactElement.isDisplayed());
        Assert.assertEquals("Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.",contactElement.getText());

    }

    @Test
    public void ContactUsInalidEmail(){
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#email")).sendKeys("alexgabriel_n@yahoo");
        driver.findElement(By.cssSelector("#comment")).sendKeys("Buna ziua! As avea o intrebare.");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        WebElement contactElement = driver.findElement(By.cssSelector("#advice-validate-email-email"));
        Assert.assertTrue(contactElement.isDisplayed());
        Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.",contactElement.getText());

    }

    @After
    public void exit(){
        driver.quit();
    }
}
