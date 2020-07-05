import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


    public class Cart {

        private WebDriver driver;

        @Before
        public void initDriver() {

            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");

        }

        @Test
    public void addToCart() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(1) > a > img")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        TimeUnit.SECONDS.sleep(3);

    }

    @Test
    public void addInvalidNumberToCart() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-423")).click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("-5");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();
        WebElement cartElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(cartElement.isDisplayed());
        Assert.assertEquals("Racer Back Maxi Dress was added to your shopping cart.",cartElement.getText());
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void addStringToQuantity() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span"));
        actions.moveToElement(menuOption).perform();
        WebElement subMenuOption = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[2]/a"));
        actions.moveToElement(subMenuOption).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-557")).click();
        driver.findElement(By.cssSelector("#links_19")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("carte");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();
        TimeUnit.SECONDS.sleep(3);
    }

        @Test
        public void MultipleProductsAddToCart() throws InterruptedException {
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > ul > li:nth-child(3) > a > img")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
            driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > div > div.breadcrumbs > ul > li.category21 > a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#shopping-cart-table > tfoot > tr > td > button.button2.btn-continue > span > span")).click();
            driver.findElement(By.cssSelector("#links_19")).click();

        }

        @Test
        public void MultipleProductsRemoveToCart() throws InterruptedException {
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > ul > li:nth-child(3) > a > img")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
        }

        @Test
        public void SingleProductRemoveFromCart() throws InterruptedException {
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > ul > li:nth-child(3) > a > img")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
            driver.findElement(By.cssSelector("#cart-sidebar > li > div > a.remove")).click();
            TimeUnit.SECONDS.sleep(5);
            //WebElement welcomeElement = driver.findElement(By.cssSelector("#minicart-success-message"));
            //Assert.assertTrue(welcomeElement.isDisplayed());
            //Assert.assertEquals("Item was removed successfully.",welcomeElement.getText());

        }

        @After
        public void exit(){
            driver.quit();
    }
}
