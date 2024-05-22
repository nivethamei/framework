package practise.datadruiventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class ToReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		//load and register the database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","Nive@may24");
	    System.out.println("done");
	    
	    //to create statement
	    Statement stat = conn.createStatement();
	    
	    //insert the query
	    
	     //int upd = stat.executeUpdate("insert into project values('abishek','ravi',20,'male');");
	     //System.out.println(upd);
	    //execute the query and get the result
	    ResultSet res = stat.executeQuery("select * from project");
	    while(res.next())
	    {
	      System.out.println(res.getString(1)+ " "+ res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
	    }
	    conn.close();
	    
	    
	    
	    

	}

}
