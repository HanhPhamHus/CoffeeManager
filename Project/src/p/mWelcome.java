package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class mWelcome extends JFrame  implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mWelcome frame = new mWelcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mWelcome() {
		setTitle("Welcome");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBack = new JLabel("Welcome to Coffee House !");
		lblBack.setBackground(new Color(139, 69, 19));
		lblBack.setForeground(new Color(255, 255, 255));
		lblBack.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 45));
		lblBack.setBounds(110, 104, 634, 96);
		contentPane.add(lblBack);
		
		JButton btnWelcome = new JButton("Welcome");
		btnWelcome.setBackground(new Color(255, 255, 240));
		btnWelcome.setForeground(new Color(139, 69, 19));
		btnWelcome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnWelcome.setBounds(274, 374, 122, 25);
		btnWelcome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mFrame m=new mFrame();
				m.setVisible(true);
				m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		contentPane.add(btnWelcome);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 240));
		btnCancel.setForeground(new Color(139, 69, 19));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBounds(443, 374, 122, 25);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\coffee_welcome03.jpg"));
		lblNewLabel.setBounds(0, 0, 808, 518);
		contentPane.add(lblNewLabel);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
