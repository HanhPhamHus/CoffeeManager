package p;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Panel;
import java.awt.TextArea;

public class mUseTable extends JFrame  implements ActionListener{

	int n=0;
	Panel panelSouth = new Panel();
	Label lbChinh = new Label("Use Table",Label.CENTER);
	TextArea txaChinh = new TextArea();
	Button buttXem = new Button("   See ");
	Button buttThoat = new Button("  Exit  ");
	Choice chMaBan = new Choice();
	Choice chTenBan = new Choice();
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mUseTable frame = new mUseTable();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	
	public mUseTable() {
		setTitle("UseTable");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		lbChinh.setBackground(new Color(255, 255, 240));
		lbChinh.setForeground(new Color(139, 69, 19));
	
		lbChinh.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 21));
		getContentPane().add(lbChinh,BorderLayout.NORTH);
		txaChinh.setBackground(new Color(255, 255, 240));
		txaChinh.setForeground(new Color(139, 69, 19));
		txaChinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txaChinh.setEditable(false);
		txaChinh.setText("\tNameTable\t\tUseStatus\n\n");
		getContentPane().add(txaChinh,BorderLayout.CENTER);
		buttXem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttXem.setBackground(new Color(139, 69, 19));
		buttXem.setForeground(new Color(255, 255, 255));
		panelSouth.setBackground(new Color(255, 255, 240));
		panelSouth.add(buttXem);
		buttThoat.setForeground(new Color(255, 255, 255));
		buttThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttThoat.setBackground(new Color(139, 69, 19));
		panelSouth.add(buttThoat);
		getContentPane().add(panelSouth,BorderLayout.SOUTH);
		buttXem.addActionListener(this);
		buttThoat.addActionListener(this);
		setFont(new Font("Arial",Font.PLAIN,14));
		setLocation(200,50);
		setSize(400, 400);
		setResizable(false);
		setVisible(true);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM TableItem");
			rs.next();
			while(!rs.isAfterLast())
			{
				chMaBan.addItem(rs.getString(1));
				chTenBan.addItem(rs.getString(2));
				n++;
				rs.next();
			}
		}
		catch(Exception e){}
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==buttXem)
			Xem();
		if(e.getSource() == buttThoat)
		{
			setVisible(false);
		}
	}
	public void Xem()
	{
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT BanID FROM Order_detail");
			for(int i = 0; i<n;i++)
			{
				String s = chMaBan.getItem(i);
				rs.first();
				boolean flag = false;
				while(!rs.isAfterLast())
				{
					if(rs.getString(1).equals(s))
					{
						flag = true;
						break;
					}
					rs.next();
				}
				if(flag == true)
					txaChinh.append("\t"+chTenBan.getItem(i)+"\t\t\tDa su dung");
				else
					txaChinh.append("\t"+chTenBan.getItem(i)+"\t\t\tChua su dung");
				txaChinh.append("\n");
			}
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.toString());
		}
	}
	public void connect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.print("Error: " + ex.getMessage());
		}
		try
		{
			String url = "jdbc:mysql://localhost/coffeehouse";
			String user = "root";
			String pass = "";
			con = DriverManager.getConnection(url,user,pass);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(SQLException se)
		{
			System.err.println("Error: "+se.getMessage());
		}
	}
}
