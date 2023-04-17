package banking;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Openaccount
{
	public static Connection  connection()
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/bank";

		String user="root";

		String pass="root";
		con=DriverManager.getConnection(url,user,pass);
		
		}

		catch (Exception e)
		{

		e.printStackTrace();

		}

		return con;
	}
	void createaccount(int Account_Number,String Name) 
	{
		try
		{
		Connection con=connection();
		
		Statement stmt=con.createStatement();
		stmt.execute("insert into account values("+Account_Number+",'"+Name+")");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	int Update(int Account_Number, int Deposit)
	{
		try
		{
		Connection con=connection();
		Statement stmt=con.createStatement();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
	}

		public static void main(String[] args)
		{

		Openaccount ab=new Openaccount();
		ab.createaccount(106,"Shiv Rahane");
		}

}
