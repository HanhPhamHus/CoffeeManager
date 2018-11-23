package p;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class mAbout extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExit;

	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mAbout frame = new mAbout();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public mAbout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\images.jpg"));
		setFont(new Font("Century Gothic", Font.BOLD, 16));
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 100, 504, 387);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("CoffeeHouse Manager");
		lblNewLabel.setBounds(70, 38, 299, 60);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setForeground(new Color(139, 69, 19));
		contentPane.add(lblNewLabel);

		JLabel lblStudentPhamthi = new JLabel("Student 1: PhamThi Thu Hanh");
		lblStudentPhamthi.setBounds(70, 127, 260, 25);
		lblStudentPhamthi.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 17));
		lblStudentPhamthi.setForeground(new Color(139, 69, 19));
		contentPane.add(lblStudentPhamthi);

		JLabel lblStudentDo = new JLabel("Student 2: Do Xuan Hieu");
		lblStudentDo.setBounds(70, 181, 205, 25);
		lblStudentDo.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 17));
		lblStudentDo.setForeground(new Color(139, 69, 19));
		contentPane.add(lblStudentDo);
		setBounds(200, 100, 445, 422);
		setVisible(true);
		setResizable(false);
		
		JLabel lblStudentVu = new JLabel("Student 3: Vu Thi Hao");
		lblStudentVu.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 17));
		lblStudentVu.setForeground(new Color(139, 69, 19));
		lblStudentVu.setBounds(70, 237, 218, 25);
		contentPane.add(lblStudentVu);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(151, 326, 97, 25);
		btnExit.setBackground(new Color(139, 69, 19));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Segoe Print", Font.BOLD, 17));
		contentPane.add(btnExit);

		btnExit.addActionListener(this);
		getContentPane().add(btnExit, BorderLayout.SOUTH);
		
		JLabel lblback = new JLabel("back");
		lblback.setIcon(new ImageIcon("C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\about.jpg"));
		lblback.setBounds(0, 0, 441, 387);
		contentPane.add(lblback);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnExit)
			setVisible(false);
	}
}
