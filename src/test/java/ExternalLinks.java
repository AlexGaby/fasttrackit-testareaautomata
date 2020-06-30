import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ExternalLinks {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void ConnectLinksValidation() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div.links.social-media > ul > li:nth-child(1) > a")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div.links.social-media > ul > li:nth-child(2) > a")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div.links.social-media > ul > li:nth-child(3) > a")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div.links.social-media > ul > li:nth-child(4) > a")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div.links.social-media > ul > li.last > a")).click();
        TimeUnit.SECONDS.sleep(3);

    }
    @After
    public void exit(){
        driver.quit();
    }
}
