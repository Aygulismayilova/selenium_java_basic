package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//  enter a text instead of a number, check that correct error is seen

        WebElement numb = driver.findElement(By.className("w3-light-grey"));
        numb.sendKeys("hello");

        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();

        WebElement submitError = driver.findElement(By.id("ch1_error"));

        assertEquals(submitError.getText(), "Please enter a number");

    }

    @Test
    public void errorOnNumberTooSmall() {
//        enter number which is too small (below 50), check that correct error is seen

        WebElement numb = driver.findElement(By.className("w3-light-grey"));
        numb.sendKeys("48");  // BUG: if I enter number 49 no errors where seen

        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();

        WebElement submitError = driver.findElement(By.id("ch1_error"));

        assertEquals(submitError.getText(), "Number is too small");
        // assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        enter number which is too big (above 100), check that correct error is seen

        WebElement numb = driver.findElement(By.className("w3-light-grey"));
        numb.sendKeys("120");  //  BUG: if I enter number 666 no errors where seen

        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();

        WebElement submitError = driver.findElement(By.id("ch1_error"));

        assertEquals(submitError.getText(), "Number is too big");
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        WebElement numb = driver.findElement(By.className("w3-light-grey"));
        numb.sendKeys("64");

        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        WebElement numb = driver.findElement(By.className("w3-light-grey"));
        numb.sendKeys("55");

        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 55 is 7.42", alert.getText());

    }
}
