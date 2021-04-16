package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.NewFeedBean;

public class SQLconFeeds {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;

	public static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feeds?serverTimezone=UTC",
					DatabaseLogin.getuName(), DatabaseLogin.getuPass());
			return true;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	public static boolean addFeedToSQL(NewFeedBean bean) {

		// test a query
		try {
			
					
			String addPostToDB = "INSERT INTO feeds(feedContent,  feedTag) VALUES ( ?  , ? )";

			ps = conn.prepareStatement(addPostToDB);
			ps.setString(1, bean.getFeedContent());
			ps.setString(2, bean.getFeedTag());
			ps.execute();

			
			conn.close();
			return true;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return false;

	}

	public static ArrayList<String> getFeedsFromSQL(ArrayList<String> list) {

		ArrayList<String> returnList = list;
		// test a query
		try {

			String totalRowsInDB = "SELECT feedContent, feedTag FROM feeds";

			stmt = conn.createStatement();

			stmt.executeQuery(totalRowsInDB);
			rs = stmt.getResultSet();

			while (rs.next()) {
				String feedContent = rs.getString("feedContent");
				String feedTag = rs.getString("feedTag");
				returnList.add(feedContent + ";!;" + feedTag);
			}

			conn.endRequest();
			conn.close();
			return returnList;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return null;
	}

	public static ArrayList<String> getSearchForFeedsFromSQL(ArrayList<String> list, String question) {

		ArrayList<String> returnList = list;

		// test a query
		try {
			String totalRowsInDB = "SELECT feedContent, feedTag FROM feeds WHERE feedContent LIKE ? OR feedTag like? ";

			ps = conn.prepareStatement(totalRowsInDB);
			ps.setString(1, "%" + question + "%");
			ps.setString(2, "%" + question + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String feedContent = rs.getString("feedContent");
				String feedTag = rs.getString("feedTag");
				returnList.add(feedContent + ";!;" + feedTag);
			}

			conn.endRequest();
			conn.close();
			return returnList;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return null;
	}
}
