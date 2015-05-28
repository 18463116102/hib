package library;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;

public class MainWin
        extends JFrame
        implements ActionListener{

    //ȫ�ֱ�������
    public static String userName;
    public  final static int PAGE=20;//ҳ�����ֵ
    public final static int ROW=50;//ÿҳ�̶�������
    public static  String ar[][] = new String[ROW][7];//��ά���������ݿ��е����ݴӶ��ڱ�table����ʾ
    public static final  Object columnName[] = {
        "ͼ���", "ͼ����", "����", "����",
        "������", "���ʱ��", "������"
    };//����ֵ
    

    public static String sbookNum, sbookName, sprice, sauthor, spress, stimeIn;
    public static boolean prevButton=false,nextButton=false,
            firstButton=false,lastButton=false;//����ҳ������ĩҳ������ǰһҳ��������һҳ����ť�Ŀ��Ʒ�
    public static int pageValue=0;//������ʾ�ڼ�ҳ������ShowBook.showPage(int n)ʱ�Ĳ���


    //�ؼ�����

    ///////////////�����
    private JPanel pn_north = new JPanel(new GridLayout(2, 1));

    ////////�˵���1
    private JMenuBar menubar1 = new JMenuBar();

    ////�ļ��˵�
    private JMenu file = new JMenu("�ļ�");
    private JMenuItem exitItem = new JMenuItem("�˳�");

    ////����˵�
    private JMenu manage = new JMenu("����");
    
    private JMenu bookManage = new JMenu("ͼ�����");
    private JMenuItem bookInItem = new JMenuItem("ͼ�����");
    private JMenuItem bookEditItem = new JMenuItem("ͼ��༭");
    private JMenuItem bookRemoveItem = new JMenuItem("ͼ��ɾ��");


    private JMenu borrowManage = new JMenu("���Ĺ���");
    private JMenuItem bookborrowItem = new JMenuItem("����");
    private JMenuItem bookReturnItem = new JMenuItem("����");
    private JMenu userManage = new JMenu("�˻�����");
    private JMenuItem changePasswd = new JMenuItem("��  ��  ��  ��");
    private JMenu readerManage = new JMenu("�����˻�����");
    private JMenuItem addReader = new JMenuItem("���Ӷ���");
    private JMenuItem delReader = new JMenuItem("ɾ������");
    private JMenu root = new JMenu("������Ա����");
    private JMenuItem addAdmin = new JMenuItem("���ӹ���Ա");
    private JMenuItem delAdmin = new JMenuItem("ɾ������Ա");

    ////�鿴�˵�
    private JMenu look = new JMenu("�鿴");
    
    private JMenuItem showAllItem = new JMenuItem("���в���");
    private JMenuItem showBorrowed = new JMenuItem("�ѽ�ͼ��");
    private JMenuItem bookQueryItem = new JMenuItem("ͼ���ѯ");
    
    ////////�˵���2
    private JMenuBar menubar2 = new JMenuBar();
    
    private JButton bookQueryButton = new JButton("��ѯ");
    private JButton bookInButton = new JButton("���");
    private JButton bookEditButton = new JButton("�༭");
    private JButton bookRemoveButton = new JButton("ɾ��");
    private JButton showAllButton = new JButton("���в���");
    private JButton exitButton = new JButton("�˳�");


    //Pan////////////�����
    private JPanel pn_center = new JPanel();//���������ģ��

    public static JLabel label1;
    private JScrollPane scrollpane;
    public static JTable table;

    //////////////����弰�����
    private JPanel pn_west = new JPanel();
    private JPanel pn_east = new JPanel();

    //////////////�����
    private JPanel pn_south = new JPanel();

    private JButton previous = new JButton("��һҳ");
    private JButton next = new JButton("��һҳ");
    private JButton first=new JButton("��ҳ");
    private JButton last=new JButton("ĩҳ");
    public  static JLabel showPage = new JLabel("�� 1 ҳ");

    /**
     * ���캯��
     * @param uname
     */
    MainWin(String uname){

        userName = uname;
        String lab;

        if(Login.is_tourist){
            menubar1.setVisible(false);
            bookInButton.setVisible(false);
            bookRemoveButton.setVisible(false);
            bookEditButton.setVisible(false);

            lab = "ͬѧ ��ã���ӭ����ͼ���ѯϵͳ��";
        }
        else{
            lab = uname + "����Ա��ã���ӭ��¼ͼ�����ϵͳ��";
        }
        if(!userName.equals("root")){
            //root.enable(false);
            root.setEnabled(false);

        }
        Container cp = getContentPane(); // ��ʼ����塢��ť����ǩ���ı���
        label1 = new JLabel(lab, SwingConstants.CENTER);
        table = new JTable(ar,columnName);
        table.isCellEditable(1, 6);
        //table.setFocusable(true);
        scrollpane = new JScrollPane(table);

        cp.add(pn_north, "North");
        cp.add(pn_center, "Center");
        cp.add(pn_west, "West");
        cp.add(pn_east, "East");
        cp.add(pn_south, "South");
        pn_north.add(menubar1);
        pn_north.add(menubar2);

        menubar1.add(file);
        menubar1.add(manage);
        menubar1.add(look);
        file.add(exitItem);
        manage.add(bookManage);
        manage.add(borrowManage);
        manage.add(userManage);
        bookManage.add(bookInItem);
        bookManage.add(bookEditItem);
        bookManage.add(bookRemoveItem);
        userManage.add(changePasswd);
        userManage.add(readerManage);
        userManage.add(root);
        borrowManage.add(bookborrowItem);
        borrowManage.add(bookReturnItem);
        root.add(addAdmin);
        root.add(delAdmin);
        readerManage.add(addReader);
        readerManage.add(delReader);
        look.add(showAllItem);
        look.add(showBorrowed);
        look.add(bookQueryItem);


        menubar2.add(showAllButton);
        menubar2.add(bookQueryButton);
        menubar2.add(bookInButton);
        menubar2.add(bookEditButton);
        menubar2.add(bookRemoveButton);
        menubar2.add(exitButton);
        pn_center.setLayout(new BorderLayout());
        pn_center.setBackground(Color.PINK);
        pn_center.add(label1, "North");
        pn_center.add(scrollpane, "Center");
        pn_south.add(first);
        pn_south.add(previous);
        pn_south.add(showPage);
        pn_south.add(next);
        pn_south.add(last);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        int x = screen.width;
        int y = screen.height;
        //setSize(x,y); /*��ϵͳ����ƽ��������ʾ������*/

        setSize(900, 600);
        int xcenter = (x - 900) / 2;
        int ycenter = (y - 600) / 2;
        setLocation(xcenter, ycenter);/*��ʾ�ڴ�������*/

        setTitle("ͼ�����ϵͳ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        DefaultCellEditor cellEdit = new DefaultCellEditor(new JTextField());
//        cellEdit.setClickCountToStart(2);//˫����ʹѡ��ĸ��ӿɱ༭

        //ע��������
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isRightMouseButton(me)){
                    final int row = table.rowAtPoint(me.getPoint());
                    table.setRowSelectionInterval(row, row);
                    if(row != -1){
                        final int column = table.columnAtPoint(me.getPoint());
                        final JPopupMenu popup = new JPopupMenu();
                        JMenuItem edit = new JMenuItem("�༭");
                        popup.add(edit);
                        edit.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent e){
                                table.clearSelection(); //�������ѡ��״̬
                                table.editCellAt(row, column); //����ĳ��Ϊ�ɱ༭
                            }
                        });
                        JMenuItem del = new JMenuItem("ɾ��");
                        popup.add(del);
                        del.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent ae){
                                new DelBook().delBook();
                            }
                        });
                        /*JMenuItem calcel = new JMenuItem("ȡ��");
                        calcel.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent e){
                                System.out.println("ȡ��");
                                popup.setVisible(false);
                            }
                        });
                        popup.add(new JSeparator());
                        popup.add(calcel);*/
                        popup.show(me.getComponent(), me.getX(), me.getY());
                    }
                }
            }
        });
        bookQueryItem.addActionListener(this);
        bookInItem.addActionListener(this);
        bookEditItem.addActionListener(this);
        bookRemoveItem.addActionListener(this);
        showAllItem.addActionListener(this);
        bookQueryButton.addActionListener(this);
        bookInButton.addActionListener(this);
        bookEditButton.addActionListener(this);
        bookRemoveButton.addActionListener(this);
        showAllButton.addActionListener(this);
        showBorrowed.addActionListener(this);
        changePasswd.addActionListener(this);
        userManage.addActionListener(this);
        readerManage.addActionListener(this);
        addAdmin.addActionListener(this);
        delAdmin.addActionListener(this);
        addReader.addActionListener(this);
        delReader.addActionListener(this);
        exitItem.addActionListener(this);
        exitButton.addActionListener(this);
        root.addActionListener(this);
        previous.addActionListener(this);
        next.addActionListener(this);
        bookReturnItem.addActionListener(this);
        bookborrowItem.addActionListener(this);
        first.addActionListener(this);
        last.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //String cmd=e.getActionCommand();
        Object source = e.getSource();
        if(source == showAllItem || source == showAllButton){
            String str = "select * from book;";
            ShowBook showbk = new ShowBook();
            showbk.showFirst(str);
            label1.setText("������ڹ���ͼ�� " + ShowBook.count + " ��");
        }
        if(source == bookQueryItem || source == bookQueryButton){
            QueryBook queryBook = new QueryBook();
            queryBook.setVisible(true);
        }
        if(source == bookInItem || source == bookInButton){
            BookIn bookIn1 = new BookIn();
            bookIn1.setVisible(true);
        }
        if(source == bookEditItem || source == bookEditButton){
            int index = table.getSelectedRow();
            if(index == -1 || table.getValueAt(index, 1) == null){
                JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�༭�ı����",
                        "����", JOptionPane.YES_NO_OPTION);
            }
            else{

                sbookNum = (String) table.getValueAt(index, 0);
                sbookName = (String) table.getValueAt(index, 1);
                sprice = (String) table.getValueAt(index, 2);
                sauthor = (String) table.getValueAt(index, 3);
                spress = (String) table.getValueAt(index, 4);
                stimeIn = (String) table.getValueAt(index, 5);
                new EditBook().setVisible(true);
            }
        }
        if(source == bookRemoveItem || source == bookRemoveButton){
            DelBook delBook = new DelBook();
            delBook.delBook();
        }
        if(source == showBorrowed){
            String str = "select * from book where borrower!='';";
            ShowBook showbk = new ShowBook();
            showbk.showFirst(str);
            label1.setText("�ѽ�� " + ShowBook.count + " ��");
        }
        if(source == changePasswd){
            ChangePasswd changePasswd1 = new ChangePasswd(userName);
            changePasswd1.setVisible(true);
        }
        if(source == addAdmin){
            UserAdd userAdd = new UserAdd(0);
            userAdd.setVisible(true);
        }
        if(source == delAdmin){
        }
        if(source == addReader){
            new UserAdd(1).setVisible(true);
        }
        if(source == delReader){
        }
        if(source == bookborrowItem){
            new BookBorrow().setVisible(true);
        }
        if(source == bookReturnItem){
            new BookReturn().setVisible(true);
        }
        if(source == previous){
            if(prevButton&&pageValue>0){
                pageValue--;
                new ShowBook().showPage(pageValue);
            }
        }
        if(source == next){
            if(nextButton&&pageValue<ShowBook.maxPage){
                pageValue++;
                new ShowBook().showPage(pageValue);
                prevButton=true;
                firstButton=true;
            }
        }
        if(source == first){
            if(firstButton&&pageValue!=0){
                pageValue=0;
                new ShowBook().showPage(0);
            }
        }
        if(source == last){
            if(lastButton&&pageValue!=ShowBook.maxPage){
                pageValue=ShowBook.maxPage;
                new ShowBook().showPage(pageValue);
                firstButton=true;
                prevButton=true;
            }
        }
        if(source == exitItem || source == exitButton){
            int selection = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���",
                    "���ѣ�", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if(selection == JOptionPane.OK_OPTION){
                System.exit(0);
            }
        }
    }

    /*public static void main(String[] args){
        MainWin mw=new MainWin("root");
        mw.setVisible(true);
    }*/
}
