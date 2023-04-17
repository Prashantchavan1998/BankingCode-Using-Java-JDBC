package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionBank
{
	void Deposit()
	{
		try
		{
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");  
			  Statement stmt=connection.createStatement();
		 stmt.execute("update account set Balance=10000 where Account_Number=101");
		 System.out.println("Data inserted Successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	int with(int withdrow)
	{
		try
		{
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");  
			  Statement stmt=connection.createStatement();
			  stmt.executeUpdate("update account set Balance='%d' where Account_Number=101",withdrow);
		 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
		
	}
	void Balance()
	{
		Connection connection=null;
		Statement stmt=null;
		try
		{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root"); 
			stmt=connection.createStatement();
		  ResultSet Rs=stmt.executeQuery("select * from account where Account_Number=101");
		  while(Rs.next())
		  {
			  System.out.println(Rs.getInt(1)+" "+Rs.getString(2)+" "+Rs.getInt(3));
		  }
		  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				stmt.close();
				connection.close();

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
	}

	public static void main(String[] args) 
	{
		 try 
		 { 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  System.out.println("Driver is Loaded");
		  } 
		 catch(Exception e)
		  {
		  System.out.println(e);
		  }
		 ConnectionBank ab=new ConnectionBank();
		 ab.Deposit();
		 ab.Balance();
		 ab.with(5000);
	}
}
