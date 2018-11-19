package p;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import da.ConnectionUtil;

public class mOrder extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtSetO;
	private JTextField txtQuant;
//	private Choice chTenDoUong;
	private Choice chDoUong;
	//private Choice chTenBan;
	private Choice chBan;

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private JButton btnSave;
	private JButton btnExit;
	private JLabel lblBackground;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// mOrder frame = new mOrder();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
	//
	// /**
	// * Create the frame.
	// */
	public mOrder() {
		setTitle("Order Manager ");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOrder = new JLabel("Order");
		lblOrder.setForeground(new Color(139, 0, 0));
		lblOrder.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 26));
		lblOrder.setBounds(194, 51, 107, 33);
		contentPane.add(lblOrder);

		JLabel lblSetOrder = new JLabel("Set Order");
		lblSetOrder.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSetOrder.setForeground(new Color(139, 69, 19));
		lblSetOrder.setBounds(68, 108, 72, 16);
		contentPane.add(lblSetOrder);

		JLabel lblTable = new JLabel("Table");
		lblTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTable.setForeground(new Color(139, 69, 19));
		lblTable.setBounds(68, 161, 56, 16);
		contentPane.add(lblTable);

		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDrinks.setForeground(new Color(139, 69, 19));
		lblDrinks.setBounds(68, 218, 56, 16);
		contentPane.add(lblDrinks);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setForeground(new Color(139, 69, 19));
		lblQuantity.setBounds(68, 269, 56, 16);
		contentPane.add(lblQuantity);

		txtSetO = new JTextField();
		txtSetO.setBounds(207, 107, 192, 22);
		contentPane.add(txtSetO);
		txtSetO.setColumns(10);

		txtQuant = new JTextField();
		txtQuant.setBounds(207, 266, 192, 22);
		contentPane.add(txtQuant);
		txtQuant.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(139, 69, 19));
		btnSave.setForeground(new Color(255, 255, 240));
		btnSave.setBounds(153, 323, 72, 25);
		contentPane.add(btnSave);

		btnExit = new JButton("Exit ");
		btnExit.setBackground(new Color(139, 69, 19));
		btnExit.setForeground(new Color(255, 255, 240));
		btnExit.setBounds(247, 323, 67, 25);
		contentPane.add(btnExit);

		chBan= new Choice();
		chBan.setBounds(207, 160, 192, 22);
		contentPane.add(chBan);

		chDoUong = new Choice();
		chDoUong.setBounds(207, 212, 192, 22);
		contentPane.add(chDoUong);

		lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(
				"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\6b7ee74f5b06e1979be7b82bbefbc05b.jpg"));
		lblBackground.setBounds(0, 0, 477, 361);
		contentPane.add(lblBackground);

		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		setResizable(false);
		setVisible(true);

		try {
			connect();
			rs = stmt.executeQuery("SELECT * FROM TableItem");
			rs.next();
			while (!rs.isAfterLast()) {
				 chBan.addItem(rs.getString(1));
				//((Choice) chTenBan).addItem(rs.getString(2));
				rs.next();
			}
		} catch (Exception e) {
		}
		try {

			rs = stmt.executeQuery("SELECT * FROM Menu");
			rs.next();
			while (!rs.isAfterLast()) {
				chDoUong.addItem(rs.getString(1));
				//((Choice)chTenDoUong).addItem(rs.getString(2));
				rs.next();
			}
		} catch (Exception e) {
		}

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
		} catch (SQLException se) {
			System.err.println("Error: " + se.getMessage());
		}
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave)
			Save();
		if (e.getSource() == btnExit) {
			setVisible(false);
		}
	}

	public void Save() {
		try {
			connect();
			


			PreparedStatement stmt=con.prepareStatement("INSERT INTO Order_detail(GoiId,BanID,DoUongID,SoLuong) VALUE(?,?,?,?)");
			
			stmt.setString(1,String.valueOf(txtSetO.getText()));
			
			int n = (chBan).getSelectedIndex();
			stmt.setString(2, chBan.getItem(n));

			int m = chDoUong.getSelectedIndex();
			stmt.setString(3, chDoUong.getItem(m));
			
			stmt.setString(4, String.valueOf(txtQuant.getText()));
//			stmt.setString(1, "28");
//			stmt.setString(2, "B1");
//			stmt.setString(3, "CAF");
//			stmt.setInt(4, 3);
			stmt.executeUpdate();
			txtSetO.setText("");
		txtQuant.setText("");
		

		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}
	
}
