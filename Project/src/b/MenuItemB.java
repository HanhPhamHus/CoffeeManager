package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.MenuDA;
import e.MenuItem;


public class MenuItemB {
	private MenuDA da;
	
	public MenuItemB() {
		// TODO Auto-generated constructor stub
		da = new MenuDA();
	}
	
	public DefaultTableModel getAllItem() throws SQLException{
		List<MenuItem> items = da.getAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("DoUongID");
		model.addColumn("TenDoUong");
		model.addColumn("DonGia");
		
		for (MenuItem item : items) {
			String[] cells = new String[3];
			cells[0] = String.valueOf(item.getDoUongID());
			cells[1] = String.valueOf(item.getTenDoUong());
			cells[2] = String.valueOf(item.getDonGia());
			model.addRow(cells);
		}
		
		return model;
	}
	
	public MenuItem add(MenuItem item){
		return null;
	}
	public MenuItem delete(MenuItem item){
		return null;
	}
	public MenuItem update(MenuItem item){
		return null;
	}
}
