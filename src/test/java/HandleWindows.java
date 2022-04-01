import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
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
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()=\"Click Here\"]")).click();
        Set<String> allWinHadles =driver.getWindowHandles();
        Iterator<String> it =allWinHadles.iterator();
        String firstTab =it.next();
        System.out.println(firstTab);
        String secondTab =it.next();
        System.out.println(secondTab);

        driver.switchTo().window(secondTab);
        String s =driver.findElement(By.xpath("/html/body/div/h3")).getText();
        System.out.println(s);
        driver.quit();
    }
}
