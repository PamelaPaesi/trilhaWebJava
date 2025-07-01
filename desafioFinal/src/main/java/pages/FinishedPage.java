package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class FinishedPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FinishedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }
    public void finalizaCompra(String nome, String pais, String cidade, String cartao, String mes, String ano) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(nome);
        driver.findElement(By.id("country")).sendKeys(pais);
        driver.findElement(By.id("city")).sendKeys(cidade);
        driver.findElement(By.id("card")).sendKeys(cartao);
        driver.findElement(By.id("month")).sendKeys(mes);
        driver.findElement(By.id("year")).sendKeys(ano);
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }
    public boolean validaMensagem() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert > h2")));
        return msg.getText().contains("Thank you for your purchase!");
    }
}