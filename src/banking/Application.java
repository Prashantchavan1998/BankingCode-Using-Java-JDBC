package banking;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Application
{
	int accountnum;
	String name;
	double deposit,  withdrow, total;
	
	public static Connection connection() //connection method using Connection return type
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");  // load  the driver class
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","root"); // Connection url
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
		
	} // Connection close
	void createAc() //Create_account method
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account number: ");
		accountnum=sc.nextInt();
		Scanner sb=new Scanner(System.in);
		System.out.println("Enter the Account holder Name: ");
		name=sb.nextLine();
	
		System.out.println("Enter the deposit Ammount: ");
		deposit=sc.nextDouble();
		total=deposit;
		withdrow=00;
		try
		{
			Connection con=connection();
			Statement stmt=con.createStatement();
			stmt.execute("insert into account values("+accountnum+",'"+name+"',"+deposit+","+withdrow+","+total+")");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	} //create acc close
	int deposit() // deposit method
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		accountnum=sc.nextInt();
		System.out.println("Enter the amount: ");
		deposit=sc.nextDouble();
		total=deposit+total;
		
		try
		{
			Connection con=connection();
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update account set Deposit="+deposit+", Total_bal= Total_bal+"+deposit+" where Account_Number="+accountnum+"");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return 0;
	} // deposit close
	
	int withdrow() //withdrow method
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the account Number: ");
		accountnum=sc.nextInt();
		System.out.println("Enter the withdrow Ammount: ");
		withdrow=sc.nextDouble();
		
		try
		{
			Connection con=connection();
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update account set Withdrow="+withdrow+", Total_bal= Total_bal-"+withdrow+" where Account_Number="+accountnum+"");
		}
		catch(Exception e)
		{
			
		}
		
		return 0;
	} //withdrow close
	void balance() //Balance check method
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account Number: ");
		accountnum=sc.nextInt();
		try
		{
			Connection con=connection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select Account_Number, Name, Total_Bal from account where Account_Number="+accountnum+"");
			
			while(rs.next())
			{
				System.out.println("Account Number :"+rs.getInt("Account_Number")+"\nAccount Holder Name:"+rs.getString("Name")+"\nAvailable balance is: "+rs.getDouble("Total_Bal"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} //balance check close
	public static void main(String args[])
	{
		Application app=new Application();
		Scanner sc=new Scanner(System.in);
		System.out.println("********** Welcome to Bank **********");
		System.out.println("Enter Your Choice....!");
		System.out.println(" Press. 1. Create Account\n Press. 2. Deposit\n Press. 3. Withdrow\n Press. 4. Balance Check");
		int ch=sc.nextInt();
		while(true)
		{
			
		
		switch(ch)
		{
		case 1:
			app.createAc();
			break;
		case 2:
			app.deposit();
			break;
		case 3:
			app.withdrow();
			break;
		case 4:
			app.balance();
			break;
		
		}
		Scanner su=new Scanner(System.in);
		System.out.println("Do you want to continue [Yes/No]");
		String option=su.nextLine();
		
		if(option.equalsIgnoreCase("NO"))
		{
			System.out.println("Thank you using my Application..!");
			break;
		}
		}
	}
} //class end
