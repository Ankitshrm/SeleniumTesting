import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static String browser ="Chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement frame =driver.findElement(By.xpath("//*[@class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);
        WebElement el =driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
        Actions actions =new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDropBy(el,-300,0).perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
