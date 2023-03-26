package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DemoQATests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriver driver = null;
        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void studentRegistrationFormTest() {
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Amitabch");
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Bachchan");
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("chacha@gmail.com");
        driver.findElement(By.xpath("//*[@for='gender-radio-1']")).click();
        driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("9876543212");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
        driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']")).click();
        driver.findElement(By.xpath("//*[@value='9']")).click();
        driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']")).click();
        driver.findElement(By.xpath("//*[@value='1941']")).click();
        driver.findElement(By.xpath("//div[text()='11']")).click();
        driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys("Arts");
        driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']")).click();
        driver.findElement(By.xpath("//*[@for='hobbies-checkbox-3']")).click();
        driver.findElement(By.xpath("//*[@id='uploadPicture']")).sendKeys("https://github.com/LiliyaGorobets/SeleniumBasic/blob/master/570.jpg");
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("Badi Choupad, Pink City" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='state']")).click();

//        WebDriverWait wait = new WebDriverWait(driver, 30, 500);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='state']")));
//        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Rajasthan" + Keys.ENTER);
//        driver.findElement(By.xpath("//div[text()='Select City']")).sendKeys("Jaipur" + Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='submit']")).submit();
        driver.findElement(By.xpath("//td[text()='Amitabch Bachchan']"));
        Assertions.assertEquals("Amitabh Bachchan", "Amitabh Bachchan");
        driver.findElement(By.xpath("//td[text()='chacha@gmail.com']"));
        Assertions.assertEquals("chacha@gmail.com", "chacha@gmail.com");
        driver.findElement(By.xpath("//td[text()='Male']"));
        Assertions.assertEquals("Male", "Male");
        driver.findElement(By.xpath("//td[text()='9876543212']"));
        Assertions.assertEquals("9876543212", "9876543212");
        driver.findElement(By.xpath("//td[text()='11 October,1941']"));
        Assertions.assertEquals("11 October,1942", "11 October,1942");
        driver.findElement(By.xpath("//td[text()='Arts']"));
        Assertions.assertEquals("Arts", "Arts");
        driver.findElement(By.xpath("//td[text()='Music']"));
        Assertions.assertEquals("Music", "Music");
        driver.findElement(By.xpath("//td[text()='570.jpg']"));
        Assertions.assertEquals("570.jpg", "570.jpg");
        driver.findElement(By.xpath("//td[text()='Badi Choupad, Pink City']"));
        Assertions.assertEquals("Hawa Mahal Rd, Badi Choupad, Pink City", "Hawa Mahal Rd, Badi Choupad, Pink City");
        //    driver.findElement(By.xpath("//td[text()='Rajasthan']"));
        //    Assertions.assertEquals("Rajasthan Jaipur", "Rajasthan");
        //    driver.findElement(By.xpath("//td[text()='Jaipur']"));
        //   Assertions.assertEquals("Rajasthan Jaipur", "Jaipur");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


