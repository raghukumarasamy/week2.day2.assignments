package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select training program using Index
		WebElement index = driver.findElement(By.id("dropdown1"));
		Select indexDD = new Select(index);
		indexDD.selectByIndex(3);

		// Select training program using Text
		WebElement text = driver.findElement(By.name("dropdown2"));
		Select textDD = new Select(text);
		textDD.selectByVisibleText("Selenium");

		// Select training program using Value
		WebElement val = driver.findElement(By.id("dropdown3"));
		Select valDD = new Select(val);
		valDD.selectByValue("3");
		

		}

	}
