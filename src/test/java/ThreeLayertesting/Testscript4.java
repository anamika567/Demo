package ThreeLayertesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;

public class Testscript4 {
	
	@Test
	public void project() throws Throwable  {
		
		// add from database
		
		Random ran=new Random();
		int value=ran.nextInt(100);
		
		String actualProject="Life_Insurance_Management"+value;
		String pid="TY_Project_"+value;

		Connection con=null;
		int result=0;
	try {
         Driver driver =new Driver();
		
			DriverManager.registerDriver(driver);
		
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
			Statement state = con.createStatement();
			String query="insert into project values('"+pid+"','AnamikaSingh','21/03/2023','"+actualProject+"','created',3)";
			
			result=state.executeUpdate(query);
	}
	catch(Exception e)
	{
				
	}
	finally
	{
		if(result==1)
		{
			System.out.println("Data inserted successfully");
		}
		else
		{
			System.out.println("Data not inserted");
		}
		
		con.close();		

}
	
// check from selenium
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://rmgtestingserver:8084");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click();
String projects = driver.findElement(By.xpath("//td[text()='"+actualProject+"']")).getText();
String proId=driver.findElement(By.xpath("//td[text()='"+actualProject+"']/preceding-sibling::td")).getText();

Assert.assertEquals(projects, actualProject);
Reporter.log("project added successfully",true);
	

	// get from restassured

	baseURI="http://rmgtestingserver";
	port=8084;
	
	Response resp= when().get("/projects/"+proId);
	String project=resp.jsonPath().getString("projectName");
	resp.then().assertThat().statusCode(200).log().all();
	Assert.assertEquals(project, actualProject);
	Reporter.log("project added successfully and verified",true);

	driver.close();
	
	}	
}
