package library;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;

class QueryBook
        extends JFrame
        implements ActionListener{

    JTextField book_name = new JTextField(18);
    JButton ok = new JButton("ȷ��");
    JButton cancle = new JButton("ȡ��");

    public QueryBook(){
        Container cp = getContentPane(); // ��ʼ����塢��ť����ǩ���ı���

        //����,��ӿؼ�
        JLabel label1 = new JLabel("������Ҫ��ѯ��ͼ������", SwingConstants.CENTER);
        label1.setForeground(Color.blue);
        JPanel pn_north = new JPanel();
        pn_north.add(label1);
        JPanel pn_west = new JPanel();

        JPanel pn_center = new JPanel();
        pn_center.add(book_name);

        JPanel pn_east = new JPanel();

        JPanel pn_south = new JPanel();
        pn_south.add(ok);
        pn_south.add(cancle);

        cp.add(pn_north, "North");
        cp.add(pn_center, "Center");
        cp.add(pn_west, "West");
        cp.add(pn_east, "East");
        cp.add(pn_south, "South");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        int x = screen.width;
        int y = screen.height;
        setSize(400, 200);
        int xcenter = (x - 350) / 2;
        int ycenter = (y - 330) / 2;
        setLocation(xcenter, ycenter);/*��ʾ�ڴ�������*/
        setTitle("ͼ���ѯ");
        setResizable(false);

        ok.addActionListener(this);//ע�������
        cancle.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String ql = "";
        //String cmd=e.getActionCommand();
        Object source = e.getSource();
        if(source == ok){
            ql = book_name.getText().trim();
            String sql = "select * from book  where bookName"
                    + " like '%" + ql + "%'";
            ShowBook showbk = new ShowBook();
            showbk.showFirst(sql);
            MainWin.label1.setText("��������� " + ShowBook.count + " ��");
            if(ShowBook.count == 0){
                JOptionPane.showMessageDialog(this, "�޴�ͼ�飡");
                return;
            }
            else{
                this.hide();
            }
        }
        if(source == cancle){
            this.dispose();
        }
    }
    /*public static void main(String []arg)
    {
    QueryBook a=new QueryBook();
    }*/
}
