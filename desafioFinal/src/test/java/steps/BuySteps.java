package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import pages.*;
import static org.junit.Assert.assertTrue;

public class BuySteps {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    FinishedPage finishedPage;

    @Before
    public void setUp() {
        driver = DriverFactory.createChrome();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Dado("que eu esteja no site")
    public void que_eu_esteja_no_site() {
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }
    @Quando("eu selecionar a categoria {string}")
    public void eu_selecionar_a_categoria(String categoria) {
        homePage.categoria(categoria);
    }
    @Quando("adicionar o telefone {string} no carrinho")
    public void adicionar_o_telefone_ao_carrinho(String nomeTelefone) {
        homePage.produto(nomeTelefone);
        productPage = new ProductPage(driver);
        productPage.adicionaCarrinho();
    }
    @Quando("acessar o carrinho")
    public void acessar_o_carrinho() {
        cartPage = new CartPage(driver);
        cartPage.acessaCarrinho();
    }
    @Quando("finalizar a compra preenchendo todos os campos obrigatórios")
    public void finalizar_a_compra_preenchendo_todos_os_campos_obrigatórios() {
        finishedPage = new FinishedPage(driver);
        finishedPage.finalizaCompra(
                "Pâmela", "Brasil", "Santa Catarina", "1234567896578945", "07", "2025"
        );
    }
    @Então("apresentará a mensagem de compra com sucesso")
    public void apresentará_a_mensagem_de_compra_com_sucesso() {
        assertTrue(finishedPage.validaMensagem());
    }
}
