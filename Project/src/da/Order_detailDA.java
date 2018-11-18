package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import e.Order_detailItem;

public class Order_detailDA {
	private Connection con;
	
	public Order_detailDA() {
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
	
	public List<Order_detailItem> getAll() throws SQLException{
		List<Order_detailItem> items = new ArrayList<Order_detailItem>();
		
		String sql = "SELECT * FROM Order_detail";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			Order_detailItem item = new Order_detailItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			items.add(item);
		}
		
		return items;
	}
	
	public boolean deleteItem(int id) throws SQLException{
		String sql = "DELETE FROM Order_detail WHERE GoiID=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		
		int result = stmt.executeUpdate();
			
		return result>0;
	}
	
	//....
}
