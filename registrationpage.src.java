package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By username = By.name("username");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By registerBtn = By.id("register");

    public void register(String fName, String lName, String uName, String pwd, String cpwd) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(username).sendKeys(uName);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(cpwd);
        driver.findElement(registerBtn).click();
    }
}
