package library;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.sql.*;

public class Login
        extends JFrame
        implements ActionListener{

    JTextField user_name;
    JPasswordField pass_word;
    JButton ok = new JButton("��¼");
    JButton cancle = new JButton("ȡ��");
    JButton tourist = new JButton("�����ѯϵͳ");
    //JRadioButton jrb_reader = new JRadioButton("����", true);
    //JRadioButton jrb_admin = new JRadioButton("����Ա", false);
    //public static boolean isAdmin = false;//�Ƿ����Ա��¼
    public static boolean is_tourist = false;

    public Login(){

        setTitle("ͼ�����ϵͳ");
        Container cp = getContentPane();

        JLabel label1 = new JLabel("�û���");
        JLabel label2 = new JLabel("��    ��");
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel(new GridLayout(2, 1));
        JPanel pn1_west = new JPanel(new GridLayout(5, 1));
        JPanel pn1_center = new JPanel(new GridLayout(5, 1));
        JPanel pn1_south = new JPanel();
        JPanel pn2_center = new JPanel();
        JPanel pn2_south = new JPanel();
        user_name = new JTextField(18);
        pass_word = new JPasswordField(18);

        //ButtonGroup group = new ButtonGroup();
        //group.add(jrb_admin);
        //group.add(jrb_reader);

        pn1_west.add(new JLabel(""));
        pn1_center.add(new JLabel(""));
        pn1_west.add(label1);
        pn1_center.add(user_name);
        pn1_west.add(new JLabel(""));
        pn1_center.add(new JLabel(""));
        pn1_west.add(label2);
        pn1_center.add(pass_word);
        pn1_west.add(new JLabel(""));
        pn1_center.add(new JLabel(""));
//        JLabel label3 = new JLabel("��û�ж����˻�������ע��");
//        label3.setLayout(new FlowLayout(FlowLayout.LEFT));
//        pn1_south.add(label3);

        pn1_west.setBackground(Color.PINK);
        pn1_center.setBackground(Color.PINK);
        pn1_south.setBackground(Color.PINK);
        pn1.add(pn1_west, "West");
        pn1.add(pn1_center, "Center");
        pn1.add(pn1_south, "South");
        pn1.setBackground(Color.PINK);

        //pn2_center.add(jrb_reader);
        //pn2_center.add(jrb_admin);
        pn2_south.add(tourist);
        pn2_south.add(new JLabel("   "));
        pn2_south.add(ok);
        pn2_south.add(new JLabel("  "));
        pn2_south.add(cancle);
        pn2.add(pn2_center);
        pn2.add(pn2_south);
        JLabel label4 = new JLabel("<html><font color=#CC00FF size='7'><i>\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF</i></font>", SwingConstants.CENTER);
        label4.setFont(new Font("����", Font.PLAIN, 12));
        cp.add(label4, "North");
        cp.add(pn1, "Center");
        cp.add(pn2, "South");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        int x = screen.width;			   /*ȡ����ʾ�����ڵĿ��*/
        int y = screen.height;			   /*ȡ����ʾ�����ڵĸ߶�*/

        setSize(300, 250);
        int xcenter = (x - 300) / 2;
        int ycenter = (y - 250) / 2;
        setLocation(xcenter, ycenter);/*��ʾ�ڴ�������*/
        setResizable(false);

        ok.addActionListener(this);//ע���¼�������
        cancle.addActionListener(this);
        tourist.addActionListener(this);
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        //String cmd=e.getActionCommand();
        Object source = e.getSource();
        if(source == ok){
            confirm();
            /*isAdmin = jrb_admin.isSelected();
            if (isAdmin)
            {
            confirm("admin", "adminID", "passwd");
            }
            else
            {
            confirm("reader", "readerID", "readerPasswd");
            }*/
        }
        else if(source == cancle){
            this.dispose();
        }
        else if(source == tourist){
//            isRegisterButton = true;
//            UserAdd userAdd = new UserAdd();
//            userAdd.setVisible(true);
            is_tourist = true;
            new MainWin("").setVisible(true);

        }
    }

    public static void main(String[] arg){

        Login login = new Login();
        login.setVisible(true);
    }

    public void confirm()//��֤�û��������Ƿ���ȷ
    {
        Database db = new Database();
        db.dbCon();
        try{
            String uname = user_name.getText().trim();
            String passwd = pass_word.getText().trim();
            String query = "select * from admin where adminID='"
                    + uname + "' and passwd='" + passwd + "'";
            //String query="select * from admin where adminID='"
            //+uname+"'and passwd='"+passwd+"'";
            ResultSet rs = db.stmt.executeQuery(query);
            if(rs.next()){
                //if(isAdmin)
                MainWin mainWin = new MainWin(uname);
                mainWin.setVisible(true);
                //else
                //    new ReaderWin(uname);
                this.hide();
                //System.exit(0);
                db.dbClose();
            }
            else{
                JOptionPane.showMessageDialog(null, "�û������������", "��ʾ��",
                        JOptionPane.YES_NO_OPTION);
                return;
            }
            user_name.setText("");
            pass_word.setText("");
        }
        catch(SQLException g){
            System.out.println("E Code:" + g.getErrorCode());
            System.out.println("E M:" + g.getMessage());
            JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
        }
    }
}
