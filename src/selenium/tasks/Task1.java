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
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
        driver.findElement(By.className(" w3-row")).click();
        WebElement Enternumber = driver.findElement(By.id("numb"));
        String expected = "saaaee";
        Enternumber .clear();
        Enternumber .sendKeys(expected);
        driver.findElement(By.className(" w3-orange")).click();

        assertEquals( "Please enter a number",driver.findElement(By.id("ch1_error")).getText());
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        driver.findElement(By.className(" w3-row")).click();
        WebElement Enternumber = driver.findElement(By.id("numb"));
        String expected = "5";
        Enternumber .clear();
        Enternumber .sendKeys(expected);
        driver.findElement(By.className(" w3-orange")).click();
        assertEquals( "Number is too small",driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen

//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.className(" w3-row")).click();
        WebElement Enternumber = driver.findElement(By.id("numb"));
        String expected = "200";
        Enternumber .clear();
        Enternumber .sendKeys(expected);
        driver.findElement(By.className(" w3-orange")).click();
        assertEquals( "Number is too big",driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
        driver.findElement(By.className(" w3-row")).click();
        WebElement Enternumber = driver.findElement(By.id("numb"));
        String expected = "64";
        Enternumber .clear();
        Enternumber .sendKeys(expected);
        driver.findElement(By.className(" w3-orange")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
        driver.findElement(By.className(" w3-row")).click();
        WebElement Enternumber = driver.findElement(By.id("numb"));
        String expected = "80";
        Enternumber .clear();
        Enternumber .sendKeys(expected);
        driver.findElement(By.className(" w3-orange")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 80 is 8.94", alert.getText());

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
