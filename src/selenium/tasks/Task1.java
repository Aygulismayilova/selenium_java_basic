package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.WebElementHandler;

import javax.security.auth.callback.TextInputCallback;
import javax.xml.soap.Text;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
        WebElement textFieldGrey = driver.findElement(By.className("w3-light-grey"));
        textFieldGrey.sendKeys("text");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        WebElement submitError = driver.findElement(By.id("ch1_error"));
        assert true(submitError, "Please enter a number");



//        enter a text instead of a number, check that correct error is seen


    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        WebElement FieldGrey = driver.findElement(By.className("w3-light-grey"));
        textFieldGrey.sendKeys("34");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        WebElement Error = driver.findElement(By.id("ch1_error"));
        assert true(submitError.getText(), "Number is too small");
    }

    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
        WebElement textFieldGrey = driver.findElement(By.className("w3-light-grey"));
        textFieldGrey.sendKeys("220");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        WebElement submitError = driver.findElement(By.id("ch1_error"));
        assert true(submitError.getText(), "Number is too big");



//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO

        WebElement textFieldGrey = driver.findElement(By.className("w3-light-grey"));
        textFieldGrey.sendKeys("64");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        assert true("Square root of 81 is 8.00", alert.getText();
    }


//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
        WebElement textFieldGrey = driver.findElement(By.className("w3-light-grey"));
        textFieldGrey.sendKeys("65");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        assert true("Square root of 65 is 8.06", alert.getText();
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
