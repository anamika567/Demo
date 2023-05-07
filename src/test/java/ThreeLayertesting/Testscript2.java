package ThreeLayertesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Testscript2 {
	
	@Test
	public void project() throws Throwable {
		
		//add from selenium
		
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	Random ran=new Random();
	int value=ran.nextInt(200);
	String actualProject="LifeInsuranceManagement"+value;

	driver.get("http://rmgtestingserver:8084");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(actualProject);
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anamika");
	WebElement st = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s=new Select(st);
	s.selectByIndex(1);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String proId=driver.findElement(By.xpath("//td[text()='"+actualProject+"']/preceding-sibling::td")).getText();
	System.out.println(proId);
	
	
	// check using restassured
	
	baseURI="http://rmgtestingserver";
	port=8084;
	
	Response resp= when().get("/projects/"+proId);
	String project=resp.jsonPath().getString("projectName");
	resp.then().assertThat().statusCode(200).log().all();
	Assert.assertEquals(project, actualProject);
	Reporter.log("project added successfully and verified",true);

	// delete from database 
	
	Connection con=null;
	int result=0;
	try {
			
    Driver driver1=new Driver();
    DriverManager.registerDriver(driver1);
    con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	String query="delete from project where project_Name='"+actualProject+"';";
	result = state.executeUpdate(query);
	}
catch(Exception e)
{
	e.printStackTrace();
}

finally
{
	if(result==1)
	{
		System.out.println("project deleted successfully");
	}
	else
	{
		System.out.println("not deleted");
	}
}
	con.close();
	System.out.println("database is closed");


	driver.close();
}
}