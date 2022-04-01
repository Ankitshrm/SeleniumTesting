import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;

public class MouseHover {
    public static String browser = "Chrome";
    public static WebDriver driver ;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        List<WebElement> set =driver.findElements(By.xpath("//*[@class=\"figure\"]"));
        Iterator<WebElement> it =set.iterator();
        while (it.hasNext()){
            Actions  actions =new Actions(driver);
            actions.moveToElement(it.next()).perform();
            Thread.sleep(2000);
        }
//        WebElement ele =driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
//
        driver.quit();

    }
}
