package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.RegistrationPage;
import utils.ExcelUtil;

import java.util.List;

public class RegistrationTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    }

    @DataProvider(name = "registrationData")
    public Object[][] getData() {
        List<String[]> testData = ExcelUtil.getTestData("data/TestData.xlsx");
        Object[][] data = new Object[testData.size()][5];
        for (int i = 0; i < testData.size(); i++) {
            data[i] = testData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "registrationData")
    public void testRegistration(String fName, String lName, String uName, String pwd, String cpwd) {
        driver = new ChromeDriver();
        driver.get("https://example.com/registration"); 

        RegistrationPage rp = new RegistrationPage(driver);
        rp.register(fName, lName, uName, pwd, cpwd);

        
        driver.quit();
    }
}
