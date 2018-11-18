package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import e.TableItem;

public class TableItemDA {
	private Connection con;
	
	public TableItemDA() {
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
	
	public List<TableItem> getAll() throws SQLException{
		List<TableItem> items = new ArrayList<TableItem>();
		
		String sql = "SELECT * FROM TableItem";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			TableItem item = new TableItem(rs.getString(1), rs.getString(2), rs.getString(3));
			items.add(item);
		}
		
		return items;
	}
	
	public boolean deleteItem(int id) throws SQLException{
		String sql = "DELETE FROM tableitem WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		
		int result = stmt.executeUpdate();
			
		return result>0;
	}
	
	//....
}
