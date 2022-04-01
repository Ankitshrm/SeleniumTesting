import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeWidget {
    public static WebDriver driver;
    public static String browser ="Chrome";

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }
        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement frame =driver.findElement(By.xpath("//*[@class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);
        WebElement ele =driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
        Actions actions =new Actions(driver);
        actions.dragAndDropBy(ele,300,100).perform();

    }
}
