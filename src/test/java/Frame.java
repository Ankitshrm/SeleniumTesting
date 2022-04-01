import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame {
    private static String browser ="Chrome";
    private static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
//        driver.quit();

        WebElement targetFrame = driver.findElement(By.id("s"));
        driver.switchTo().frame(targetFrame);

    }
}
//browser.switch_to.frame(browser.find_element_by_xpath('//*[@id="layui-layer-iframe6"]'))
