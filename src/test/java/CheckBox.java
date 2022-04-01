import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
    public static WebDriver driver;
    public static String Browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {
        if(Browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type=\"checkbox\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@value=\"Performance\"]")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElements(By.xpath("//*[@type=\"checkbox\"]")).size());
//
    }
}
