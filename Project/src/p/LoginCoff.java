package p;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import b.UserB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginCoff extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	//private static MainFrame parent;
	private static mFrame parent;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginCoff frame = new LoginCoff();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
//	public LoginCoff() {
	public LoginCoff(mFrame parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 128, 0));
		setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		setTitle("LoginCoffee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblUsername.setBounds(73, 35, 88, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(73, 97, 88, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(194, 33, 136, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 205));
		passwordField.setBounds(194, 95, 136, 22);
		contentPane.add(passwordField);
// use combobox to admin and employee
//		JComboBox comboBox = new JComboBox();
//		comboBox.setForeground(new Color(255, 255, 255));
//		comboBox.setBackground(new Color(65, 105, 225));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose","Admin","Employee"}));
//		comboBox.setBounds(254, 119, 116, 22);
//		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(222, 184, 135));
		btnLogin.setBounds(283, 151, 97, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\coffeehouse.jpg"));
		lblNewLabel.setBounds(0, 0, 432, 253);
		contentPane.add(lblNewLabel);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserB userB = new UserB();
					if(userB.checkLogin(textField.getText(), passwordField.getText())){
						parent.enableControl();
						LoginCoff.this.setVisible(false);
					}else{
//						lblMessage.setForeground(Color.RED);
//						lblMessage.setText("Incorect username or password!");
					}
				} catch (ClassNotFoundException e1) {
					
					System.out.println("Err1"+e1.getMessage());
				} catch (SQLException e2) {
					System.out.println("Err"+e2.getMessage());
				}
			}
		});
		
		
	}

}
