package practise.datadruiventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ToReadDataFromDatabaseBasedOnCondition {

	@Test
	public  void basedOnCondition() throws SQLException {
		
		 String expectedfirstname = "nivetha";
		 boolean flag=false;
		 
		 //load and register the database
		 Driver driverref=new Driver();
		 DriverManager.registerDriver(driverref);
		 
		 //connect to database
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "Nive@may24");
		 
		 //create a statement
		 Statement stat = conn.createStatement();
		 
		 //execute the statement and get the result
		 ResultSet res = stat.executeQuery("select * from project");
		 while(res.next())
		 {
			 String actualfirstname = res.getString(1);
			 if(expectedfirstname.equals(actualfirstname))
		      {
				 flag=true;
				 System.out.println(res.getString(1)+" is available====>pass");
			 }
		 }
		 if(flag==false)
		 {
			 System.out.println(res.getString(1)+" is available====>fail");
			 Assert.fail();
		 }
		 conn.close();

	}

}
