import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loactors {
    public static String Browser ="Chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (Browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Admin");

    }
}
