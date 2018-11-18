package p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class mMenuManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMenuManager;
	private JTextField txtIdDrinks;
	private JTextField txtNameDrinks;
	private JTextField txtPrice;
	private JButton btnUpdate;
	private JButton btnReset;
	private JButton btnNext;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnRepair;
	//private Component btnExit;
	private Connection con;
	private ResultSet rs;
	private Statement stmt;
	

	public mMenuManager() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 449);
		setTitle("MenuManager");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdTable = new JLabel("ID Drinks  :");
		lblIdTable.setForeground(new Color(139, 69, 19));
		lblIdTable.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblIdTable.setBounds(96, 146, 106, 37);
		contentPane.add(lblIdTable);

		JLabel lblNewLabel = new JLabel("Name Drinks :");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(96, 214, 106, 21);
		contentPane.add(lblNewLabel);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPrice.setForeground(new Color(139, 69, 19));
		lblPrice.setBounds(96, 268, 106, 29);
		contentPane.add(lblPrice);

		lblMenuManager = new JLabel("Menu Manager");
		lblMenuManager.setBackground(new Color(255, 255, 240));
		lblMenuManager.setForeground(new Color(139, 0, 0));
		lblMenuManager.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblMenuManager.setBounds(204, 87, 166, 37);
		contentPane.add(lblMenuManager);

		txtIdDrinks = new JTextField();
		txtIdDrinks.setBounds(309, 155, 167, 22);
		contentPane.add(txtIdDrinks);
		txtIdDrinks.setColumns(10);

		txtNameDrinks = new JTextField();
		txtNameDrinks.setBounds(309, 215, 167, 22);
		contentPane.add(txtNameDrinks);
		txtNameDrinks.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(309, 273, 167, 22);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(139, 69, 19));
		btnUpdate.setBackground(new Color(255, 255, 240));
		btnUpdate.setBounds(12, 364, 88, 25);
		contentPane.add(btnUpdate);

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 240));
		btnReset.setForeground(new Color(139, 69, 19));
		btnReset.setBounds(112, 364, 73, 25);
		contentPane.add(btnReset);
		
	
		btnPre = new JButton("Pre");
		btnPre.setBackground(new Color(255, 255, 240));
		btnPre.setForeground(new Color(139, 69, 19));
		btnPre.setBounds(204, 364, 73, 25);
		contentPane.add(btnPre);
		
		btnFirst = new JButton("Fist");
		btnFirst.setBackground(new Color(255, 255, 240));
		btnFirst.setForeground(new Color(139, 69, 19));
		btnFirst.setBounds(297, 364, 73, 25);
		contentPane.add(btnFirst);
		
		btnNext = new JButton("Next");
		btnNext.setBackground(new Color(255, 255, 240));
		btnNext.setForeground(new Color(139, 69, 19));
		btnNext.setBounds(394, 364, 68, 25);
		contentPane.add(btnNext);
		
		btnRepair = new JButton("Repair");
		btnRepair.setBackground(new Color(255, 255, 240));
		btnRepair.setForeground(new Color(139, 69, 19));
		btnRepair.setBounds(487, 364, 73, 25);
		contentPane.add(btnRepair);
		
				JLabel lblNewBackGround = new JLabel("new background");
				lblNewBackGround.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\fd2ef87894e69f16e0967cd73aa1157e.jpg"));
				lblNewBackGround.setBounds(0, 0, 565, 402);
				contentPane.add(lblNewBackGround);

		
		
		
		

//		btnExit = new JButton("Exit");
//		btnExit.setForeground(new Color(139, 69, 19));
//		btnExit.setBackground(new Color(255, 255, 240));
//		btnExit.setBounds(402, 364, 97, 25);
//		contentPane.add(btnExit);

		btnUpdate.addActionListener(this);
		btnReset.addActionListener(this);
		btnNext.addActionListener(this);
		btnFirst.addActionListener(this);
		btnNext.addActionListener(this);
		btnPre.addActionListener(this);
		//btnExit.addActionListener(this);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate)
			Up();
		if (e.getSource() == btnReset)
			Reset();
		if (e.getSource() == btnRepair)
			Repair();
//		if (e.getSource() == btnExit)
//			setVisible(false);
		if (e.getSource() == btnFirst)
			First();
		if (e.getSource() == btnPre)
			Pre();
		if (e.getSource() == btnNext)
			Next();
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.print("Error: " + ex.getMessage());
		}
		try {
			String url = "jdbc:mysql://localhost/coffeehouse";
			String user = "root";
			String pass = "";
			con = DriverManager.getConnection(url, user, pass);

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM Menu");
		} catch (SQLException se) {
			System.err.println("Error: " + se.getMessage());
		}
	}

	public void Up() {
		try {
			connect();
			rs.moveToInsertRow();
			rs.updateString(1, txtIdDrinks.getText());
			rs.updateString(2, txtNameDrinks.getText());
			rs.updateLong(3, Long.parseLong(txtPrice.getText()));
			rs.insertRow();
			txtIdDrinks.setText("");
			txtNameDrinks.setText("");
			txtPrice.setText("");
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}

	public void Reset() {
		txtIdDrinks.setText("");
		txtNameDrinks.setText("");
		txtPrice.setText("");
	}
//sua ten do uong va don gia
	public void Repair() {
		try {
			connect();
			rs.absolute(rs.getRow() + 1);
			rs.moveToInsertRow();
			rs.updateString(2, txtNameDrinks.getText());
			rs.updateLong(3, Long.parseLong(txtPrice.getText()));
			rs.updateRow();
			txtIdDrinks.setText("");
			txtNameDrinks.setText("");
			txtPrice.setText("");
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}
	public void Next() 
	{
		try
		{
			rs.next();
			txtIdDrinks.setText(rs.getString(1));
			txtNameDrinks.setText(rs.getString(2));
			txtPrice.setText(Long.toString(rs.getLong(3)));
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.getMessage());
		}
	}
	public void First() 
	{
		try{
			connect();
			rs.first();
			txtIdDrinks.setText(rs.getString(1));
			txtNameDrinks.setText(rs.getString(2));
			txtPrice.setText(Long.toString(rs.getLong(3)));
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.toString());
		}
	}
	public void Pre() 
	{
		try{
			rs.previous();
			txtIdDrinks.setText(rs.getString(1));
			txtNameDrinks.setText(rs.getString(2));
			txtPrice.setText(Long.toString(rs.getLong(3)));
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.getMessage());
		}
	}
}
