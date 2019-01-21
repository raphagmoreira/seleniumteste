import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.*;

public class start {
    private static WebDriver driver;
    private static JavascriptExecutor js;
    private static WebDriverWait wait;
    private static WebElement element;

    public static void main(String[] args) {
        try {
            iniciarTeste();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void insertJQuery() throws InterruptedException {
        //Injeta Jquery na página, caso não tenha
        util.insertJquery(js);
        Thread.sleep(1000);
    }

    //@BeforeClass
    //Inicia as configurações principais para o Selenium funcionar no navegador escolhido
    public static void configuracaoDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/raphaelmoreira/IdeaProjects/Selenium/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://qa.xgracco.com.br");

        js = (JavascriptExecutor) driver;
        insertJQuery();
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.
        /*@AfterClass
        public static void tearDownTest(){
            driver.quit();
        }*/

    //@Test
    public static void iniciarTeste() throws InterruptedException {
        configuracaoDriver();

        wait = new WebDriverWait(driver, 30);

        //WebElement element = driver.findElement(By.id("login"));
        //element.sendKeys("admin");

        js.executeScript("$('#login').prop('value', 'admin')");

        element = driver.findElement(By.id("passw"));
        element.sendKeys("12omega34");

        driver.findElement(By.id("btEntrar")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/a")));
        driver.findElement(By.xpath("/html/body/div/div[3]/a")).click();

        insertJQuery();
    }
}
