package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Icon;

import Control.UserControl;
import Model.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("HIT-MMC\u767B\u5F55");
		frame.setBounds(100, 100, 359, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(44, 95, 54, 15);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(44, 147, 54, 15);
		layeredPane.add(label_1);
		
//		String i=textField.getText();
//		int id=Integer.parseInt(i);
		textField = new JTextField();
		textField.setBounds(108, 92, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		
		passwordField  = new JPasswordField();
		passwordField.setBounds(108, 144, 66, 21);
		layeredPane.add(passwordField);
//		String i=textField.getText();
//		int id=Integer.parseInt(i);
//		String k=textField_1.getText();
////		System.out.println(id);
////		System.out.println(k);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("ËÎÌו", Font.BOLD, 27));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=textField.getText();
				int id=Integer.parseInt(i);
				String k= new String(passwordField.getPassword());
				//String k=textField_1.getText();
				
				int m =  UserControl.getUserControl().getuserID();
				String x =  UserControl.getUserControl().getuserKey();
//				System.out.println("id="+id);
//				System.out.println("key="+k);
//				System.out.println("m="+m);
//				System.out.println("n="+x);
				
				int result = k.compareTo(x);
				System.out.println("result="+result);
				if((id == m))
				{
					if(result == 0)
					{
					
					MainUI mu = new MainUI();
			  		mu.getFrame().setVisible(true);
			  		frame.dispose();
					}
					else
					{
						Keywrong kw = new Keywrong();
				  		kw.getFrame().setVisible(true);
						//System.out.println("key wrong");
					}
				}
				
				else
				{
					//System.out.println("ID wrong");
					IDwrong iw = new IDwrong();
			  		iw.getFrame().setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(207, 91, 93, 71);
		layeredPane.add(btnNewButton);
		
		ImageIcon icon = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\1.jpg");
		JButton button = new JButton(icon);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(44, 23, 256, 33);
		layeredPane.add(button);
		
		
	}
}
