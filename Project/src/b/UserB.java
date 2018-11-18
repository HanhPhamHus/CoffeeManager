package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.UserDA;
import e.TableItem;
import e.User;

public class UserB {
	private UserDA da;
	
	public UserB() {
		// TODO Auto-generated constructor stub
		da = new UserDA();
	}

	public DefaultTableModel getAllItem() throws SQLException{
		List<User> items = da.getAll();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Password");
		model.addColumn("Email");
		model.addColumn("DiaChi");
		model.addColumn("FullName");
		
		
		
		for (User item : items) {
			String[] cells = new String[6];
			cells[0] = String.valueOf(item.getId());
			cells[1] = String.valueOf(item.getUserName());
			cells[2] = String.valueOf(item.getPassword());
			cells[3] = String.valueOf(item.getEmail());
			cells[4] = String.valueOf(item.getDiaChi());
			
			
			model.addRow(cells);
		}
		
		return model;
	}
	
	public User add(User item){
		return null;
	}
	public User delete(User item){
		return null;
	}
	public User update(User item){
		return null;
	}
	public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException{
		return da.checkUser(username, password);
	}
	
	//...
}
