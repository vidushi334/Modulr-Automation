package step_definition;

import driver.DriverInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginStepdefs {

    WebDriver driver = DriverInitializer.getDriver("chrome");

    @Given("Open the browser and navigate to login page")
    public void openTheBrowserAndNavigateToLoginPage() throws MalformedURLException {
        driver.navigate().to(new URL("https://secure-sandbox.modulrfinance.com/"));
    }

    @When("^User enters \"(.*)\" and \"(.*)\" and click on login button$")
    public void userEntersUsernameAndPasswordAndClickOnLoginButton(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-inp")));
        usernameElement.sendKeys(username);
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-inp")));
        passwordElement.sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("signInSubmitButton")).click();
    }


    @Then("Sign in button should be disabled to prevent duplicate requests being triggered")
    public void signInButtonShouldBeDisabledToPreventDuplicateRequestsBeingTriggered() {
        WebElement signInButton = driver.findElement(By.id("signInSubmitButton"));
        Assert.assertEquals(false, signInButton.isEnabled());
    }

    @Then("^User should be able to login on valid \"(.*)\" and show error message on invalid result$")
    public void userShouldBeAbleToLoginAndNavigatedToAccountOverviewPage(String result) throws InterruptedException {
        if("invalid".equalsIgnoreCase(result)){
            driver.findElement(By.xpath("//div[@data-qa='signin-div-error-display']")).isDisplayed();
        }
        else if("required".equalsIgnoreCase(result)){
            driver.findElement(By.xpath("//div[@data-qa='error-message-div-display']")).isDisplayed();
        }
        else {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-qa='account-id-cell']")));
            accountElement.isDisplayed();
        }
        Thread.sleep(3000);
        driver.close();
    }

}
