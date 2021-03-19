package step_definition;

import driver.DriverInitializer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class ResetPasswordStepdefs {

    WebDriver driver = DriverInitializer.getDriver("chrome");


    @Given("Open the browser and navigate to login page for reset")
    public void openTheBrowserAndNavigateToLoginPageForReset() throws MalformedURLException {
        driver.navigate().to(new URL("https://secure-sandbox.modulrfinance.com/"));
    }

    @And("Click on Forgotten Password link")
    public void clickOnForgottenPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement forgotPasswordHref = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgotPasswordHref")));
        forgotPasswordHref.click();
    }

    @Then("User should navigate to Reset access page")
    public void userShouldNavigateToResetAccessPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='reset-access-prompt-btn-submit']")));
        resetButton.isDisplayed();

    }

    @When("User enters {string} and click on Request a reset button")
    public void userEntersAndClickOnRequestAResetButton(String username) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameInput")));
        usernameElement.sendKeys(username);

        driver.findElement(By.xpath("//button[@data-qa='reset-access-prompt-btn-submit']")).click();
    }

    @Then("If {string} is valid it should show email sent confirmation message")
    public void ifIsValidItShouldShowEmailSentConfirmationMessage(String result) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement emailSentHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailSentHeading")));
        if ("invalid".equalsIgnoreCase(result)) {
            // verify email message should not display
            emailSentHeading.isDisplayed();
        } else {
            // verify email message should display
            emailSentHeading.isDisplayed();
        }
        Thread.sleep(2000);
        driver.close();
    }

    @When("User click on Cancel button at Request a reset page")
    public void userClickOnCancelButtonAtRequestAResetPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cancelbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancelHref")));
        cancelbutton.click();
    }

    @Then("It should redirect user to login page")
    public void itShouldRedirectUserToLoginPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loginInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='signin-btn']")));
        loginInButton.isDisplayed();
        Thread.sleep(2000);
        driver.close();
    }

}
