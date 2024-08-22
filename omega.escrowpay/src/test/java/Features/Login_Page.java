package Features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Login_Page {
	WebDriver driver;
	String admin_username = "alpha.admin@escrowpayuat.com";
	String admin_password = "aadmin12#";
	String user_username = "rakshit.sinha@itrustmore.com";
	String user_password = "Rakshit@2024";
	
	@Test
	public void LaunchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void VisitSite()
	{
		driver.get("https://omega.escrowpayindia.com/");
	}
	
	@Parameters({"username","password"})
	@Test
	public void Login(String username, String password)
	{
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
		String expected_title = "Omega Web | Dashboard";
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, expected_title);
//		driver.close();
	}
	@Test
	public void ProfileDropdown()
	{
		driver.findElement(By.xpath("//div[@class='organization']")).click();
	}
	
	@Test
	public void Profile()
	{
		driver.findElement(By.linkText("Profile")).click();
	}
	
	@Test
	public void KYC()
	{
		driver.findElement(By.xpath("//*[@id=\"kyc-tab\"]/span")).click();
	}
	
	@Test
	public void BankInfo()
	{
		driver.findElement(By.xpath("//*[@id=\"bank-tab\"]/span")).click();
	}
	
	@Test
	public void GSTIN()
	{
		driver.findElement(By.xpath("//*[@id=\"gst-tab\"]/span")).click();
	}
	
	@Test
	public void Address() 
	{
		driver.findElement(By.xpath("//*[@id=\"address-tab\"]/span")).click();
	}
	
	@Test
	public void Clients()
	{	
		driver.findElement(By.xpath("//*[@id=\"headingTwo\"]/a")).click();
	}
	
	@Test
	public void UserManagement()
	{
		driver.findElement(By.xpath("//*[@id=\"headinginnerone\"]/a")).click();
	}
	
	@Test
	public void EscrowAccount()
	{
		driver.findElement(By.xpath("//a[text()='Escrow Account']")).click();
	}	
	
	@Test
	public void WithdrawRequest()
	{
		driver.findElement(By.xpath("//a[text()='Withdrawal Requests']")).click();
	}
	
	@Test
	public void AccountStatement()
	{
		driver.findElement(By.xpath("//a[text()='Statement of Account']")).click();
	}
	
	@Test
	public void Reports()
	{
		driver.findElement(By.xpath("//*[@id=\"headingNine\"]/a")).click();
	}
	
	@Test
	public void TransactionReports()
	{
		driver.findElement(By.xpath("//*[@id=\"headinginnerone\"]/a")).click();
	}
	
	@Test
	public void Deals()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Deals')]")).click();
	}
	
	@Test
	public void DealsList()
	{
		driver.findElement(By.xpath("//a[ends-with(text(),'List'])")).click();		
	}
	
	@Test
	public void Logout()
	{
		driver.findElement(By.xpath("//a[text()='Logout']"));
		String expected_title = "Login | Escrowpay";
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test
	public void CloseBrowser()
	{
		driver.close();
	}

}
