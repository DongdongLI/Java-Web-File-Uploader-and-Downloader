package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/*
 * 
 * JDBC processor utility
 * 
 * two functionalities
 * 
 * get connection
 * 
 * clase connection*/
public class JdbcUtils {
	
	private static DataSource dataSource=null;
	
	static{
		dataSource=new ComboPooledDataSource("fileUploadApp");
	}
	
	public static void releaseConnection(Connection connection){
		try {
			if(connection!=null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
