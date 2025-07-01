package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void acessaCarrinho(){
        driver.findElement(By.id("cartur")).click();
    }
}