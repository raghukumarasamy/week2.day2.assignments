package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String hometitle = "TestLeaf - Selenium Playground";
		if (driver.getTitle().equals(hometitle)) {
			System.out.println("Landed to correct page");
		} else {
			System.out.println("landed to wrong page");
		}
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Find position of button (x,y)
		WebElement pos = driver.findElement(By.xpath("//button[@id='position']"));
		Point loc = pos.getLocation();
		int X = loc.getX();
		int Y = loc.getY();
		System.out.println("X cordinate is: " + X);
		System.out.println("X cordinate is: " + Y);
		
		// Find button color
		WebElement color = driver.findElement(By.xpath("//button[@id='color']"));
		String btncolor = color.getCssValue("background-color");
		System.out.println("Button color is: " + btncolor);
		
		// Find the height and width
		WebElement size = driver.findElement(By.xpath("//button[@id='size']"));
		int btnw = size.getSize().getWidth();
		int btnh = size.getSize().getHeight();
		System.out.println("Width is: " + btnw);
		System.out.println("Height is: " + btnh);

	}

}
