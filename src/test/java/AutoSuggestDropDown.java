import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestDropDown {
    public static WebDriver driver;
    public static String Browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {
        if (Browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for=\"fromCity\"]")).click();
        Thread.sleep(2000);
        WebElement from =driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
        Thread.sleep(2000);
        from.sendKeys("MUMBAI");
        Thread.sleep(2000);
        from.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        from.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();

    }
}
