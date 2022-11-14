

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestRemoveFromTheList {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/index.html");

		int HowManyItems = 1;
		
		System.out.println(HowManyItems + "this is the number that i will remove");

		List<WebElement> theStudents = driver.findElements(By.tagName("option"));
		int theTotalNumberOfStudents = theStudents.size();
		System.out.println(theTotalNumberOfStudents + "original");

		// --------------I need to remove one items
		for (int i = 0; i < HowManyItems; i++) {
			driver.findElement(By.id("remove")).click();
		}
		
		List<WebElement> theStudentsafter = driver.findElements(By.tagName("option"));
		int actualItems = theStudentsafter.size();

		System.out.println(actualItems + "after remove");


		int expectedItems = theTotalNumberOfStudents - HowManyItems;
		
		System.out.println(expectedItems + "Expected");

		Assert.assertEquals(actualItems, expectedItems);

	}

}
