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
		System.out.println("Enter the LastName");
		Scanner in = new Scanner(System.in);
		String input=in.next();
		String sql = "select * from customers where lastname ='"+input+"'";
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