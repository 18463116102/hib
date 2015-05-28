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

import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.AirplaneControl;

import java.awt.Choice;

import javax.swing.JComboBox;


//@Entity
public class Add_plane {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	Choice choice = new Choice();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_plane window = new Add_plane();
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
	public Add_plane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u98DE\u884C\u5668");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=textField.getText();
				int id=Integer.parseInt(i);
				String type = choice.getSelectedItem();
				String name = textField_1.getText();
				System.out.println(type);
				AirplaneControl.getAirplaneControl().saveAirplane(id,type,name);
				Success suc = new Success();
		  		suc.getFrame().setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton.setBounds(65, 207, 93, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//MainUI mui = new MainUI();
				//mui.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(278, 207, 93, 23);
		layeredPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setBounds(25, 27, 54, 15);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("\u7C7B\u578B\uFF1A");
		label_1.setBounds(25, 90, 44, 15);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u540D\u79F0\uFF1A");
		label_2.setBounds(25, 161, 54, 15);
		layeredPane.add(label_2);
		
		textField = new JTextField();
		
		
		textField.setBounds(66, 25, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		
		
		choice.setBounds(65, 87, 67, 22);
		choice.add("固定翼");
		choice.add("直升机");
		choice.add("多旋翼");
		layeredPane.add(choice);
		
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(66, 158, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		ImageIcon icon2 = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\6.jpg");
		JButton btnNewButton_2 = new JButton(icon2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(156, 21, 256, 161);
		layeredPane.add(btnNewButton_2);
		
		
		//AirplaneControl.getAirplaneControl().saveAirplane(id,type,name);
	}

	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
}
