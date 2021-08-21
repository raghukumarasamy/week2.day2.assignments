package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter your email address
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rocker.ragu@gmail.com");

		// Append a text and press keyboard tab
		WebElement appendtxtbox = driver.findElement(By.xpath("//input[@value='Append ']"));
		String appendval = appendtxtbox.getAttribute("Value");
		appendtxtbox.clear();
		appendtxtbox.sendKeys(appendval + "Append_123");
		appendtxtbox.sendKeys(Keys.TAB);

		// Get default text entered
		WebElement defaulttxt = driver.findElement(By.xpath("//input[@name='username']"));
		String dafaulttxtval = defaulttxt.getAttribute("Value");
		System.out.println(dafaulttxtval);

		// Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		// Confirm that edit field is disabled
		WebElement disabled = driver.findElement(By.xpath("//input[@disabled='true']"));
		if (disabled.isEnabled()) {
			System.out.println("Last edit field is enabled");
		} else {
			System.out.println("Last edit field is disabled");
		}
	}
}
