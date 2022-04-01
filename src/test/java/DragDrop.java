import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
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
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement frame =driver.findElement(By.xpath("//*[@class=\"demo-frame lazyloaded\"]"));
        driver.switchTo().frame(frame);
        WebElement drag =driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]"));
        WebElement drop =driver.findElement(By.xpath("//*[@id=\"trash\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }
}
