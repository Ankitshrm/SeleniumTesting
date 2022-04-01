import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioBox {
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
        driver.get("https://artoftesting.com/samplesiteforselenium");
        WebElement radio1 = driver.findElement(By.id("male"));
        WebElement radio2 = driver.findElement(By.id("female"));
        if (!radio1.isSelected()){
            radio1.click();
            Thread.sleep(2000);
            radio2.click();
        }

    }
}
