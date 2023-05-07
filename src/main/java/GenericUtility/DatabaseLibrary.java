package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DatabaseLibrary {
	
	Driver driverRef;
	Connection con;
	int result=0;
	/**
	 * this method is used to connect with mysql db
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		driverRef =new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(Iconstants.dbURL, Iconstants.dbUserName, Iconstants.dbPassword);
	}
	
	
	/**
	 * this method will close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
		
	}
	
	
	/**
	 * this method will read the data from db and validate
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDBAndValidate(String query, int columnIndex,String expData) throws SQLException
	{
		boolean flag=false;
		ResultSet result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
	}
	
	public void executeAndInsertData(String query,int num) throws SQLException
	{
		
		Statement state=con.createStatement();
		 result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data inserted");
		}
		else {
			System.out.println("data not inserted");
		}
		String query1="select * from project;";
		ResultSet results=state.executeQuery(query1);
		while(results.next())
		{
			String actualId=results.getString(num);
		}
	}

}
