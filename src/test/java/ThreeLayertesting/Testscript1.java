package ThreeLayertesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.response.Response;

public class Testscript1 {
	
	@Test
	public void project() throws Throwable 
	{
		// add from selenium
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Random ran=new Random();
		int value=ran.nextInt(100);
		String Project="LifeInsuranceManagement"+value;

		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(Project);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anamika");
		WebElement st = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(st);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String proId=driver.findElement(By.xpath("//td[text()='"+Project+"']/preceding-sibling::td")).getText();
		System.out.println(proId);
		
		// get from restassured
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp= when().get("/projects/"+proId);
		String project=resp.jsonPath().getString("projectName");
		resp.then().assertThat().statusCode(200).log().all();
		Assert.assertEquals(project, Project);
		Reporter.log("project added successfully and verified",true);
		
		// check from database
		
	Connection con=null;
	try {
			
    Driver driver1=new Driver();
    DriverManager.registerDriver(driver1);
    con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	String query="select * from project where project_Name='"+Project+"';";
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actualProjectname=result.getString(4);
		System.out.println(actualProjectname);
		
		if(actualProjectname.equalsIgnoreCase(Project))
		{
			flag=true;
			break;
			
		}
	}
	if(flag)
	{
		System.out.println("project is created");
	}
	else
	{
		System.out.println("project is not created");
	}
	}
catch(Exception e)
{
	e.printStackTrace();
}

finally
{
	con.close();
	System.out.println("database is closed");
}
	driver.close();	
	}
}