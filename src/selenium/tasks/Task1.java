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

        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));

//        enter a text instead of a number, check that correct error is seen

        String expectedTxt = "Please enter a number";
        String actualTxt = driver.findElement(By.id("ch1_error")).getText();
        enterNumb.sendKeys("fgh");
        assertEquals(expectedTxt, actualTxt );

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO

          WebElement enterNumb = driver.findElement(By.id("numb"));
          WebElement submit = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
          WebElement errorMessage = driver.findElement(By.id("ch1_error"));
//        enter number which is too small (below 50), check that correct error is seen

          String expectedTxt = "Number is too small";
          String actualTxt = driver.findElement(By.id("error")).getText();
          String tooSmallString = "10";

          enterNumb.sendKeys(String.valueOf(tooSmallString));
          submit.click();

          assertEquals(expectedTxt, actualTxt);
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
          WebElement enterNumb = driver.findElement(By.id("numb"));
          WebElement submit = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
          WebElement errorMessage = driver.findElement(By.className("error"));
//        enter number which is too big (above 100), check that correct error is see

          String expectedTxt = "Number is too big";
          String actualTxt = driver.findElement(By.className("error")).getText();
          String tooBigString = "200";

          enterNumb.sendKeys(String.valueOf(tooBigString));
          submit.click();

          assertEquals(expectedTxt, actualTxt);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO

        WebElement enterNumb = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        String squareRootOk = "81";
        enterNumb.sendKeys(String.valueOf(squareRootOk));
        submit.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(),"Square root of 81 is 9.00" );
        alert.accept();

//        String actualTxt = driver.findElement(By.id("error")).getText();
//        assertEquals(expectedTxt, actualTxt);

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
