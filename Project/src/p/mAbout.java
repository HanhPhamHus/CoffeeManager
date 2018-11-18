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
		setBounds(200, 100, 495, 422);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("CoffeeHouse Manager");
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setBounds(46, 0, 275, 60);
		contentPane.add(lblNewLabel);

		JLabel lblStudentPhamthi = new JLabel("Student 1: PhamThi Thu Hanh");
		lblStudentPhamthi.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
		lblStudentPhamthi.setForeground(new Color(139, 69, 19));
		lblStudentPhamthi.setBounds(12, 98, 233, 25);
		contentPane.add(lblStudentPhamthi);

		JLabel lblStudentDo = new JLabel("Student 2: Do Xuan Hieu");
		lblStudentDo.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
		lblStudentDo.setForeground(new Color(139, 69, 19));
		lblStudentDo.setBounds(12, 147, 205, 25);
		contentPane.add(lblStudentDo);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\phamthuhanh\\Documents\\tài liệu Hạnh\\OOP\\a281ac60e5c6a676647da58e96399ffd.jpg"));
		lblNewLabel_1.setBounds(0, 0, 575, 393);
		contentPane.add(lblNewLabel_1);
		setBounds(200, 100, 400, 250);
		setVisible(true);
		setResizable(false);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(139, 69, 19));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnExit.setBounds(148, 190, 97, 25);
		contentPane.add(btnExit);

		btnExit.addActionListener(this);
		getContentPane().add(btnExit, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnExit)
			setVisible(false);
	}
}