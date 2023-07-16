package Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goodreads {

	public static void main(String[] args) {
		//Connect ChromeDriver
		System.setProperty("webdriver.driver.chrome", "C:\\Users\\ASUS\\Favorites\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//1) Login to goodreads website
		driver.get("https://www.goodreads.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath( "//button[@class='gr-button gr-button--dark gr-button--auth authPortalConnectButton authPortalSignInButton']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("shettynikhil56@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Nikhil@45");
		driver.findElement(By.id("signInSubmit")).click();
		
		//2) Search for Jungle book
		driver.findElement(By.name("q")).sendKeys("Jungle book");
		driver.findElement(By.xpath( "//button[@class='searchBox__icon--magnifyingGlass gr-iconButton searchBox__icon searchBox__icon--navbar\']")).click();
		
		//3) Mark the Book as "want to read"
		driver.findElement(By.xpath( "//button[@class='wtrToRead']")).click();
		
		//Remove the selected book
		driver.findElement(By.linkText("My Books")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath( "//img[@alt='Remove from my books']")).click();
		Alert alert =  driver.switchTo().alert();
		alert.accept();
		
		//Logout of Website
		driver.findElement(By.xpath( "//img[@alt='Nikhil']")).click();
		driver.findElement(By.linkText("Sign out")).click();
		driver.quit();

	}

}
