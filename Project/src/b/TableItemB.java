package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.TableItemDA;
import e.TableItem;

public class TableItemB {
	private TableItemDA da;
	
	public TableItemB() {
		// TODO Auto-generated constructor stub
		da = new TableItemDA();
	}
	
	public DefaultTableModel getAllItem() throws SQLException{
		List<TableItem> items = da.getAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("BanID");
		model.addColumn("TenBan");
		model.addColumn("GhiChu");
		
		for (TableItem item : items) {
			String[] cells = new String[3];
			cells[0] = String.valueOf(item.getBanID());
			cells[1] = String.valueOf(item.getTenBan());
			cells[2] = String.valueOf(item.getGhiChu());
			model.addRow(cells);
		}
		
		return model;
	}
	
	public TableItem add(TableItem item){
		return null;
	}
	public TableItem delete(TableItem item){
		return null;
	}
	public TableItem update(TableItem item){
		return null;
	}
	
}
