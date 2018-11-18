package p;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class mUserManager extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIdUser;
	private JTextField txtNameUser;
	private JTextField txtPass;
	private JButton btnUpdate;
	private JButton btnReset;
	private JButton btnNext;
	private JButton btnExit;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private JLabel lblUpUser;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtFullName;

	//
	/**
	 * Create the frame.
	 */
	public mUserManager() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 449);
		setTitle("UserManager");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdUser = new JLabel("ID User:");
		lblIdUser.setForeground(new Color(139, 69, 19));
		lblIdUser.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblIdUser.setBounds(63, 93, 79, 29);
		contentPane.add(lblIdUser);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setForeground(new Color(139, 69, 19));
		lblUserName.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUserName.setBounds(63, 135, 106, 21);
		contentPane.add(lblUserName);

		JLabel lblPass = new JLabel("Password :");
		lblPass.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPass.setForeground(new Color(139, 69, 19));
		lblPass.setBounds(63, 175, 97, 21);
		contentPane.add(lblPass);

		lblUpUser = new JLabel("Update User");
		lblUpUser.setBackground(new Color(255, 255, 240));
		lblUpUser.setForeground(new Color(139, 0, 0));
		lblUpUser.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblUpUser.setBounds(201, 39, 136, 37);
		contentPane.add(lblUpUser);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblEmail.setForeground(new Color(139, 69, 19));
		lblEmail.setBounds(63, 213, 56, 16);
		contentPane.add(lblEmail);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblAddress.setForeground(new Color(139, 69, 19));
		lblAddress.setBounds(63, 252, 106, 16);
		contentPane.add(lblAddress);

		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblFullName.setForeground(new Color(139, 69, 19));
		lblFullName.setBounds(63, 291, 97, 16);
		contentPane.add(lblFullName);

		txtIdUser = new JTextField();
		txtIdUser.setBounds(293, 98, 206, 22);
		contentPane.add(txtIdUser);
		txtIdUser.setColumns(10);

		txtNameUser = new JTextField();
		txtNameUser.setBounds(293, 136, 206, 22);
		contentPane.add(txtNameUser);
		txtNameUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(293, 176, 206, 22);
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(293, 211, 206, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(293, 250, 206, 22);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtFullName = new JTextField();
		txtFullName.setBounds(293, 289, 206, 22);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(139, 69, 19));
		btnUpdate.setBackground(new Color(255, 255, 240));
		btnUpdate.setBounds(63, 364, 97, 25);
		contentPane.add(btnUpdate);

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 240));
		btnReset.setForeground(new Color(139, 69, 19));
		btnReset.setBounds(172, 364, 97, 25);
		contentPane.add(btnReset);

		btnNext = new JButton("Next");
		btnNext.setBackground(new Color(255, 255, 240));
		btnNext.setForeground(new Color(139, 69, 19));
		btnNext.setBounds(293, 364, 97, 25);
		contentPane.add(btnNext);

		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(139, 69, 19));
		btnExit.setBackground(new Color(255, 255, 240));
		btnExit.setBounds(402, 364, 97, 25);
		contentPane.add(btnExit);

		JLabel lblBackground = new JLabel("New Background");
		lblBackground.setIcon(new ImageIcon(
				"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\bd2214700705ca45622cdd666c440020.jpg"));
		lblBackground.setBounds(0, 0, 565, 402);
		contentPane.add(lblBackground);

		btnUpdate.addActionListener(this);
		btnReset.addActionListener(this);
		btnNext.addActionListener(this);
		btnExit.addActionListener(this);

		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate)
			Up();
		if (e.getSource() == btnReset)
			Reset();
		if (e.getSource() == btnNext)
			Next();
		if (e.getSource() == btnExit)
			setVisible(false);

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
			rs = stmt.executeQuery("SELECT * FROM User");
		} catch (SQLException se) {
			System.err.println("Error: " + se.getMessage());
		}
	}

	public void Up() {
		try {
			connect();
			rs.moveToInsertRow();
			rs.updateString(1, txtIdUser.getText());
			rs.updateString(2, txtNameUser.getText());
			rs.updateString(3, txtPass.getText());
			rs.updateString(4, txtEmail.getText());
			rs.updateString(5, txtAddress.getText());
			rs.updateString(6, txtFullName.getText());
			rs.insertRow();
			txtIdUser.setText("");
			txtNameUser.setText("");
			txtPass.setText("");
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}

	public void Reset()// tra ve danh sach ban trong
	{
		txtIdUser.setText("");
		txtNameUser.setText("");
		txtPass.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
		txtFullName.setText("");
	}

	public void Next() {
		try {
			rs.next();
			txtIdUser.setText(rs.getString(1));
			txtNameUser.setText(rs.getString(2));
			txtPass.setText(rs.getString(3));
			txtEmail.setText(rs.getString(4));
			txtAddress.setText(rs.getString(5));
			txtFullName.setText(rs.getString(6));
			
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mUserManager frame = new mUserManager();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
