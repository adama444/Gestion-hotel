package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DaoUser {
	private static String SELECT_USER = "SELECT * FROM user WHERE Username=? AND `Password`=?;";
	private static String SELECT_USER_ID = "SELECT * FROM user WHERE Username=?;";
	private static String SELECT_ALL = "SELECT * FROM user;";
	private static String COUNT = "SELECT COUNT(Id) FROM user;";
	private static String ADD_USER = "INSERT INTO user(Username, Password) VALUES (?,?);";
	private static String DELETE_USER = "DELETE FROM user WHERE Id=?;";
	private static String UPDATE_USER = "UPDATE user SET `Password`=? WHERE Id=?";
	
	public static boolean updateUser(User user) {
		boolean isUpdated = false;
		user.setId(findUserID(user));
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(UPDATE_USER);
			statement.setString(1, user.getPassword());
			statement.setInt(2, user.getId());
			int result = statement.executeUpdate();
			if (result == 1) {
				isUpdated = true;
			} else {
				isUpdated = false;
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	public static int findUserID(User user) {
		int id = 0;
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(SELECT_USER_ID);
			statement.setString(1, user.getUsername());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				id = result.getInt(1);
			}
			result.close();
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static boolean addUser(User user) {
		boolean isAdded = false;
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(ADD_USER);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			int result = statement.executeUpdate();
			if (result == 1) {
				isAdded = true;
			} else {
				isAdded = false;
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdded;
	}
	
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
	
	public static List<User> getAllUser() {
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
	}
	
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

	public static boolean deleteUser(User user) {
		boolean isDropped = false;
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(DELETE_USER);
			statement.setInt(1, user.getId());
			int result = statement.executeUpdate();
			if (result == 1) {
				isDropped = true;
			} else {
				isDropped = false;
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDropped;
	}
}
