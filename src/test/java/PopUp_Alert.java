import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopUp_Alert {
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
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);

        System.out.println(alert.getText());

        Thread.sleep(2000);

        alert.accept();

        driver.quit();


    }
}
