/**
 * Project: a00973641_lab07
 * File: DbDao.java
 * Date: Jun 11, 2016
 * Time: 2:59:15 PM
 */
package a00973641.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a00973641.database.DbConnectionManager;

/**
 * @author Mara
 *
 */
public class DbDao {

	public static void getData(HttpServletRequest request, HttpServletResponse response, ServletContext ctx,
			String sql) {
		RequestDispatcher rd = null;

		DbConnectionManager db = DbConnectionManager.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		try {
			request.setAttribute("sqlString", sql);

			// Attempting to retrieve data
			dbConn = db.getConnection();

			// Prepare statement
			ps = dbConn.prepareStatement(sql);

			// Execute query
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getMetaData(ResultSet rs) {
		List<String> columnNames = new ArrayList<>();

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				columnNames.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
