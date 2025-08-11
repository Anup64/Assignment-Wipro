package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DepartmentException;

public class DbUtil {
public static Connection getConnection() throws DepartmentException {
	String url="jdbc:mysql://localhost:3306/wipro";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Anup123#");
		return con;
	} catch (ClassNotFoundException e) {
		throw new DepartmentException(e.getMessage());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DepartmentException(e.getMessage());
	}
	
}


}
