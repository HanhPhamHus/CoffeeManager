package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Choice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.*;

public class mBill extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;
	private JButton btnDeleteAll;
	private JButton btnCalc;
	private JLabel lblSum;
	private JLabel lblInsertIdTable;
	private JLabel lblBill;
	private ResultSet rs;
	private Statement stmt;
	private Connection con;
	private Choice choice;
	private TextArea taChinh;
	private long sum;
	private int n;
	private JLabel lblKqua;
	private JLabel lblNewLabel;

	public mBill() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setTitle("Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBill = new JLabel("Bill");
		lblBill.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 32));
		lblBill.setForeground(new Color(139, 69, 19));
		lblBill.setBounds(207, 13, 62, 64);
		contentPane.add(lblBill);

		lblInsertIdTable = new JLabel("Insert Id Table :");
		lblInsertIdTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblInsertIdTable.setForeground(new Color(139, 69, 19));
		lblInsertIdTable.setBounds(45, 89, 117, 28);
		contentPane.add(lblInsertIdTable);

		lblSum = new JLabel("Sum : ");
		lblSum.setForeground(new Color(139, 69, 19));
		lblSum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSum.setBounds(45, 140, 99, 16);
		contentPane.add(lblSum);

		btnCalc = new JButton("Calculate");
		btnCalc.setBackground(new Color(255, 255, 224));
		btnCalc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCalc.setForeground(new Color(139, 69, 19));
		btnCalc.setBounds(81, 417, 97, 25);
		contentPane.add(btnCalc);

		btnDeleteAll = new JButton("Reset All");
		btnDeleteAll.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDeleteAll.setBackground(new Color(255, 255, 240));
		btnDeleteAll.setForeground(new Color(139, 69, 19));
		btnDeleteAll.setBounds(195, 418, 97, 25);
		contentPane.add(btnDeleteAll);

		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 255, 240));
		btnExit.setForeground(new Color(139, 69, 19));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExit.setBounds(320, 418, 97, 25);
		contentPane.add(btnExit);

		choice = new Choice();
		choice.setBackground(new Color(255, 255, 240));
		choice.setBounds(233, 95, 184, 22);
		try {
			connect();
			rs = stmt.executeQuery("SELECT BanID FROM TableItem");
			rs.next();
			while (!rs.isAfterLast()) {
				choice.addItem(rs.getString(1));
				rs.next();
			}
		} catch (Exception e) {
		}
		contentPane.add(choice);

		taChinh = new TextArea();
		taChinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		taChinh.setBackground(new Color(255, 250, 240));
		taChinh.setBounds(45, 181, 402, 204);
		contentPane.add(taChinh);

		lblKqua = new JLabel("0");
		lblKqua.setForeground(new Color(0, 0, 0));
		lblKqua.setBackground(new Color(255, 255, 240));
		lblKqua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqua.setBounds(233, 135, 184, 21);
		contentPane.add(lblKqua);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\a01bee691a00fac80ae64ffa1490d55f.jpg"));
		lblNewLabel.setBounds(0, 0, 490, 467);
		contentPane.add(lblNewLabel);

		btnCalc.addActionListener(this);
		btnDeleteAll.addActionListener(this);
		btnExit.addActionListener(this);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnCalc)
			sum();
		if (ae.getSource() == btnExit)
			setVisible(false);
		if (ae.getSource() == btnDeleteAll)
			DeAll();
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
	}

	public void sum() {
		String s = choice.getItem(choice.getSelectedIndex());
		try {
			connect();
			rs = stmt.executeQuery(
					"SELECT Order_detail.BanID, Menu.DonGia,Order_detail.SoLuong, Menu.DonGia*Order_detail.SoLuong,Menu.TenDoUong AS Tong FROM Menu INNER JOIN (TableItem INNER JOIN Order_detail ON TableItem.BanID = Order_detail.BanID) ON Menu.DoUongID = Order_detail.DoUongID");
			rs.next();
			taChinh.setText("Ten Do Uong\t\tDon Gia\t\t\tSo Luong\t\t\tThoi Gian \n\n");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			while (!rs.isAfterLast()) {
				if (rs.getString(1).equals(s)) {
					sum += (rs.getLong(4));
					taChinh.append("  " + rs.getString(5) + "\t\t");
					taChinh.append("  " + rs.getString(2) + "\t\t\t");
					taChinh.append("  " + rs.getString(3)+  "\t\t\t");
					taChinh.append(" " + dateFormat.format(date) + "\t\t\t");
					taChinh.append("\n");
				}
				rs.next();
			}
			
		} catch (SQLException e) {
			System.err.println("Error:" + e.getMessage());
		}
		lblKqua.setText(Long.toString(sum));
		sum = 0;
		
		// xoa tat ca cac ban ghi do trong Goi_mon
	}

	public void DeAll() {

		try {
			connect();
			PreparedStatement stmt=con.prepareStatement("DELETE FROM order_detail WHERE BanID=?");
			stmt.setString(1, choice.getSelectedItem());
			stmt.executeUpdate();
			taChinh.setText("");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.err.println("Err"+e.getMessage());
		}
	}
}



//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mBill frame = new mBill();
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
//}
