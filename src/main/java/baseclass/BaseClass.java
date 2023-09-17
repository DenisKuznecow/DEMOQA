package baseclass;
import com.methods.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practiceformpage.PracticeFormPage;

import java.time.Duration;
import java.util.Locale;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public static final String URL = "https://demoqa.com/automation-practice-form";
    public Methods methods;
    public Faker ukFaker;
    public Faker faker;

    public PracticeFormPage practiceFormPage;
    Actions actions;
    public void waitTime() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        ukFaker=new Faker(new Locale("en-GB"));
        faker=new Faker();
    }
    @AfterMethod
    public void tear_down() {
        waitTime();
        driver.quit();
    }
}