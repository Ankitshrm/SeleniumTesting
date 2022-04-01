import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvent {
    public static WebDriver driver;
    public static String browser ="Chrome";

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get("https://extendsclass.com/xpath-tester.html");
        driver.manage().window().maximize();
        WebElement source =driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]"));
        Actions actions =new Actions(driver);
        Thread.sleep(2000);
        actions.keyDown(source,Keys.CONTROL).sendKeys("a").sendKeys("c").perform();
        WebElement target =driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[6]/div[2]/div/div[6]"));
        Thread.sleep(2000);
        actions.keyDown(target,Keys.CONTROL).sendKeys("a").sendKeys("v").perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
