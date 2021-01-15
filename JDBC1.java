import java.sql.*;
import java.util.Scanner;
public class JDBC1 {
public static void main(String args[])
{
	String ss="jdbc:mysql://localhost:3306/mydb";
	try(Connection con=DriverManager.getConnection(ss,"root","Sanju@(1975)"))
	{
		System.out.println("Implementation class is\t"+con.getClass());
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your roll no: ");
		String str1 = scanner.nextLine();

		Statement st=con.createStatement();
		
		int s=st.executeUpdate("INSERT INTO Student(rollno,name,age) values(3,'tiger',75)");
		if(s>0)
		{
			System.out.println("Records are successfully added");
		}
		ResultSet rs=st.executeQuery("select * from Student");
		
		while(rs.next())
		{
			int rollno=rs.getInt("rollno");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			
			System.out.println(rollno+"\t"+name+"\t"+age);
			
	}
	}
	catch(Exception ee)
	{
		System.out.println(ee);
	}
}
}