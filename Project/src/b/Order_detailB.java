package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.Order_detailDA;
import e.Order_detailItem;


public class Order_detailB {
	private Order_detailDA da;
	
	public Order_detailB() {
		// TODO Auto-generated constructor stub
		da = new Order_detailDA();
	}
	
	public DefaultTableModel getAllItem() throws SQLException{
		List<Order_detailItem> items = da.getAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("GoiID");
		model.addColumn("BanID");
		model.addColumn("DoUongID");
		model.addColumn("SoLuong");
		
		for (Order_detailItem item : items) {
			String[] cells = new String[4];
			cells[0] = String.valueOf(item.getGoiID());
			cells[1] = String.valueOf(item.getBanID());
			cells[2] = String.valueOf(item.getDoUongID());
			cells[3] = String.valueOf(item.getSoLuong());
			
			model.addRow(cells);
		}
		
		return model;
	}
	
	public Order_detailItem add(Order_detailItem item){
		return null;
	}
	public Order_detailItem delete(Order_detailItem item){
		return null;
	}
	public Order_detailItem update(Order_detailItem item){
		return null;
	}
}
