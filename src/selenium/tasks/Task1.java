package selenium.tasks;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
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
        WebElement numberInput = driver.findElement(By.id("numb"));
        numberInput.sendKeys("tt");
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Eror message","Please enter a number", driver.findElement(By.id("ch1_error")).getText());


//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        WebElement numberInput = driver.findElement(By.id("numb"));
        numberInput.sendKeys("5");
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Eror message","Number is too small", driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
        WebElement numberInput = driver.findElement(By.id("numb"));
        numberInput.sendKeys("666");
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Eror message","", driver.findElement(By.id("ch1_error")).getText());

        numberInput.clear();
//        BUG:
        WebElement numberInputThree = driver.findElement(By.id("numb"));
        numberInputThree.sendKeys("49");
        driver.findElement(By.className("w3-orange")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 49 is 7.00",driver.switchTo().alert().getText());
        alert.accept();

        numberInput.clear();

        WebElement numberInputSecond = driver.findElement(By.id("numb"));
        numberInputSecond.sendKeys("555");
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Eror message","Number is too big", driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
        WebElement numberInputSecond = driver.findElement(By.id("numb"));
        numberInputSecond.sendKeys("81");
        driver.findElement(By.className("w3-orange")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00",driver.switchTo().alert().getText());
        alert.accept();

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
        WebElement numberInputSecond = driver.findElement(By.id("numb"));
        numberInputSecond.sendKeys("99");
        driver.findElement(By.className("w3-orange")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 99 is 9.95",driver.switchTo().alert().getText());
        alert.accept();
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
