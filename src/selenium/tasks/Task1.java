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
import static org.junit.Assert.assertTrue;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/task1");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO

        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String text = "number";
        String expectedTxt = "Please enter a number";

//      enter a text instead of a number, check that correct error is seen

        assertEquals(enterNumb.getText(), "");
        assertEquals(enterNumb.getAttribute("value"), "");

        enterNumb.clear();
        enterNumb.sendKeys(text);

        assertEquals(text, enterNumb.getAttribute("value"));
        submit.click();
        String actualTxt = driver.findElement(By.id("ch1_error")).getText();
        assertTrue(errorMessage.isDisplayed());
        assertEquals(expectedTxt, actualTxt);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO

        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String tooSmallString = "10";
        String expectedTxt = "Number is too small";
//        enter number which is too small (below 50), check that correct error is seen

        assertEquals(enterNumb.getText(), "");
        assertEquals(enterNumb.getAttribute("value"), "");

        enterNumb.clear();
        enterNumb.sendKeys(tooSmallString);

        assertEquals(tooSmallString, enterNumb.getAttribute("value"));
        submit.click();

        assertTrue(errorMessage.isDisplayed());
        assertEquals(expectedTxt, driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        WebElement errorMessage = driver.findElement(By.className("error"));
        String expectedTxt = "Number is too big";
        String tooBigString = "200";
//        enter number which is too big (above 100), check that correct error is see

        assertEquals(enterNumb.getText(), "");
        assertEquals(enterNumb.getAttribute("value"), "");

        enterNumb.clear();
        enterNumb.sendKeys(tooBigString);

        assertEquals(tooBigString, enterNumb.getAttribute("value"));
        submit.click();

        assertTrue(errorMessage.isDisplayed());
        assertEquals(expectedTxt, driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO

        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String squareRootOk = "81";
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        enterNumb.sendKeys(String.valueOf(squareRootOk));
        submit.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(), "Square root of 81 is 9.00");
        alert.accept();
    }

    @Test
    public void correctSquareRootWithRemainder() throws InterruptedException {
//        TODO
        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String squareRootOk = "85";
//      enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//      then check that correct no error is seen and check that square root is calculated correctly

        enterNumb.sendKeys(String.valueOf(squareRootOk));
        submit.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(), "Square root of 85 is 9.22");
        alert.accept();
    }
}
