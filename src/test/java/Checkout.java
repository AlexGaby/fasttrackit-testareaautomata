import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import java.util.concurrent.TimeUnit;

public class Checkout {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void CheckoutAsGuest() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button > span > span")).click();
        driver.findElement(By.cssSelector("#onepage-guest-register-button > span > span")).click();
        driver.findElement(By.cssSelector("#billing\\:firstname")).sendKeys("Inter");
        driver.findElement(By.cssSelector("#billing\\:lastname")).sendKeys("Ianis");
        driver.findElement(By.cssSelector("#billing\\:email")).sendKeys("alex@yahoo.com");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("Strada Crizantemei, Bloc 20, Scara C, Etaj 99");
        driver.findElement(By.cssSelector("#billing\\:city")).sendKeys("Cluj");
        driver.findElement(By.cssSelector("#billing\\:region_id")).click();
        driver.findElement(By.cssSelector("#billing\\:region_id")).sendKeys("Oregon");
        driver.findElement(By.cssSelector("#billing\\:region_id")).click();
        driver.findElement(By.cssSelector("#billing\\:postcode")).sendKeys("923456");
        driver.findElement(By.cssSelector("#billing\\:country_id")).click();
        driver.findElement(By.cssSelector("#billing\\:country_id")).sendKeys("Statele Unite ale Americii");
        driver.findElement(By.cssSelector("#billing\\:country_id")).click();
        driver.findElement(By.cssSelector("#billing\\:telephone")).sendKeys("0744567890");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span"));
        button.click();
        Actions actions2 = new Actions(driver);
        WebElement button2 = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
        button2.click();
        Actions actions3 = new Actions(driver);
        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button/span/span"));
        button3.click();
        driver.findElement(By.cssSelector("#review-buttons-container > button > span > span")).click();

    }

    @Test
    public void CheckoutWithExistingAccount() throws InterruptedException {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("alexgabriel_n@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button > span > span")).click();
        driver.findElement(By.cssSelector("#onepage-guest-register-button > span > span")).click();
        driver.findElement(By.cssSelector("#billing\\:firstname")).sendKeys("Inter");
        driver.findElement(By.cssSelector("#billing\\:lastname")).sendKeys("Ianis");
        driver.findElement(By.cssSelector("#billing\\:email")).sendKeys("alex@yahoo.com");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("Strada Crizantemei, Bloc 20, Scara C, Etaj 99");
        driver.findElement(By.cssSelector("#billing\\:city")).sendKeys("Cluj");
        driver.findElement(By.cssSelector("#billing\\:region_id")).click();
        driver.findElement(By.cssSelector("#billing\\:region_id")).sendKeys("Oregon");
        driver.findElement(By.cssSelector("#billing\\:region_id")).click();
        driver.findElement(By.cssSelector("#billing\\:postcode")).sendKeys("923456");
        driver.findElement(By.cssSelector("#billing\\:country_id")).click();
        driver.findElement(By.cssSelector("#billing\\:country_id")).sendKeys("Statele Unite ale Americii");
        driver.findElement(By.cssSelector("#billing\\:country_id")).click();
        driver.findElement(By.cssSelector("#billing\\:telephone")).sendKeys("0744567890");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button"));
        button.click();
        TimeUnit.SECONDS.sleep(4);
        Actions actions2 = new Actions(driver);
        WebElement button2 = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span"));
        button2.click();
        TimeUnit.SECONDS.sleep(4);
        Actions actions3 = new Actions(driver);
        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button"));
        button3.click();
        TimeUnit.SECONDS.sleep(4);
        driver.findElement(By.cssSelector("#review-buttons-container > button")).click();
    }

    @After
    public void exit(){
        driver.quit();
    }
}