/**
 * Project: a00973641_lab07
 * File: DBConnectionManager.java
 * Date: Jun 11, 2016
 * Time: 2:14:30 PM
 */
package a00973641.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mara
 * 
 *         Single instance of DBConnectionManager.
 *
 */
public class DBConnectionManager {

	private static DBConnectionManager dbInstance = new DBConnectionManager();
	private static Connection connection;
	private static Properties properties;

	public void init(InputStream input) throws IOException, SQLException {
		try {
			properties = new Properties();
			properties.load(input);
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public static DBConnectionManager getInstance() {
		return dbInstance;
	}

	public Connection getConnection() throws SQLException {
		if (connection != null) {
			return connection;
		}

		try {
			connect();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(properties.getProperty(DbConstants.DB_DRIVER_KEY));
		connection = DriverManager.getConnection(properties.getProperty(DbConstants.DB_URL_KEY), properties);
	}

	/**
	 * Close database connection.
	 */
	public void shutdown() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
