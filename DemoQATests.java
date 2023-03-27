package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        String firstNameInput = "Amitabch";
        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
        firstName.sendKeys(firstNameInput);

        String lastNameInput = "Bachchan";
        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
        lastName.sendKeys(lastNameInput);

        String emailInput = "chacha@gmail.com";
        WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
        email.sendKeys(emailInput);

        WebElement maleGenderRadiobutton = driver.findElement(By.xpath("//*[@for='gender-radio-1']"));
        maleGenderRadiobutton.click();

        String mobileNumberInput = "9876543212";
        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id='userNumber']"));
        mobileNumber.sendKeys(mobileNumberInput);

        WebElement dateOfBirthInput = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
        dateOfBirthInput.click();

        WebElement montOfBirthInput = driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        montOfBirthInput.click();

        WebElement valueMontOfBirthInput = driver.findElement(By.xpath("//*[@value='9']"));
        valueMontOfBirthInput.click();

        WebElement yeartOfBirthInput = driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        yeartOfBirthInput.click();

        WebElement valueYeartOfBirthInput = driver.findElement(By.xpath("//*[@value='1941']"));
        valueYeartOfBirthInput.click();

        WebElement dayOfBirthInput = driver.findElement(By.xpath("//div[text()='11']"));
        dayOfBirthInput.click();

        String subjectsInput = "Arts";
        WebElement subjects = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
        subjects.sendKeys(subjectsInput);
        subjects.sendKeys(Keys.ENTER);

        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//*[@for='hobbies-checkbox-3']"));
        hobbiesCheckbox.click();

        WebElement selectPicture = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        selectPicture.sendKeys("C:/test/SeleniumBasic/src/test/java/ru/academits/570.jpg");

        String currentAdressInput = "Hawa Mahal Rd, Badi Choupad, Pink City";
        WebElement currentAdress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        currentAdress.sendKeys(currentAdressInput + Keys.ENTER);

        String stateSelectInput = "Rajasthan";
        WebElement stateSelect = driver.findElement(By.xpath("//*[@id='react-select-3-input']"));
        stateSelect.sendKeys(stateSelectInput);
        stateSelect.sendKeys(Keys.ENTER);

        String citySelectInput = "Jaipur";
        WebElement citySelect = driver.findElement(By.xpath("//*[@id='react-select-4-input']"));
        citySelect.sendKeys(citySelectInput);
        citySelect.sendKeys(Keys.ENTER);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.submit();

        WebElement studentName = driver.findElement(By.xpath("//td[text()='Amitabch Bachchan']"));
        Assertions.assertEquals("Amitabh Bachchan", "Amitabh Bachchan");

        WebElement studentEmail = driver.findElement(By.xpath("//td[text()='chacha@gmail.com']"));
        Assertions.assertEquals("chacha@gmail.com", "chacha@gmail.com");

        WebElement gender = driver.findElement(By.xpath("//td[text()='Male']"));
        Assertions.assertEquals("Male", "Male");

        WebElement mobile = driver.findElement(By.xpath("//td[text()='9876543212']"));
        Assertions.assertEquals("9876543212", "9876543212");

        WebElement dateOfBirth = driver.findElement(By.xpath("//td[text()='11 October,1941']"));


        WebElement subjectsString = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[6]/td[2]"));
        Assertions.assertEquals("Arts", "Arts");

        WebElement hobbies = driver.findElement(By.xpath("//td[text()='Music']"));
        Assertions.assertEquals("Music", "Music");

        WebElement picture = driver.findElement(By.xpath("//td[text()='570.jpg']"));
        Assertions.assertEquals("570.jpg", "570.jpg");

        WebElement address = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[9]/td[2]"));
        Assertions.assertEquals("Hawa Mahal Rd, Badi Choupad, Pink City", "Hawa Mahal Rd, Badi Choupad, Pink City");

        WebElement stateAndCity = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[10]/td[2]"));
        Assertions.assertEquals("Rajasthan Jaipur", "Rajasthan Jaipur");

        WebElement closeButton = driver.findElement(By.xpath("//*[@class='modal-content']//div[3]/button"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


