/**
 * Project: a00973641_lab07
 * File: DbDao.java
 * Date: Jun 11, 2016
 * Time: 2:59:15 PM
 */
package a00973641.database.dao;

import java.io.IOException;
import java.io.InputStream;
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

import a00973641.data.MetaDataBean;
import a00973641.database.DbConnectionManager;
import a00973641.database.DbConstants;

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
			// Initialize database connection properties
			InputStream input = ctx.getResourceAsStream(DbConstants.DB_PROPERTIES_FILENAME);
			db.init(input);

			// Attempting to retrieve data
			System.out.println("Attempting to connect...");
			dbConn = db.getConnection();

			// Prepare statement
			System.out.println("Preparing statement...");
			ps = dbConn.prepareStatement(sql);

			// Execute query
			System.out.println("Executing query...");
			ResultSet rs = ps.executeQuery();
			request.setAttribute("resultset", rs);

			// Get resultset meta data
			List<MetaDataBean> rsmdMetaData = getRsmdMetaData(rs);
			request.setAttribute("rsmdMetaData", rsmdMetaData);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static List<MetaDataBean> getRsmdMetaData(ResultSet rs) {
		List<MetaDataBean> tableMetaData = new ArrayList<>();
		MetaDataBean mdBean;

		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				mdBean = new MetaDataBean();

				mdBean.setColumnName(rsmd.getColumnLabel(i));
				mdBean.setDataType(rsmd.getColumnTypeName(i));
				mdBean.setColumnWidth(rsmd.getPrecision(i));
				mdBean.setSearchable(rsmd.isSearchable(i));
				mdBean.setWriteable(rsmd.isWritable(i));
				mdBean.setNullable(rsmd.isNullable(i));

				tableMetaData.add(mdBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tableMetaData;
	}
}
