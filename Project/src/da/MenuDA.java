package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import e.MenuItem;

public class MenuDA {
	private Connection con;
	
	public MenuDA() {
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
	
	public List<MenuItem> getAll() throws SQLException{
		List<MenuItem> items = new ArrayList<MenuItem>();
		
		String sql = "SELECT * FROM Menu";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			MenuItem item = new MenuItem(rs.getString(1), rs.getString(2), rs.getInt(3));
			items.add(item);
		}
		
		return items;
	}
	
	public boolean deleteItem(int id) throws SQLException{
		String sql = "DELETE FROM Menu WHERE DoUongID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		
		int result = stmt.executeUpdate();
			
		return result>0;
	}
	
	//....
}
