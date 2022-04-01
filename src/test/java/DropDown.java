import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static String browser ="Chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get("https://sugarcrm.com/au/request-demo");

        Select select=new Select(driver.findElement(By.name("employees_c")));
        select.selectByVisibleText("1 - 10 employees");
        Thread.sleep(3000);
        select.selectByValue("level2");
        Thread.sleep(3000);
        select.selectByIndex(4);

        Select list =new Select(driver.findElement(By.name("employees_c")));
        List<WebElement> ele =list.getOptions();
        System.out.println(ele.size());


        driver.navigate().to("http://automate-apps.com/select-multiple-options-from-a-drop-down-list/");
        Select mulSelect =new Select(driver.findElement(By.name("cars")));

        if (mulSelect.isMultiple()){
            List<WebElement> test1 = mulSelect.getOptions();
            System.out.println(test1.size());
            mulSelect.selectByIndex(1);
            mulSelect.selectByIndex(2);
        }else{
            System.out.println("No multiple dropdown");
        }

        List<WebElement> alltag = driver.findElements(By.tagName("option"));
        System.out.println(alltag.size());

        for(int i=0;i<alltag.size();i++)
        {
            System.out.println(i+1+" - > " +alltag.get(i).getAttribute("value     ")+alltag.get(i).getText());
        }
            driver.quit();





    }
}
