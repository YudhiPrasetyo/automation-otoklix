import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class AutomationSauceDemo2 {

    public static void main (String args[] ) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.cssSelector("input[id*='user-name']"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.cssSelector("input[id*='password']"));
        inputPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[id*='login-button']"));
        btnLogin.click();

        WebElement itemBackPack = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
        itemBackPack.click();

        WebElement btnAddToCart = driver.findElement(By.cssSelector("button[class*='btn_primary']"));
        btnAddToCart.click();

        WebElement iconShoppingCart = driver.findElement(By.cssSelector("svg[data-icon='shopping-cart']"));
        iconShoppingCart.click();

        WebElement btnCheckout = driver.findElement(By.cssSelector("a[class*='checkout_button']"));
        btnCheckout.click();

        WebElement inputFirstName = driver.findElement(By.cssSelector("input[id*='first-name']"));
        inputFirstName.sendKeys("Yudhi");

        WebElement inputLastName = driver.findElement(By.cssSelector("input[id*='last-name']"));
        inputLastName.sendKeys("Prasetyo");

        WebElement inputPostalCode = driver.findElement(By.cssSelector("input[id*='postal-code']"));
        inputPostalCode.sendKeys("12490");

        WebElement btnContinue = driver.findElement(By.cssSelector("input[class*='cart_button']"));
        btnContinue.click();

        WebElement btnFinish = driver.findElement(By.cssSelector("a[class*='cart_button']"));
        btnFinish.click();

        WebElement labelFinish = driver.findElement(By.cssSelector("div[class*='subheader']"));
        String actualLabel = labelFinish.getText();
        assertEquals("Finish", actualLabel);

        WebElement labelThankYou = driver.findElement(By.cssSelector("h2[class*='complete-header']"));
        String actualLabel2 = labelThankYou.getText();
        assertEquals("THANK YOU FOR YOUR ORDER", actualLabel2);

        Thread.sleep(3000);
        driver.quit();




    }
}
