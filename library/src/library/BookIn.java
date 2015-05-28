package library;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.sql.*;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class BookIn
        extends JFrame
        implements ActionListener{

    JTextField book_name, book_num, price, author, press;    //�����ı���
    JButton ok = new JButton("ȷ��");
    JButton cancle = new JButton("ȡ��");

    public BookIn(){
        Container cp = getContentPane(); // ��ʼ����塢��ť����ǩ���ı���

        JPanel pn_north = new JPanel();
        JLabel label = new JLabel("ͼ�����", SwingConstants.CENTER);
        label.setForeground(Color.blue);
        pn_north.add(label);

        JPanel pn_west = new JPanel();
        JPanel pn_center = new JPanel(new GridLayout(6, 1));
        book_name = new JTextField(20);
        book_num = new JTextField(20);
        price = new JTextField(20);
        author = new JTextField(20);
        press = new JTextField(20);
        pn_west.setLayout(new GridLayout(6, 1));
        pn_west.add(new JLabel("ͼ���", SwingConstants.CENTER));
        pn_center.add(book_num);
        pn_west.add(new JLabel("ͼ����", SwingConstants.CENTER));
        pn_center.add(book_name);
        pn_west.add(new JLabel("��  ��", SwingConstants.CENTER));
        pn_center.add(price);
        pn_west.add(new JLabel("��  ��", SwingConstants.CENTER));
        pn_center.add(author);
        pn_west.add(new JLabel("������", SwingConstants.CENTER));
        pn_center.add(press);

        JPanel pn_east = new JPanel();

        JPanel pn_south = new JPanel();
        pn_south.setLayout(new GridLayout(2, 1));
        JPanel pn_south1 = new JPanel();
        JPanel pn_south2 = new JPanel();
        pn_south.add(pn_south1);
        pn_south.add(pn_south2);

        pn_south2.add(ok);
        pn_south2.add(cancle);

        cp.add(pn_north, "North");
        cp.add(pn_west, "West");
        cp.add(pn_center, "Center");
        cp.add(pn_south, "South");
        cp.add(pn_east, "East");


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        int x = screen.width;
        int y = screen.height;
        setSize(350, 400);
        int xcenter = (x - 350) / 2;
        int ycenter = (y - 400) / 2;
        setLocation(xcenter, ycenter);/*��ʾ�ڴ�������*/
        setTitle("ͼ�����");
        setResizable(false);

        ok.addActionListener(this);//ע�������
        cancle.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        //String cmd=e.getActionCommand();
        Object source = e.getSource();
        boolean b = Pattern.matches("(\\d+)(.(\\d+))?", price.getText());
        if(source == ok){
            if(book_name.getText().equals("") || book_num.getText().equals("")
                    || price.getText().equals("") || author.getText().equals("")
                    || press.getText().equals("")){
                JOptionPane.showMessageDialog(this,
                        "����д����ͼ����Ϣ��", "��ʾ",
                        JOptionPane.OK_OPTION);
            }
            else if(b == false){
                JOptionPane.showMessageDialog(null, "�۸����", "��ʾ",
                        JOptionPane.YES_NO_OPTION);
            }
            else{
                insertRecord();
            }
        }
        else if(source == cancle){
            this.hide();
        }

    }
    /* public static void main(String []arg){

    BookIn a=new BookIn();
    }*/

    public void insertRecord(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = df.format(date);
        Database db = new Database();
        db.dbCon();
        try{
            String s = "insert into book values('" + book_num.getText() + "','"
                    + book_name.getText() + "','" + price.getText() + "','" + author.
                    getText()
                    + "','" + press.getText() + "','" + time + "',null)";
            //��ѯ�����ͼ����Ƿ������ݿ��д���
            String query = "select * from book where bookNum='" + book_num.
                    getText() + "'";
            ResultSet rs = db.stmt.executeQuery(query);//���ز�ѯ�����
            boolean moreRecords = rs.next();//�жϽ�����Ƿ�������
            if(moreRecords){
                JOptionPane.showMessageDialog(this, "ͼ����Ѿ���"
                        + "ʹ�ã�����������");
                db.dbClose();
                book_num.setText("");
                return;
            }
            else{
                int insert = db.stmt.executeUpdate(s);
                if(insert == 1){
                    JOptionPane.showMessageDialog(null, "ͼ����Ϣ¼��ɹ���");
                    book_num.setText("");
                    book_name.setText("");
                    price.setText("");
                    author.setText("");
                    press.setText("");
                    String str = "select * from book;";
                    ShowBook showbk = new ShowBook();
                    showbk.showFirst(str);
                    MainWin.label1.setText("������ڹ���ͼ�� " + ShowBook.count + " ��");
                }
            }
        }
        catch(SQLException g){
            System.out.println("E Code" + g.getErrorCode());
            System.out.println("E M" + g.getMessage());
            JOptionPane.showMessageDialog(null, "ʱ�����", "��ʾ",
                    JOptionPane.YES_NO_OPTION);
        }
    }
}
