package library;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author xia
 */
//ͼ��ɾ����
public class DelBook{

    public void delBook(){
        //ɾ������ʱ���ж��Ƿ�ѡ�б���л������Ƿ�Ϊ��
        //int index = MainWin.table.getSelectedRow();
        int[] index = MainWin.table.getSelectedRows();
        if(index.length == 0) //if (index.length == 0 || index.length == 0 && MainWin.table.getValueAt(int[0], 0) == "")
        {
            JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ı����",
                    "", JOptionPane.YES_NO_OPTION);
        }
        else{
            int selection = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����ѡ��ͼ����",
                    "���棡", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if(selection == JOptionPane.OK_OPTION){
                //�������ݿ�
                Database db = new Database();
                db.dbCon();
                //��ѡ��Ҫɾ���ı���еڶ��ͼ���ת�����ַ�����ֵ������str_v
                try{
                    int n = 0;
                    for(int i = 0; i < index.length; ++i){
                        String str_v = (String) MainWin.table.getValueAt(
                                index[i], 0);
                        String s = "delete from book  where bookNum ='" + str_v
                                + "'";

                        //ɾ�����ݿ��еļ�¼
                        int del = db.stmt.executeUpdate(s);
                        if(del == 1){
                            n++;
                        }
                    }
                    if(n == index.length){
                        JOptionPane.showMessageDialog(null, "ɾ���ɹ���",
                                "��Ϣ", JOptionPane.YES_NO_OPTION);
                        //������ʾ����

                    }
                    else{
                        JOptionPane.showMessageDialog(null, n + " ����¼��ɾ����"
                                + (index.length - n) + " ����¼�޷�ɾ����",
                                "��Ϣ", JOptionPane.YES_NO_OPTION);
                    }
                    String str = "select * from book;";
                    ShowBook showbk = new ShowBook();
                    showbk.showFirst(str);
                    MainWin.label1.setText("������ڹ���ͼ�� " + ShowBook.count + " ��");
                    db.dbClose();
                }
                catch(SQLException g){
                    System.out.println("E Code:" + g.getErrorCode());
                    System.out.println("E M:" + g.getMessage());
                    JOptionPane.showMessageDialog(null,
                            "���ݿ����ʧ�ܣ�(��������ݿ����)",
                            "��Ϣ", JOptionPane.YES_NO_OPTION);
                }
            }
        }
    }
}
