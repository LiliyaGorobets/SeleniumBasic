package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        String url = "https://demoqa.com/automation-practice-form";

        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void studentRegistrationFormTest() throws InterruptedException {
        WebElement input = driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Amitabch");
        WebElement input = driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Bachchan");
        WebElement input = driver.findElement(By.xpath("//*[@userEmail']")).sendKeys("chacha@gmail.com");
        WebElement input = driver.findElement(By.xpath("//*[@id='gender-radio-1']")).click();
        WebElement input = driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("9876543212");
        WebElement input = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).sendKeys("11 October 1942");
        WebElement input = driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys("Arts");

//        WebElement input = driver.findElement(By.xpath("//*[@id='subjectsInput']"))
//        WebElement input = driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys("Badi Choupad, Pink City");
 //       WebElement input = driver.findElement(By.xpath("//*[@id='subjectsInput']"))
 //       WebElement input = driver.findElement(By.xpath("//*[@id='subjectsInput']"))

        WebElement button = driver.findElement(By.xpath("//*[@id='submit']")).click();

        String studentNameText = driver.findElement(By.xpath("//td[text()='Amitabh Bachchan']"));
        Assertions.assertEquals("Amitabh Bachchan", studentNameText);
        String studentEmailText = driver.findElement(By.xpath("//td[text()='chacha@gmail.com']"));
        Assertions.assertEquals("chacha@gmail.com", studentEmailText);
        String genderText = driver.findElement(By.xpath("//td[text()='Male']"));
        Assertions.assertEquals("Male", genderText);
        String mobileText = driver.findElement(By.xpath("//td[text()='9876543212']"));
        Assertions.assertEquals("9876543212", mobileText);
        String birthDateText = driver.findElement(By.xpath("//td[text()='11 October,1942']"));
        Assertions.assertEquals("11 October,1942", birthDateText);
        String subjectsText = driver.findElement(By.xpath("//td[text()='Arts']"));
        Assertions.assertEquals("Arts", subjectsText);
        String hobbiesText = driver.findElement(By.xpath("//td[text()='Music']"));
        Assertions.assertEquals("Music", hobbiesText);
        String pictureText = driver.findElement(By.xpath("//td[text()='570.jpg']"));
        Assertions.assertEquals("570.jpg", pictureText);
        String addressText = driver.findElement(By.xpath("//td[text()='Hawa Mahal Rd, Badi Choupad, Pink City']"));
        Assertions.assertEquals("Hawa Mahal Rd, Badi Choupad, Pink City", addressText);
        String stateAndCityText = driver.findElement(By.xpath("//td[text()='Rajasthan Jaipur']"));
        Assertions.assertEquals("Rajasthan Jaipur", stateAndCityText);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
