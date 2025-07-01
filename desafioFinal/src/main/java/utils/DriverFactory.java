package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }

}