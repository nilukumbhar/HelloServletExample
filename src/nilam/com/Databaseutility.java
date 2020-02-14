package nilam.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Databaseutility {
	final String DB_URL="jdbc:mysql://localhost:3306/moviemanagementdb?useTimezone=true&serverTimezone=UTC";
	final String DB_USERNAME="root";
	final String DB_PASSWORD="";
	

	public Databaseutility() {
		// TODO Auto-generated constructor stub
	}
	public Connection getDBConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		return con;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
