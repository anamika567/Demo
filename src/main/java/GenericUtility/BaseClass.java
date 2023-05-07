package GenericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import PomClass.HomePage;
import PomClass.LoginPage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseClass  {
	
	public WebDriver driver;

	public DatabaseLibrary dLib=new DatabaseLibrary();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public WebdriverUtility wLib=new WebdriverUtility();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		
		dLib.connectToDB();
		System.out.println("connect to db");
		
		//baseURI="http://rmgtestingserver";
		//port=8084;
		reqst =new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		resp=new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(201).build();
		
	}
	
	@BeforeClass
	public void configBC()
	{
		 driver=new ChromeDriver();

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get("http://rmgtestingserver:8084/");

	}
	
	@BeforeMethod
	public void configBM() {
		
		//String Username=Iconstants.appUserName;
		//String Password=Iconstants.appPassword;
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(Iconstants.appUserName,Iconstants.appPassword);
		System.out.println("login to app");
	}
	
	@AfterMethod
	public void configAM() {
		
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("logout from app");
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		
		dLib.closeDB();
		System.out.println("close db");
	}
	
	

}
