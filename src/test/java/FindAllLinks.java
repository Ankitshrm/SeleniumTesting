import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FindAllLinks {
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

        driver.get("https://www.sugarcrm.com/au/request-demo/");
        Thread.sleep(2000);

        List<WebElement> alltag = driver.findElements(By.tagName("a"));
        System.out.println(alltag.size());

        for(int i=0;i<alltag.size();i++)
        {
            System.out.println(i+1+" - > " +alltag.get(i).getAttribute("href"));
        }



        driver.quit();

    }
}
