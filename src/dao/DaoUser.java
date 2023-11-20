package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class DaoUser {
	private static String SELECT_USER = "SELECT * FROM user WHERE Username=? AND Password=?;";
	//private static String SELECT_ALL = "SELECT * FROM user;";
	private static String COUNT = "SELECT COUNT(Id) FROM user;";
	
	public static boolean findUser(User user) {
		boolean isfound = false;
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(SELECT_USER);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				isfound = true;
			} else {
				isfound = false;
			}
			result.close();
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isfound;
	}
	
	/*public static List<User> getAllUser() {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement statement;
		try {
			statement = Connection.getConnection().prepareStatement(SELECT_ALL);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				list.add(new User(
						result.getInt(1),
						result.getString(2),
						result.getString(3)
						));
			}
			result.close();
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}*/
	
	public static int getUserCount() {
		int count = 0;
		PreparedStatement statement;
		try {
			statement = Connection.getConnection().prepareStatement(COUNT);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);
			}
			result.close();
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
