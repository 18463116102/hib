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
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.AirplaneControl;
import Model.Airplane;


//@Entity
public class Look_plane {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Look_plane window = new Look_plane();
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
	public Look_plane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6240\u6709\u98DE\u884C\u5668");
		frame.setBounds(100, 100, 450, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(331, 242, 93, 23);
		layeredPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 53, 323, 179);
		layeredPane.add(scrollPane);
		
//		List listReser = ReservationControl.getReservationControl().showReser(cusPhone);
//		/*
//		 * µ±Ç°Ô¤Ô¼
//		 */
//		Object[][] object=new Object[listReser.size()][7];
//		for(int i=0; i<listReser.size(); i++){
//			if(( (UmlReservation)listReser.get(i) ).getIsSettle() == 0)
//			{
//				object[i][0]=( (UmlReservation)listReser.get(i) ).getReserId();
//				object[i][1]=( (UmlReservation)listReser.get(i) ).getRoomId();
//				object[i][2]=( (UmlReservation)listReser.get(i) ).getCusPhone();
//				object[i][3]=( (UmlReservation)listReser.get(i) ).getRstartTime();
//				object[i][4]=( (UmlReservation)listReser.get(i) ).getRendTime();
//				object[i][5]=( (UmlReservation)listReser.get(i) ).getReserTime();
//				object[i][6]=( (UmlReservation)listReser.get(i) ).getRemark();
//			}
//			
//		}
//		table.setModel(new DefaultTableModel(object,
//				new String[] {"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"}));
//		/*
		List list = AirplaneControl.getAirplaneControl().findAllAirplane();
		table = new JTable();
		Object[][] object=new Object[list.size()][3];
		for(int i = 0; i<list.size(); i++)
		{
			object[i][0]=( (Airplane)list.get(i) ).getAieplaneId();
			object[i][1]=( (Airplane)list.get(i) ).getAieplaneType();
			object[i][2]=( (Airplane)list.get(i) ).getAieplaneName();
		}
		table.setModel(new DefaultTableModel(object,
			
			new String[] {
				"\u7F16\u53F7", "\u7C7B\u578B", "\u540D\u79F0"
			}
		));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				
//			},
//			new String[] {
//		"\u7F16\u53F7", "\u7C7B\u578B", "\u540D\u79F0"
//	}
//		));
		scrollPane.setViewportView(table);
		
		ImageIcon icon = new ImageIcon("C:\\Workspaces\\MyEclipse Professional 2014\\HIT-MMC final\\picture\\2.jpg");
		JButton btnNewButton_1 = new JButton(icon);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(55, 10, 323, 33);
		layeredPane.add(btnNewButton_1);
	}

	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
}
