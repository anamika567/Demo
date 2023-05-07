package GenericUtility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	/**
	 * This method is used to maximize window
	 * 
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * Thus method is used to wait for the page load
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait until element is visible
	 * @param driver
	 * @param element
	 */
	
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 */
	
	public void select(WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will select data from dropdown using visible text
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
    }
	
}
