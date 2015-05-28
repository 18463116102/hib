package UI;

import java.awt.EventQueue;



import javax.swing.ImageIcon;
//import javax.persistence.Entity;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import Control.AirplaneControl;

import java.awt.Font;


//@Entity
public class Delt_plane {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delt_plane window = new Delt_plane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Delt_plane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5220\u9664\u98DE\u884C\u5668");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = textField.getText();
				int id = Integer.parseInt(i);
				AirplaneControl.getAirplaneControl().deleteAirplane(id);
				Success suc = new Success();
		  		suc.getFrame().setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton.setBounds(83, 217, 93, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(248, 217, 93, 23);
		layeredPane.add(btnNewButton_1);
		
		textField = new JTextField();
		
		textField.setBounds(248, 26, 93, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCcc = new JLabel("\u8F93\u5165\u8981\u5220\u9664\u98DE\u673A\u7684\u7F16\u53F7\uFF1A");
		lblCcc.setFont(new Font("ËÎÌו", Font.BOLD, 12));
		lblCcc.setBounds(83, 21, 167, 31);
		layeredPane.add(lblCcc);
		
		
		ImageIcon icon2 = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\5.jpg");
		JButton btnNewButton_2 = new JButton(icon2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(83, 59, 258, 148);
		layeredPane.add(btnNewButton_2);
	}

	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
}
