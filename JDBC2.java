import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBC2 {
public static void main(String args[])
{
	String ss="jdbc:mysql://localhost:3306/mydb";
	try(Connection con=DriverManager.getConnection(ss,"root","Sanju@(1975)"))
	{
		System.out.println("Implementation class is\t"+con.getClass());
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp where desig='HR'");
		
		while(rs.next())
		{
			int empid=rs.getInt("empid");
			String empname=rs.getString("empname");
			String desig=rs.getString("desig");
			System.out.println(empid+"\t"+empname+"\t"+desig);
			
	}
	}
	catch(Exception ee)
	{
		System.out.println(ee);
	}
}
}