package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import p.mAbout;
import b.TableItemB;
import p.mHelp;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JButton;

public class mFrame extends JFrame {

	private JPanel contentPane;
	private Component btnNewButton;
	private Component btnMenuManager;
	private JButton btnUpdateTable;
	private JButton btnUpdateUser;

	public mFrame() {
		setFont(new Font("Century Gothic", Font.BOLD, 17));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setTitle("CoffeeHouse");
		setBackground(new Color(245, 222, 179));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 621);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\buoi-sang-nhanh-tinh-tao-voi-ly-capuchino-tu-pha.jpg"));
		lblNewLabel.setBounds(0, 27, 1065, 547);
		contentPane.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(139, 69, 19));
		menuBar.setBounds(0, 0, 1166, 26);
		contentPane.add(menuBar);
		// Login, logout
		JMenu mnLogin = new JMenu("Fistly");
		mnLogin.setForeground(new Color(255, 255, 255));
		menuBar.add(mnLogin);

		JMenuItem mntmLogin = new JMenuItem("Log in");
		mntmLogin.setForeground(new Color(255, 255, 255));
		mntmLogin.setBackground(new Color(139, 69, 19));
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginCoff loginFrame = new LoginCoff(mFrame.this);
				loginFrame.setVisible(true);
			}
		});

		mnLogin.add(mntmLogin);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.setBackground(new Color(139, 69, 19));
		mntmLogOut.setForeground(new Color(255, 255, 255));
		mntmLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				disableControl();

			}
		});
		mnLogin.add(mntmLogOut);

		// Jmenubar
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);

		JMenuItem mntmUseTable = new JMenuItem("Use Table");
		mntmUseTable.setBackground(new Color(139, 69, 19));
		mntmUseTable.setForeground(new Color(255, 255, 255));
		mntmUseTable.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mUseTable mu=new mUseTable();
				mu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//mu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmUseTable);

		JMenuItem mntmOrder = new JMenuItem("Order");
		mntmOrder.setBackground(new Color(139, 69, 19));
		mntmOrder.setForeground(new Color(255, 255, 255));
		
		mntmOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mOrder mo=new mOrder();
				mo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
		});
		mnNewMenu.add(mntmOrder);

		JMenuItem mntmBill = new JMenuItem("Bill");
		mntmBill.setBackground(new Color(139, 69, 19));
		mntmBill.setForeground(new Color(255, 255, 255));
		mntmBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mBill mb=new mBill();
				mb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		mnNewMenu.add(mntmBill);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setBackground(new Color(139, 69, 19));
		mntmExit.setForeground(new Color(255, 255, 255));
		mntmExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
				
			}
		});
		mnNewMenu.add(mntmExit);

		JMenu mnNewMenu_2 = new JMenu("Process");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmChangleDrinks = new JMenuItem("Changle Drinks");
		mntmChangleDrinks.setForeground(new Color(255, 255, 255));
		mntmChangleDrinks.setBackground(new Color(139, 69, 19));
		mnNewMenu_2.add(mntmChangleDrinks);

		JMenuItem mntmTableMix = new JMenuItem("Table Mix");
		mntmTableMix.setForeground(new Color(255, 255, 255));
		mntmTableMix.setBackground(new Color(139, 69, 19));
		mnNewMenu_2.add(mntmTableMix);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(new Color(255, 255, 255));
		mnHelp.setBackground(new Color(139, 69, 19));
		menuBar.add(mnHelp);

		JMenuItem mntmHelppro = new JMenuItem("HelpPro");
		mntmHelppro.setForeground(new Color(255, 255, 255));
		mntmHelppro.setBackground(new Color(139, 69, 19));
		mntmHelppro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mHelp mh=new mHelp();
				mh.setVisible(true);
				mh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				mh.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				

			}
		});
		mnHelp.add(mntmHelppro);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setForeground(new Color(255, 255, 255));
		mntmAbout.setBackground(new Color(139, 69, 19));
		mntmAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mAbout ma=new mAbout();
				ma.setVisible(true);
				ma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				

			}
		});
		mnHelp.add(mntmAbout);
		btnMenuManager = new JButton("Menu Manager");
		btnMenuManager.setBounds(909, 65, 122, 25);
		
		((AbstractButton) btnMenuManager).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mMenuManager t = new mMenuManager();
				t.setVisible(true);
				t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		contentPane.add(btnMenuManager);
		btnMenuManager.setEnabled(false);
		btnMenuManager.setBackground(new Color(139, 69, 19));
		btnMenuManager.setForeground(new Color(255, 255, 255));

//update table
		btnUpdateTable = new JButton("Update Table");
		btnUpdateTable.setBounds(909, 103, 122, 25);
		btnUpdateTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mThemBan t = new mThemBan();
				t.setVisible(true);
				t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		contentPane.add(btnUpdateTable);
		btnUpdateTable.setEnabled(false);
		btnUpdateTable.setBackground(new Color(139, 69, 19));
		btnUpdateTable.setForeground(new Color(255, 255, 255));
//update user
		btnUpdateUser = new JButton("Update User");
		btnUpdateUser.setBounds(909, 145, 122, 25);
		btnUpdateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mUserManager mum=new mUserManager();
				mum.setVisible(true);
				mum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		contentPane.add(btnUpdateUser);
		btnUpdateUser.setEnabled(false);
		btnUpdateUser.setForeground(new Color(255, 255, 255));
		btnUpdateUser.setBackground(new Color(139, 69, 19));

		
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 56, 16);
		contentPane.add(label);

	}

	void enableControl() {
		btnMenuManager.setEnabled(true);
		btnUpdateTable.setEnabled(true);
		btnUpdateUser.setEnabled(true);

	}

	void disableControl() {
		btnMenuManager.setEnabled(false);
		btnUpdateTable.setEnabled(false);
		btnUpdateUser.setEnabled(false);

	}

}
