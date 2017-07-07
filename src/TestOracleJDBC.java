import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TestOracleJDBC {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner in = new Scanner(System.in);
		String choice="";
		Customer cs= new Customer();
		while(true)
		{
			System.out.println("Press (1) to search with customer's lastname or press (2) to Edit the customer's address.");
			choice = in.nextLine();
			if(choice.equals("q"))
			{
				break;
			}
			else if(choice.equals("1"))
			{
				System.out.println("Enter the LastName");
				String input=in.nextLine();
				String sql = cs.getInfo(input);
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
		                        //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
		                        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()==false)
					{
						break;
						
					}
					while(rs.next()){
						System.out.println(rs.getString(1) + "\t");
						System.out.println(rs.getString(5));
						System.out.println(rs.getString(6) + " " +rs.getString(7)+ " " +rs.getString(8));
						System.out.println(rs.getString(9));
					}
				
					}catch (SQLException e) {
						e.printStackTrace();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
				} finally {
					try {
						rs.close();
						stmt.close();
						con.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
			else if(choice.equals("2"))
			{
				System.out.println("Enter the LastName");
				String input=in.next();
				System.out.println("Enter the Street Address");
				String changed_address = in.next();
				String sql = cs.update_address(input,changed_address);
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
		                        //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
		                        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()){
						System.out.println(rs.getString(1) + "\t");
						System.out.println(rs.getString(5));
						System.out.println(rs.getString(6) + " " +rs.getString(7)+ " " +rs.getString(8));
						System.out.println(rs.getString(9));
					}
					}catch (SQLException e) {
						e.printStackTrace();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
				} finally {
					try {
						rs.close();
						stmt.close();
						con.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		}
		
		System.out.println("Please enter Fullname,street address,city,state,zip of customer to add a new entry :");
		in.nextLine();
		String fullname=in.nextLine();
		String saddress=in.nextLine();
		String city=in.nextLine();
		String state=in.nextLine();
		String zip=in.nextLine();
		
		Customer cus = new Customer(fullname,saddress,city,state,zip);
		String sql=cus.insert_entry(cus);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
                        //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
                        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("Insertion Done");
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		}
	}
}