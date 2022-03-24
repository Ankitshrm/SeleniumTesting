import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {

    public static String browser = "Chrome";
    public static WebDriver driver ;
    public static void main(String[] args) {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }
        else{
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        driver.get("http://saucedemo.com");
        driver.manage().window().maximize();



    }
}
