package UI;

import java.awt.EventQueue;



import javax.swing.ImageIcon;
//import javax.persistence.Entity;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JButton;

import Control.AirplaneControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Choice;


//@Entity
public class Change_plane {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	Choice choice = new Choice();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_plane window = new Change_plane();
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
	public Change_plane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u98DE\u884C\u5668");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String i = textField.getText();
				int id = Integer.parseInt(i);
//				String i1 = textField_1.getText();
//				int id1 = Integer.parseInt(i1);
				String type = choice.getSelectedItem();
				String name = textField_3.getText();
				System.out.println(id);
//				System.out.println(id1);
				System.out.println(type);
				System.out.println(name);
				AirplaneControl.getAirplaneControl().changePlane(id,type,name);
				Success suc = new Success();
		  		suc.getFrame().setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton.setBounds(50, 203, 93, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(309, 203, 93, 23);
		layeredPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7F16\u53F7\uFF1A");
		label.setBounds(50, 31, 93, 15);
		layeredPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(134, 28, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B\u4FEE\u6539\u4E3A\uFF1A");
		label_2.setBounds(50, 87, 80, 15);
		layeredPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u540D\u5B57\u4FEE\u6539\u4E3A\uFF1A");
		label_3.setBounds(50, 145, 80, 15);
		layeredPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 144, 66, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		choice.setBounds(133, 86, 67, 21);
		choice.add("固定翼");
		choice.add("直升机");
		choice.add("多旋翼");
		layeredPane.add(choice);
		
		ImageIcon icon2 = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\4.jpg");
		JButton btnNewButton_2 = new JButton(icon2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(226, 27, 178, 138);
		layeredPane.add(btnNewButton_2);
	}

	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
}
