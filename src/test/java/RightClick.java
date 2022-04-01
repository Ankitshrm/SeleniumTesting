import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    public static String browser ="Chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement ele = driver.findElement(By.id("swatch"));
        Actions actions =new Actions(driver);
        actions.contextClick(ele).perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
