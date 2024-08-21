import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class wikipediaTest {
    WebDriver driver ;

    @BeforeClass
    public void setUpBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        driver.manage().window().maximize();
        options.addArguments("--remote-allow-origins=*");
    }

    @Test()
    public void searchWikipediaTest(){

        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Automation testing");

        WebElement searchIcon = driver.findElement(new By.ByXPath("//*[@id=\"search-form\"]/fieldset/button"));
        searchIcon.click();

        Assert.assertEquals(driver.getTitle(),"Test automation - Wikipedia","Page Title : "+driver.getTitle() );

        Assert.assertTrue(driver.getPageSource().contains("Test automation can automate some repetitive but necessary tasks in a formalized testing process"),"True");
    }
}
