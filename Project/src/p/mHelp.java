package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class mHelp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mHelp frame = new mHelp();
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
	public mHelp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 434);
		setTitle("HelpPro");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelp = new JLabel("Help",JLabel.CENTER);
		lblHelp.setBackground(new Color(165, 42, 42));
		lblHelp.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		lblHelp.setForeground(new Color(139, 69, 19));
		lblHelp.setBounds(200, 13, 77, 53);
		contentPane.add(lblHelp);
		
		
		JTextArea txtrCoffeehouseManagerCoffee = new JTextArea();
		txtrCoffeehouseManagerCoffee.setEditable(false);
		txtrCoffeehouseManagerCoffee.setForeground(new Color(128, 0, 0));
		txtrCoffeehouseManagerCoffee.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 14));
		txtrCoffeehouseManagerCoffee.setBackground(new Color(255, 250, 250));
		txtrCoffeehouseManagerCoffee.setText("CoffeeHouse Manager By Student\n\nThis is a program that helps to manage\t the cafe easier and simpler\nthe functions of the program\nList of ordered dishes.\nFix the dish guests have booked \nPairing tables for a group of customers\nExact billing for table.\n\n\tThanks for see." );
		txtrCoffeehouseManagerCoffee.setBounds(83, 74, 305, 199);
		contentPane.add(txtrCoffeehouseManagerCoffee);
		
		setVisible(true);
		setResizable(false);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		btnExit.setBackground(new Color(255, 250, 240));
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.setBounds(179, 349, 97, 25);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\838e2df4b64167bf58353bb5242b579c.jpg"));
		lblNewLabel.setBounds(0, 0, 504, 385);
		contentPane.add(lblNewLabel);
		
		
		setResizable(false);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnExit)
			setVisible(false);
	}
	
}
