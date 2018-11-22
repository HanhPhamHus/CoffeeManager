package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class updateMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPrice;
	private Choice chIdDr;
	private JButton btnExit;
	private JButton btnUpdate;

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

// 	/**
// 	 * Launch the application.
// 	 */
// 	public static void main(String[] args) {
// 		EventQueue.invokeLater(new Runnable() {
// 			public void run() {
// 				try {
// 					updateMenu frame = new updateMenu();
// 					frame.setVisible(true);
// 				} catch (Exception e) {
// 					e.printStackTrace();
// 				}
// 			}
// 		});
// 	}

// 	/**
// 	 * Create the frame.
// 	 */
	public updateMenu() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setTitle("UpdateMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 255, 224));
		btnUpdate.setFont(new Font("Linux Libertine G", Font.BOLD, 16));
		btnUpdate.setForeground(new Color(139, 69, 19));
		btnUpdate.setBounds(145, 318, 97, 25);
		contentPane.add(btnUpdate);

		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 255, 224));
		btnExit.setFont(new Font("Linux Libertine G", Font.BOLD, 16));
		btnExit.setForeground(new Color(139, 69, 19));
		btnExit.setBounds(267, 318, 97, 25);
		contentPane.add(btnExit);

		JLabel lblIdDrinks = new JLabel("Id Drinks");
		lblIdDrinks.setFont(new Font("Linux Libertine G", Font.BOLD, 16));
		lblIdDrinks.setForeground(new Color(139, 69, 19));
		lblIdDrinks.setBounds(68, 110, 110, 31);
		contentPane.add(lblIdDrinks);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Linux Libertine G", Font.BOLD, 16));
		lblPrice.setForeground(new Color(139, 69, 19));
		lblPrice.setBounds(68, 220, 110, 33);
		contentPane.add(lblPrice);

		JLabel lblUpdateMenu = new JLabel("Update Menu");
		lblUpdateMenu.setForeground(new Color(139, 69, 19));
		lblUpdateMenu.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 24));
		lblUpdateMenu.setBounds(204, 23, 160, 61);
		contentPane.add(lblUpdateMenu);

		txtPrice = new JTextField();
		txtPrice.setBounds(232, 226, 191, 22);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		chIdDr = new Choice();
		chIdDr.setBounds(232, 110, 191, 22);
		contentPane.add(chIdDr);

		JLabel lblBackground = new JLabel("back");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\updateMenu02.jpg"));
		lblBackground.setBounds(0, 0, 509, 375);
		contentPane.add(lblBackground);
		btnUpdate.addActionListener(this);
		btnExit.addActionListener(this);
		setResizable(false);
		setVisible(true);

		try {
			connect();
			rs = stmt.executeQuery("SELECT * FROM Menu");
			rs.next();
			while (!rs.isAfterLast()) {
				chIdDr.addItem(rs.getString(1));

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
		if (e.getSource() == btnUpdate)
			Update();
		if (e.getSource() == btnExit) {
			setVisible(false);
		}
	}

	public void Update() {
		try {
			connect();

			PreparedStatement stmt = con.prepareStatement("UPDATE Menu SET DonGia=? WHERE DoUongID=?");
			int n = (chIdDr).getSelectedIndex();

			stmt.setString(1, String.valueOf(txtPrice.getText()));
			stmt.setString(2, chIdDr.getItem(n));
	
			stmt.executeUpdate();
			txtPrice.setText("");
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}
}
