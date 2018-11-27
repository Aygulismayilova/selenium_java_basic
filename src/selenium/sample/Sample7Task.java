package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/act";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("w3-check[type='checkbox']"));
        WebElement checkboxOption1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkboxOption2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkboxOption3 = driver.findElement(By.id("vfb-6-2"));
        WebElement result = driver.findElement(By.id("result_button_checkbox"));
        WebElement checkboxDisplay = driver.findElement(By.id("result_checkbox"));
//        check that none of the checkboxes are ticked
        for (WebElement checkbox : checkboxes){
            assertFalse(checkbox.isSelected());
        }
//        tick  "Option 2"
        checkboxOption2.click();
        assertTrue(checkboxOption2.isSelected());
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(checkboxOption1.isSelected());
        assertTrue(checkboxOption2.isSelected());
        assertFalse(checkboxOption3.isSelected());
//        tick  "Option 3"
        checkboxOption3.click();
        assertTrue(checkboxOption3.isSelected());
//        click result
        result.click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertTrue(checkboxDisplay.isDisplayed());
        assertEquals("You selected value(s): Option 2, Option 3", checkboxDisplay.getText());

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));
        WebElement radioResult = driver.findElement(By.id("result_button_ratio"));
        WebElement radioDisplay = driver.findElement(By.id("result_radio"));
//        check that none of the radio are selected
        for (WebElement radioButton : radioButtons){
            assertFalse(radioButton.isSelected());
        }
//        select  "Option 3"
        radioButton3.click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertTrue(radioButton3.isSelected());
        assertFalse(radioButton1.isSelected());
        assertFalse(radioButton2.isSelected());
//        select  "Option 1"
        radioButton1.click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(radioButton1.isSelected());
        assertFalse(radioButton2.isSelected());
        assertFalse(radioButton3.isSelected());
//        click result
        radioResult.click();
//        check that 'You selected option: Option 1' text is being displayed
        assertTrue(radioDisplay.isDisplayed());
        assertEquals("You selected option: Option 1", radioDisplay.getText());

    }

    @Test
    public void selectOption() throws Exception {
//         TODO:
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        WebElement resultButton = driver.findElement(By.id("result_button_select"));
        WebElement dropdownDisplay = driver.findElement(By.id("result_select"));
//        select "Option 3" in Select
        dropdown.selectByVisibleText("Option 3");
//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
//        select "Option 2" in Select
        dropdown.selectByValue("value2");
//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
//        click result
        resultButton.click();
//        check that 'You selected option: Option 2' text is being displayed
        assertTrue(dropdownDisplay.isDisplayed());
        assertEquals("You selected option: Option 2", dropdownDisplay.getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
        Calendar cal = Calendar.getInstance();
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        assertEquals("", dateBox.getAttribute("value"));
        String requiredMonth = "July";
        String requiredYear = "2007";
//        enter date '4 of July 2007' using calendar widget
        dateBox.click();
//        boolean isPresentMonth = driver.findElement(By.className("ui-datepicker-month")).getText() == requiredMonth;
//        boolean isPresentYear = driver.findElement(By.className("ui-datepicker-year")).getText() == requiredYear;

//TRIED SOMETHING DIDN'T WORK :(

//        while (!(driver.findElement(By.className("ui-datepicker-year")).getText() == requiredYear)){
//            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
//        }
//        assertEquals(requiredYear, driver.findElement(By.className("ui-datepicker-year")).getText());
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
        String dateToEnter = "5/2/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
//        enter date '2 of May 1959' using text
        dateBox.sendKeys(dateToEnter);
//        check that correct date is added
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }
}
