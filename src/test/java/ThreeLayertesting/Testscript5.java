package ThreeLayertesting;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Testscript5 {

	@Test
	
	public void project() throws Throwable
	{
	// add from restassured
		
		Random ran=new Random();
		int value=ran.nextInt(100);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Anamikasingh");
		jObj.put("projectName", "LifeInsuranceManagement"+value);
		jObj.put("status", "added");
		jObj.put("teamSize", 4);
		
		Response resp= given().body(jObj).contentType(ContentType.JSON)
		.when().post("/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		
		String actualProj=resp.jsonPath().getString("projectName");
		
// actualProject ="LifeInsuranceManagement"
		
		// check from selenium
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
	String projects = driver.findElement(By.xpath("//td[text()='"+actualProj+"']")).getText();
	
	Assert.assertEquals(projects, actualProj);
	Reporter.log("project added successfully",true);
	
	// delete from database 
	
		Connection con=null;
		int result=0;
		try {
				
	    Driver driver1=new Driver();
	    DriverManager.registerDriver(driver1);
	    con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query="delete from project where project_Name='"+actualProj+"';";
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
