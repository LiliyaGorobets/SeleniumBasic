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

        WebElement selectPicture = driver.findElement(By.xpath("//input[@type='file']"));
        selectPicture.sendKeys("https://github.com/LiliyaGorobets/SeleniumBasic/blob/master/570.jpg");

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

        WebElement studentNameInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[1]/td[2]"));
        String studentNameText = studentNameInput.getText();
        Assertions.assertEquals("Amitabch Bachchan", studentNameText);

        WebElement studentEmailInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[2]/td[2]"));
        String studentEmailText = studentEmailInput.getText();
        Assertions.assertEquals("chacha@gmail.com", studentEmailText);

        WebElement genderInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[3]/td[2]"));
        String genderText = genderInput.getText();
        Assertions.assertEquals("Male", genderText);

        WebElement mobileInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[4]/td[2]"));
        String mobileInputText = mobileInput.getText();
        Assertions.assertEquals("9876543212", mobileInputText);

        WebElement dateOfBirthString = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[5]/td[2]"));
        String dateOfBirthStringText = dateOfBirthString.getText();
        Assertions.assertEquals("11 October,1941", dateOfBirthStringText);

        WebElement subjectsString = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[6]/td[2]"));
        String subjectsStringText = subjectsString.getText();
        Assertions.assertEquals("Arts", subjectsStringText);

        WebElement hobbiesInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[7]/td[2]"));
        String hobbiesInputText = hobbiesInput.getText();
        Assertions.assertEquals("Music", hobbiesInputText);

        driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[8]/td[2]"));
        Assertions.assertEquals("570.jpg", driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[8]/td[2]")).getText());

        WebElement addressInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tbody/tr[9]/td[2]"));
        String addressText = addressInput.getText();
        Assertions.assertEquals("Hawa Mahal Rd, Badi Choupad, Pink City", addressText);

        WebElement stateAndCityInput = driver.findElement(By.xpath("//*[@class='table-responsive']//tr[last()]/td[2]"));
        String stateAndCityText = stateAndCityInput.getText();
        Assertions.assertEquals("Rajasthan Jaipur", stateAndCityText);

        WebElement closeButton = driver.findElement(By.xpath("//*[@class='modal-content']//div[3]/button"));
        closeButton.click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}