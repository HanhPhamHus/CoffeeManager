package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class mThemBan extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtIdTable;
	private JTextField txtNameTable;
	private JTextField txtNote;
	private JButton btnUpdate;
	private JButton btnReset;
	private JButton btnNext;
	private JButton btnExit;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private JLabel lblNewLabel_2;

	//
	/**
	 * Create the frame.
	 */
	public mThemBan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 449);
		setTitle("UpdateTable");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdTable = new JLabel("ID Table :");
		lblIdTable.setForeground(new Color(139, 69, 19));
		lblIdTable.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblIdTable.setBounds(96, 166, 106, 37);
		contentPane.add(lblIdTable);

		JLabel lblNewLabel = new JLabel("Name Table :");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(96, 229, 106, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNote = new JLabel("Note :");
		lblNote.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNote.setForeground(new Color(139, 69, 19));
		lblNote.setBounds(96, 284, 106, 29);
		contentPane.add(lblNote);
		
		lblNewLabel_2 = new JLabel("Update Table");
		lblNewLabel_2.setBackground(new Color(255, 255, 240));
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel_2.setBounds(205, 101, 136, 37);
		contentPane.add(lblNewLabel_2);

		txtIdTable = new JTextField();
		txtIdTable.setBounds(309, 175, 167, 22);
		contentPane.add(txtIdTable);
		txtIdTable.setColumns(10);

		txtNameTable = new JTextField();
		txtNameTable.setBounds(309, 230, 167, 22);
		contentPane.add(txtNameTable);
		txtNameTable.setColumns(10);

		txtNote = new JTextField();
		txtNote.setBounds(309, 289, 167, 22);
		contentPane.add(txtNote);
		txtNote.setColumns(10);

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
		
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setIcon(new ImageIcon(
						"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\53105310e0f18af7752c762eede78059.jpg"));
				lblNewLabel_1.setBounds(0, 0, 565, 402);
				contentPane.add(lblNewLabel_1);

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
			rs = stmt.executeQuery("SELECT * FROM TableItem");
		} catch (SQLException se) {
			System.err.println("Error: " + se.getMessage());
		}
	}

	public void Up() {
		try {
			connect();
			rs.moveToInsertRow();
			rs.updateString(1, txtIdTable.getText());
			rs.updateString(2, txtNameTable.getText());
			rs.updateString(3, txtNote.getText());
			rs.insertRow();
			txtIdTable.setText("");
			txtNameTable.setText("");
			txtNote.setText("");
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}

	public void Reset()// tra ve danh sach ban trong
	{
		txtIdTable.setText("");
		txtNameTable.setText("");
		txtNote.setText("");
	}

	public void Next() {
		try {
			rs.next();
			txtIdTable.setText(rs.getString(1));
			txtNameTable.setText(rs.getString(2));
			txtNote.setText(rs.getString(3));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
