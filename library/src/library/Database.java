package library;

import javax.swing.*;
import java.sql.*;

public class Database{

    private String url = "jdbc:mysql://localhost/library";//
    //private String url = "jdbc:mysql://localhost:3306/library";
    public static Connection con;
    public Statement stmt, stmt2;
    //MySQL���ݿ��˻�����
    private String userName = "root";
    private String userPasswd = "a672650880";

    public void dbCon(){
         try{
        Class.forName("org.gjt.mm.mysql.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        }catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,"���ݿ������������ʧ�ܣ�","��ʾ��",
        JOptionPane.YES_NO_OPTION);
        }
        try{
            con = DriverManager.getConnection(url, userName, userPasswd);
            stmt = con.createStatement();
        }
        catch(Exception g){
            JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܣ�", "��ʾ��",
                    JOptionPane.YES_NO_OPTION);
            System.out.println("E M: " + g.getMessage());
        }
    }

    public void dbClose(){
        try{
            con.close();
        }
        catch(SQLException g){
            JOptionPane.showMessageDialog(null, "���ݿ�Ͽ�ʱ����", "��ʾ��",
                    JOptionPane.YES_NO_OPTION);
            System.out.println("E M" + g.getMessage());
        }
    }
}
