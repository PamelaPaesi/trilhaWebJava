import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class desafio1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);


        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.className("app_logo"));
            System.out.println("Logou!");
        } finally {
            driver.quit();
        }
    }
}
