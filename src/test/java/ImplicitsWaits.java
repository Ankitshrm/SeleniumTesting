import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitsWaits {

    public static String browser = "Chrome";
    public static WebDriver driver ;

    public static void main(String[] args) {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ele =driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a"));
        Actions actions =new Actions(driver);
        actions.moveToElement(ele).perform();
        driver.findElement(By.xpath("//*[text()=\"Art supplies\"] ")).click();


    }
}
