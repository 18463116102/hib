package UI;


import java.awt.EventQueue;




//import javax.persistence.Entity;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.Icon;

import java.awt.Component;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import Control.AirplaneControl;
import Model.Airplane;
import javax.swing.JLabel;
import java.awt.Color;


//@Entity
public class MainUI {

	private JFrame frmHitmmc;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
//	private int exam = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frmHitmmc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHitmmc = new JFrame();
		frmHitmmc.setTitle("HIT-MMC\u98DE\u884C\u5668\u7BA1\u7406");
		frmHitmmc.setBounds(100, 100, 583, 438);
		frmHitmmc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frmHitmmc.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(37, 86, 503, 286);
		layeredPane.add(tab);
		  JPanel p2 = new JPanel();
		  JPanel p3 = new JPanel();
		  
		  JPanel p1 = new JPanel();
		  tab.add(p1,"固定翼");
		  p1.setLayout(null);
		  
		  ImageIcon icon5 = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\3.jpg");
		  JButton button_5 = new JButton(icon5);
		 // button_5.setText("\u5237\u65B0");
		  button_5.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		//刷新
		  		List list = AirplaneControl.getAirplaneControl().findAirplaneTypeFix();
		  		Object[][] object=new Object[list.size()][3];
				for(int i = 0; i<list.size(); i++)
				{
					object[i][0]=( (Airplane)list.get(i) ).getAieplaneId();
					object[i][1]=( (Airplane)list.get(i) ).getAieplaneType();
					object[i][2]=( (Airplane)list.get(i) ).getAieplaneName();
				}
				table.setModel(new DefaultTableModel(
					  	object,
					  	new String[] {
					  		"\u7F16\u53F7", "\u7C7B\u578B", "\u540D\u79F0"
					  	}
					  ));
		  	}
		  });
		  button_5.setBounds(466, 11, 20, 21);
		  p1.add(button_5);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(10, 10, 478, 237);
		  p1.add(scrollPane_1);
		  Airplane airplane = AirplaneControl.getAirplaneControl().findAirplane(10001);
		  
//		  List list = AirplaneControl.getAirplaneControl().findAllAirplane();
//			table = new JTable();
//			Object[][] object=new Object[list.size()][3];
//			for(int i = 0; i<list.size(); i++)
//			{
//				object[i][0]=( (Airplane)list.get(i) ).getAieplaneId();
//				object[i][1]=( (Airplane)list.get(i) ).getAieplaneType();
//				object[i][2]=( (Airplane)list.get(i) ).getAieplaneName();
//			}
		  
		  
		  table = new JTable();
		  
		  
		  scrollPane_1.setViewportView(table);
		  
		  tab.add(p2,"直升机");
		  p2.setLayout(null);
		  
		  
		  JButton button_1 = new JButton(icon5);
		  button_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		List list = AirplaneControl.getAirplaneControl().findAirplaneTypeHli();
		  		Object[][] object=new Object[list.size()][3];
				for(int i = 0; i<list.size(); i++)
				{
					object[i][0]=( (Airplane)list.get(i) ).getAieplaneId();
					object[i][1]=( (Airplane)list.get(i) ).getAieplaneType();
					object[i][2]=( (Airplane)list.get(i) ).getAieplaneName();
				}
		  		table_1.setModel(new DefaultTableModel(
		  			  	object,
		  			  	new String[] {
		  			  		"\u7F16\u53F7", "\u7C7B\u578B", "\u540D\u79F0"
		  			  	}
		  			  ));
		  	}
		  });
		  button_1.setBounds(466, 11, 20, 21);
		  p2.add(button_1);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(10, 10, 478, 237);
		  p2.add(scrollPane);
		  
		  table_1 = new JTable();
		  
		  scrollPane.setViewportView(table_1);
		  
			  
		  tab.add(p3,"多旋翼");
		  p3.setLayout(null);
		  
		  JButton button_2 = new JButton(icon5);
		  button_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		//刷新
		  		List list = AirplaneControl.getAirplaneControl().findAirplaneTypeMul();
		  		Object[][] object=new Object[list.size()][3];
				for(int i = 0; i<list.size(); i++)
				{
					object[i][0]=( (Airplane)list.get(i) ).getAieplaneId();
					object[i][1]=( (Airplane)list.get(i) ).getAieplaneType();
					object[i][2]=( (Airplane)list.get(i) ).getAieplaneName();
				}
		  		table_2.setModel(new DefaultTableModel(
		  			  	object,
		  			  	new String[] {
		  			  		"\u7F16\u53F7", "\u7C7B\u578B", "\u540D\u79F0"
		  			  	}
		  			  ));
		  	}
		  });
		  button_2.setBounds(466, 11, 20, 21);
		  p3.add(button_2);
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(10, 10, 478, 237);
		  p3.add(scrollPane_2);
		  
		  table_2 = new JTable();
		  
		  scrollPane_2.setViewportView(table_2);

		  
		  JButton btnNewButton_13 = new JButton("\u67E5\u770B\u6240\u6709\u98DE\u884C\u5668");
		  btnNewButton_13.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Look_plane lookp = new Look_plane();
				lookp.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton_13.setFont(new Font("宋体", Font.BOLD, 12));
		  btnNewButton_13.setBounds(408, 53, 132, 23);
		  layeredPane.add(btnNewButton_13);
		  
		  JButton button = new JButton("\u6DFB\u52A0\u98DE\u673A");
		  button.setBounds(37, 53, 102, 23);
		  layeredPane.add(button);
		  
		  JButton button_3 = new JButton("\u5220\u9664\u98DE\u673A");
		  button_3.setBounds(160, 53, 105, 23);
		  layeredPane.add(button_3);
		  
		  JButton button_6 = new JButton("\u4FEE\u6539\u98DE\u673A");
		  button_6.setFont(new Font("宋体", Font.BOLD, 12));
		  button_6.setBounds(287, 53, 99, 23);
		  layeredPane.add(button_6);
		  
		  ImageIcon icon2 = new ImageIcon("logo1.jpg");
		  
		  JLabel label = new JLabel("\u54C8\u5C14\u6EE8\u5DE5\u4E1A\u5927\u5B66\u79D1\u6BD4\u7279\u822A\u7A7A\u8054\u5408\u5B9E\u9A8C\u5BA4");
		  label.setBounds(319, 378, 238, 15);
		  layeredPane.add(label);
		  
		  JLabel label_1 = new JLabel("\uFF28\uFF29\uFF34\uFF0D\uFF2D\uFF2D\uFF23");
		  label_1.setForeground(new Color(0, 0, 128));
		  label_1.setFont(new Font("隶书", Font.PLAIN, 41));
		  label_1.setBounds(138, 5, 309, 39);
		  layeredPane.add(label_1);
		  button_6.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Change_plane cmut = new Change_plane();
		  		cmut.getFrame().setVisible(true);
		  	}
		  });
		  button_3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Delt_plane dmut = new Delt_plane();
		  		dmut.getFrame().setVisible(true);
		  	}
		  });
		  button.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Add_plane amut = new Add_plane();
		  		amut.getFrame().setVisible(true);
		  	}
		  });
		  
	  
	}
	public JFrame getFrame(){
		return frmHitmmc;
	}
	public void setFrame(JFrame frame){
		this.frmHitmmc = frame;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
