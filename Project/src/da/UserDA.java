package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import e.TableItem;
import e.User;

public class UserDA {
	private Connection con;
//	public List<User> getAllUser() {
//		return null;
//	}
	
	public UserDA() {
		// TODO Auto-generated constructor stub
		try {
			con = ConnectionUtil.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> getAll() throws SQLException{
		List<User> items = new ArrayList<User>();
		
		String sql = "SELECT * FROM User";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			User item = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			items.add(item);
		}
		
		return items;
	}
	
	
	

	public boolean checkUser(String username, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
		PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			return true;

		return false;
	}
}
