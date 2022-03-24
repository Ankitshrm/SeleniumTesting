import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasicMethods {
    public static String browser="Chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }
        //Open a Url
        driver.get("https://saucedemo.com");

        //Managing window size
        driver.manage().window().maximize();

        //Get Current Url
        String url =driver.getCurrentUrl();
        System.out.println(url);

        //Get Title
        String title =driver.getTitle();
        System.out.println(title);

        //Get Page Source
        String sourceCode =driver.getPageSource();
        System.out.println(sourceCode);

        //Navigation


        driver.navigate().to("https://instagram.com");
        driver.navigate().back();
        driver.navigate().refresh();


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> list =driver.findElements(By.xpath("//*[@class='inventory_list']/div"));
        System.out.println(list);

        String currentHandles =driver.getWindowHandle();
        System.out.println(currentHandles);

        Set<String> tabNames =driver.getWindowHandles();
        System.out.println(tabNames);


        //Quiting Window
        driver.quit();
    }
}
