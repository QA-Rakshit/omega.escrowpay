package Features;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		AssertJUnit.assertEquals(actual_title, expected_title);
//		driver.close();
	}
	@Test
	public void ProfileDropdown() throws InterruptedException
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
		driver.findElement(By.linkText("User Management")).click();
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
		driver.findElement(By.linkText("Transaction Reports")).click();
	}
	
	@Test
	public void Deals()
	{
		driver.findElement(By.xpath("//a[normalize-space(text())='Deals']")).click();
	}
	
	@Test
	public void DealsList()
	{
		driver.findElement(By.xpath("//a[normalize-space(text())='Deals List']")).click();		
	}
	
	@Test
	public void CreateUser()
	{
		driver.findElement(By.linkText("Create New User")).click();
	}
	
	@Test
	public void FillForm()
	{
		driver.findElement(By.name("name")).sendKeys("Rakshit_Automated6");
		driver.findElement(By.name("pan")).sendKeys("DDDTY1234X");
		driver.findElement(By.name("mobile")).sendKeys("3234467890");
		driver.findElement(By.name("email")).sendKeys("automated6@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expected_url= "https://omega.escrowpayindia.com/admin/users/list";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	
	@Test
	public void CreateDeal()
	{
		driver.findElement(By.linkText("Create Deal")).click();
		driver.findElement(By.xpath("//input[@name='deal_name']")).sendKeys("Test_Deal4");
		Select dropdown_seller = new Select(driver.findElement(By.id("seller")));
		dropdown_seller.selectByVisibleText("Rakshit");
		Select dropdown_buyer = new Select(driver.findElement(By.id("buyer")));
		dropdown_buyer.selectByVisibleText("Test_Rakshit");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("1001");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expected_url = "https://omega.escrowpayindia.com/admin/deal/list";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	
	@Test
	public void Logout()
	{
		driver.findElement(By.cssSelector("a[onclick*='logoutform']")).click();
		String expected_title = "Login | Escrowpay";
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title,expected_title);
	}
	
	@Test
	public void CloseBrowser()
	{
		driver.close();
	}

}
