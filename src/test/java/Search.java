import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Search {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void SearchProduct() throws InterruptedException {

        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("roller");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement searchElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1"));
        Assert.assertTrue(searchElement.isDisplayed());
        Assert.assertEquals("SEARCH RESULTS FOR 'ROLLER'",searchElement.getText());
        TimeUnit.SECONDS.sleep(3);

    }

    @Test
    public void SearchBrand() throws InterruptedException {

        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("oxford");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement searchElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1"));
        Assert.assertTrue(searchElement.isDisplayed());
        Assert.assertEquals("SEARCH RESULTS FOR 'OXFORD'",searchElement.getText());
        TimeUnit.SECONDS.sleep(3);
    }

    @After
    public void exit(){
        driver.quit();
    }
}
