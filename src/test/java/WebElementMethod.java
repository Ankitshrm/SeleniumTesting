import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementMethod {
    public static String browser ="Chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://sugarcrm.com/au/request-demo");
        driver.manage().window().maximize();

        //SendKeys Method
        driver.findElement(By.xpath("//*[@id=\"field7\"]/div/input")).sendKeys("ankitsharma97194@gmail.com");

        //Clear Method
        driver.findElement(By.xpath("//*[@id='field7']/div/input")).clear();
        driver.findElement(By.xpath("//*[@id='field7']/div/input")).sendKeys("update link");

        //Attribute
        String Attri =driver.findElement(By.xpath("//*[@id=\"field7\"]/div/input")).getAttribute("placeholder");
        System.out.println(Attri);

        //CSS
        String CSS =driver.findElement(By.xpath("//*[@id='field7']/div/input")).getCssValue("background-color");
        System.out.println(CSS);

        //get size
        System.out.println(driver.findElement(By.xpath("//*[@id='field7']/div/input")).getLocation());
        System.out.println(driver.findElement(By.xpath("//*[@id='field7']/div/input")).getSize());
        System.out.println(driver.findElement(By.xpath("//*[@id='field7']/div/input")).getTagName());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div/div/div/div[2]/p[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"doi0\"]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"doi0\"]")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"doi0\"]")).isSelected());
        driver.quit();

    }
}


