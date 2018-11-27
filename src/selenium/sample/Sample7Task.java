package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkbox : checkBoxes) {
            assertFalse(checkbox.isSelected());
        }

//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[id='vfb-6-1'"));
        option2.click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[id='vfb-6-0'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[id='vfb-6-2'"));
        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());

//        tick  "Option 3"
        option3.click();

//        click result
        WebElement result = driver.findElement(By.cssSelector(".w3-small[id='result_button_checkbox']"));
        result.click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        WebElement text = driver.findElement(By.id("result_checkbox"));
        assertEquals("You selected value(s): Option 2, Option 3", text.getText());
        assertTrue(text.isDisplayed());
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());
        }

//        select  "Option 3"
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
        option3.click();
// we can click also like this:
// radioButtons.get(2).click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));

        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

//       we can check also like this:
//       assertFalse(radioButtons.get(0).isSelected());
//       assertFalse(radioButtons.get(1).isSelected());
//       assertTrue(radioButtons.get(2).isSelected());

//        select  "Option 1"
        option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option1.isSelected());

//        click result
        WebElement result = driver.findElement(By.cssSelector(".w3-small[id='result_button_ratio']"));
        result.click();

//        check that 'You selected option: Option 1' text is being displayed
        assertEquals("You selected option: Option 1", driver.findElement(By.id("result_radio")).getText());
        assertTrue(driver.findElement(By.id("result_radio")).isDisplayed());
    }

    @Test
    public void selectOption() throws Exception {
//         TODO:
//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByValue("value3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByValue("value2");

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
        driver.findElement(By.id("result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
        assertEquals("You selected option: Option 2", driver.findElement(By.id("result_select")).getText());
        assertTrue(driver.findElement(By.id("result_select")).isDisplayed());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget

//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
        String dateEnter = "02/05/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));

        dateBox.sendKeys(dateEnter);

//        check that correct date is added
        assertEquals(dateEnter, dateBox.getAttribute("value"));
    }
}
