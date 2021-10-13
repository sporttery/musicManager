package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import bean.SongBean;
import dao.Dao;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenuItem addFolder = new JMenuItem("����ļ���");
    JMenuItem addFile = new JMenuItem("����ļ�");
    JMenu edit = new JMenu("�༭");
    JMenuItem del = new JMenuItem("ɾ��");
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JTextField search = new JTextField();
    JPanel jPanel1 = new JPanel();
    JButton sure = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable songTable = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JButton choosePath = new JButton();
    JLabel copyPath = new JLabel();
    JLabel state = new JLabel();
    JLabel jLabel1 = new JLabel();
    File toFolder; //Ҫ���Ƶ��ļ���·��
    private int firstRow; //�Ա�����ʱѡ��ĵ�һ��
    private int lastRow; //�Ա�����ʱѡ������һ��
    GridLayout gridLayout1 = new GridLayout();
    TitledBorder titledBorder1 = new TitledBorder("");
    JMenuItem jMenuItem1 = new JMenuItem();
    JMenuItem jMenuItem2 = new JMenuItem();
    JMenuItem jMenuItem3 = new JMenuItem();
    JPopupMenu rightClick = new JPopupMenu();
    JMenuItem jMenuItem4 = new JMenuItem();
    JMenu jMenu1 = new JMenu();
    JMenuItem jMenuItem5 = new JMenuItem();
    JMenuItem jMenuItem6 = new JMenuItem();
    JMenuItem jMenuItem7 = new JMenuItem();
    JMenuItem jMenuItem8 = new JMenuItem();

    public MainFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(727, 491));
        setTitle("�Ź���������ϵͳ");
        this.addKeyListener(new MainFrame_this_keyAdapter(this));
        jMenuFile.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuFile.setText("�ļ�");
        jMenuFileExit.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuFileExit.setText("�˳�");
        jMenuFileExit.addActionListener(new
                                        MainFrame_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuHelp.setText("����");
        jMenuHelpAbout.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuHelpAbout.setText("��  ��");
        jMenuHelpAbout.addActionListener(new
                                         MainFrame_jMenuHelpAbout_ActionAdapter(this));
        search.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        search.setText(" �����ؼ���");
        search.addKeyListener(new MainFrame_search_keyAdapter(this));
        search.addFocusListener(new MainFrame_search_focusAdapter(this));
        sure.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        sure.setText(" ��  �� ");
        sure.addActionListener(new MainFrame_sure_actionAdapter(this));
        songTable.setBackground(SystemColor.info);
        songTable.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        songTable.setForeground(SystemColor.activeCaption);
        songTable.setRowHeight(20);
        songTable.addKeyListener(new MainFrame_songTable_keyAdapter(this));
        songTable.addMouseListener(new MainFrame_songTable_mouseAdapter(this));
        addFile.addActionListener(new MainFrame_addFile_actionAdapter(this));
        addFolder.addActionListener(new MainFrame_addFolder_actionAdapter(this));
        choosePath.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        choosePath.setText("����·��");
        choosePath.addActionListener(new MainFrame_choosePath_actionAdapter(this));
        copyPath.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        copyPath.setBorder(titledBorder1);
        copyPath.setText("����·��");
        state.setFont(new java.awt.Font("������", Font.PLAIN, 13));
        state.setForeground(Color.magenta);
        state.setBackground(Color.green);
        state.setText(" δ���� ");
        jLabel1.setText("����״̬");
        jLabel1.setBackground(Color.PINK);
        jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 13));
        jLabel1.setForeground(SystemColor.desktop);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        del.addActionListener(new MainFrame_del_actionAdapter(this));
        jMenuBar1.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        addFile.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        addFolder.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        edit.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        del.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        gridLayout1.setHgap(9);
        jPanel1.setLayout(gridLayout1);
        jMenuItem1.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem1.setText("ʹ��˵��");
        jMenuItem1.addActionListener(new MainFrame_jMenuItem1_actionAdapter(this));
        jMenuItem2.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem2.setActionCommand("���");
        jMenuItem2.setText("���");
        jMenuItem2.addActionListener(new MainFrame_jMenuItem2_actionAdapter(this));
        jMenuItem3.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem3.setText("ˢ��");
        jMenuItem3.addActionListener(new MainFrame_jMenuItem3_actionAdapter(this));
        jMenuItem4.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem4.setText("ɾ��");
        jMenuItem4.addActionListener(new MainFrame_jMenuItem4_actionAdapter(this));
        jMenu1.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenu1.setText("����");
        jMenuItem6.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem6.setText("���ļ���");
        jMenuItem6.addActionListener(new MainFrame_jMenuItem6_actionAdapter(this));
        jMenuItem5.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem5.setText("���ȶ�");
        jMenuItem5.addActionListener(new MainFrame_jMenuItem5_actionAdapter(this));
        jMenuItem7.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem7.setText("���");
        jMenuItem7.addActionListener(new MainFrame_jMenuItem7_actionAdapter(this));
        jMenuItem8.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jMenuItem8.setText("����");
        jMenuItem8.addActionListener(new MainFrame_jMenuItem8_actionAdapter(this));
        jMenuBar1.add(jMenuFile);
        jMenuFile.add(addFile);
        jMenuFile.add(addFolder);
        jMenuFile.add(jMenuFileExit);
        jMenuBar1.add(edit);
        jMenuBar1.add(jMenuHelp);
        jMenuHelp.add(jMenuItem1);
        jMenuHelp.add(jMenuHelpAbout);
        contentPane.add(jPanel1, java.awt.BorderLayout.SOUTH);
        jPanel1.add(sure);
        jPanel1.add(search);
        jPanel1.add(choosePath);
        jPanel1.add(copyPath);
        jPanel1.add(jLabel1);
        jPanel1.add(state);
        jScrollPane1.getViewport().add(songTable);
        contentPane.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        edit.add(del);
        edit.add(jMenuItem2);
        edit.add(jMenuItem3);
        rightClick.add(jMenuItem8);
        rightClick.add(jMenuItem4);
        rightClick.add(jMenu1);
        rightClick.add(jMenuItem7);
        jMenu1.add(jMenuItem5);
        jMenu1.add(jMenuItem6);
        setJMenuBar(jMenuBar1);
        makeSongTable(new Dao().getDate()); //�����ݿ���ȡ������
    }

    //���ɱ��
    private void makeSongTable(Vector allSong) {
        String[] hand = {"������", "����·��", "������С", "�����ȶ�"};
        int size = allSong.size();
        String songinfo[][] = new String[size][4];
        for (int i = 0; i < size; i++) {
            songinfo[i][0] = ((SongBean) allSong.get(i)).getSongName();
            songinfo[i][1] = ((SongBean) allSong.get(i)).getSongPath();
            songinfo[i][2] = ((SongBean) allSong.get(i)).getSongSize();
            songinfo[i][3] = String.valueOf(((SongBean) allSong.get(i)).getHot());
        }
        model.setDataVector(songinfo, hand);
        songTable.setModel(model);
    }


    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
    @SuppressWarnings("deprecation")
	void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        MainFrame_AboutBox dlg = new MainFrame_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }

    //ѡ�����ļ���Ӹ���
    public void addFile_actionPerformed(ActionEvent e) {
        JFileChooser chooseFile = new JFileChooser();
        FileFilter ff = new FileFile();
        chooseFile.addChoosableFileFilter(ff);
        chooseFile.setMultiSelectionEnabled(true);
        int k = chooseFile.showOpenDialog(this);
        if (k == JFileChooser.APPROVE_OPTION) {
            File f[] = chooseFile.getSelectedFiles(); //ѡ�����ļ���Ӹ���
            for (int i = 0; i < f.length; i++) {
                SongBean songB = new SongBean(f[i].getName(), f[i].getParent(),
                                              (f[i].length() / 1024 + "KB"), 0);
                try {
                    new Dao().insert(songB);
                } catch (Exception ex) {
                    continue;
                }
            }
            makeSongTable(new Dao().getDate());
            state.setForeground(Color.BLUE);
            state.setText("������ݳɹ�");
        }

    }

    public void search_focusGained(FocusEvent e) {
        search.setText("");
    }

    //ѡ���ļ�����Ӹ���
    public void addFolder_actionPerformed(ActionEvent e) {
        JFileChooser chooseFolder = new JFileChooser();
        FileFilter ff = new FileFolder();
        chooseFolder.addChoosableFileFilter(ff);
        chooseFolder.setMultiSelectionEnabled(false);
        chooseFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int k = chooseFolder.showOpenDialog(this);
        if (k == JFileChooser.APPROVE_OPTION) {
            File folder = chooseFolder.getSelectedFile(); //ѡ���ļ�����Ӹ���
            File f[] = folder.listFiles(new FileFilt());
            for (int i = 0; i < f.length; i++) {
                SongBean songB = new SongBean(f[i].getName(), f[i].getParent(),
                                              (f[i].length() / 1024 + "KB"), 0);
                try {
                    new Dao().insert(songB);
                } catch (Exception ex) {
                    continue;
                }
            }
            makeSongTable(new Dao().getDate());
            state.setForeground(Color.BLUE);
            state.setText("������ݳɹ�");
        }
    }

//���ط���  Ҫ������������һ�������ļ����ļ�����һ����Դ�ļ���Ĭ����������ļ�����Դ�ļ�����ͬ
    public boolean copy(String fileName, File oldFile) {
        if (!oldFile.exists()) {
            JOptionPane.showMessageDialog(this, oldFile.getName() + "�ļ�������",
                                          "����",
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //��ѡ�񱣴�·��ʱ�ļ���Ϊ
        if (copyPath.getText().equals("����·��")) {
            fileName = oldFile.getName();
        } else if (fileName.equals("")) {
            fileName = copyPath.getText() + "\\" + oldFile.getName();
        } else {
            fileName = copyPath.getText() + "\\" + fileName;
        }

        System.out.println(fileName);

        //�ж���·���Ƿ���ڴ��ļ�
        File temp = new File(fileName);
        if (temp.exists()) {
            int i = JOptionPane.showConfirmDialog(this,
                                                  temp.getName() +
                                                  "�ļ��Ѵ��ڣ��Ƿ񸲸ǣ�",
                                                  "����",
                                                  JOptionPane.YES_NO_OPTION);
            //û��ѡ�Ǿͷ���
            if (i != 0) {
                return false;
            }
        }
        //û��ѡ�񱣴�·����Ĭ��·����ʱ�ļ���Ϊ
        String command_cp = oldFile.getAbsolutePath() + " " + fileName; //copy�������
        System.out.println(command_cp);
        Runtime rt = Runtime.getRuntime();
        try {
            @SuppressWarnings("unused")
			final Process ps;
			ps = rt.exec("cmd /c copy " + command_cp);
            state.setForeground(Color.blue);
            state.setText("���سɹ�");
            return true;
        } catch (IOException ex) {
            rt.gc();
            //ex1.printStackTrace();
            if (!temp.canWrite()) {
                state.setText("�ļ�����ʧ�ܣ��ļ�Ϊֻ��");
            } else {
                state.setText("����ʧ��,����ϵ��ΰ");
            }
            state.setForeground(Color.red);
            JOptionPane.showMessageDialog(this, temp.getName() + "�ļ�����ʧ��",
                                          "����",
                                          JOptionPane.ERROR_MESSAGE);

            return false;

        }
    }

//����ļ�����·��
    public void choosePath_actionPerformed(ActionEvent e) {
        JFileChooser chooseFolder = new JFileChooser();
        FileFilter ff = new FileFolder();
        chooseFolder.addChoosableFileFilter(ff);
        chooseFolder.setMultiSelectionEnabled(false);
        chooseFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int k = chooseFolder.showOpenDialog(this);
        if (k == JFileChooser.APPROVE_OPTION) {
            toFolder = chooseFolder.getSelectedFile();
            //�õ����ļ�����·��
            copyPath.setText(toFolder.getPath());
        }
        this.requestFocus(true);
    }

//ʵ�ֲ˵�ɾ������
    public void del_actionPerformed(ActionEvent e) {
        delete();
    }

//ɾ������
    private void delete() throws HeadlessException {
        int selectRows[] = songTable.getSelectedRows();
        if (selectRows.length <= 0) {
            JOptionPane.showMessageDialog(this, "��ѡ����Ҫɾ������", "����",
                                          JOptionPane.ERROR_MESSAGE);
            return;

        }
        firstRow = selectRows[0];
        lastRow = selectRows[selectRows.length - 1];
        int i = JOptionPane.showConfirmDialog(this,
                                              "ѡ'��'��ɾ��Դ�ļ�,'��'ֻɾ���˱��е��ļ���¼,'ȡ��'��ɾ��",
                                              "��ѡ��ɾ����ʽ",
                                              JOptionPane.YES_NO_CANCEL_OPTION);
        if (i == 0) {
            //ѭ��ɾ���ļ�
            for (int row = firstRow; row <= lastRow; row++) {
                String path = (String) model.getValueAt(row, 1) + "/" +
                              (String) model.getValueAt(row, 0);
                File f = new File(path);
                if (f.exists()) {
                    if (f.delete()) {
                        state.setForeground(Color.blue);
                        state.setText("�ļ��ɹ�ɾ��");
                        model.removeRow(row); //�ɹ�ɾ�����ٴ�ģ����ɾ��
                        //�����ݿ���ɾ��{
                        if (!new Dao().del(f.getName())) {
                            state.setForeground(Color.red);
                            state.setText("�ļ��ɹ�ɾ���������ݿ���δ��ɾ��");
                        }
                    } else {
                        state.setForeground(Color.red);
                        state.setText("ɾ��ʧ�ܣ����������");
                    }
                }
            }
        } else if (i == 1) {
            for (int row = firstRow; row <= lastRow; row++) {
                state.setForeground(Color.blue);
                state.setText("��¼�ɹ�ɾ��");
                model.removeRow(row); //�ɹ�ɾ�����ٴ�ģ����ɾ��
                //�����ݿ���ɾ��
                if (!new Dao().del((String) model.getValueAt(row, 0))) {
                    state.setForeground(Color.red);
                    state.setText("��¼�ɹ�ɾ���������ݿ���δ��ɾ��");
                }

            }
        }
        state.setForeground(Color.magenta);
    }


    //������ť����
    public void sure_actionPerformed(ActionEvent e) {
        String key = search.getText();
        if (key.equals("�����ؼ���")) {
            JOptionPane.showMessageDialog(this, "û�����������ؼ���");
            return;
        }
        makeSongTable(new Dao().getWhatyouWant(key));
        state.setText("�������� " + model.getRowCount() + " ��");
        this.requestFocus(true); //ʹ�����ý���,��ִ�п�ݼ�����
    }

//ʹ��˵��
    public void jMenuItem1_actionPerformed(ActionEvent e) {
        new HowToUse();
    }

//�س�����
    public void search_keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            String key = search.getText();
            if (key.equals("�����ؼ���")) {
                JOptionPane.showMessageDialog(this, "û�����������ؼ���");
                return;
            }
            makeSongTable(new Dao().getWhatyouWant(key));
            state.setText("�������� " + model.getRowCount() + " ��");
            this.requestFocus(true); //ʹ�����ý���,��ִ�п�ݼ�����
        }
    }

//�������¼�,��ݼ���������
    public void this_keyTyped(KeyEvent e) {
        Dao dao = new Dao();
        int len = model.getRowCount();
        char keyChar = e.getKeyChar();
        int row = 0;
        int hot = 0;
        File f;
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < len; i++) {
                f = new File((String) model.getValueAt(i, 1) + "\\" +
                             (String) model.getValueAt(i, 0));
                if (!copy("", f)) {
                    break;
                }
                //���سɹ����Ҫ�����ȶ�
                dao.updateHot(f.getName());
                //model����
                hot = Integer.parseInt((String) model.getValueAt(i, 3)) + 1;
                model.setValueAt(String.valueOf(hot), i, 3);
                if (i > 1) {
                    model.moveRow(i, i, i - 1); //�ȵ����ӣ���������һ��
                }
            }
        }
        switch (keyChar) {
        case '1':
            row = 0;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                System.out.println(f.getAbsolutePath());
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            break;
        case '2':
            row = 1;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '3':
            row = 2;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '4':
            row = 3;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '5':
            row = 4;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '6':
            row = 5;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '7':
            row = 6;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '8':
            row = 7;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '9':
            row = 8;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            break;
        case '0':
            row = 9;
            if (len < row) {
                return;
            } else {
                f = new File((String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0));
                copy("", f);
            }
            dao.updateHot(f.getName());
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��

            //model����
            hot = Integer.parseInt((String) model.getValueAt(row, 3)) + 1;
            model.setValueAt(String.valueOf(hot), row, 3);
            model.moveRow(row, row, row - 1); //�ȵ����ӣ���������һ��
            break;
        }

    }

//�������
    public void jMenuItem2_actionPerformed(ActionEvent e) {
        if (new Dao().delAll()) {
            model.setDataVector(new String[0][0], null); //��ģ��Ϊ��
            state.setForeground(Color.BLUE);
            state.setText("���ݿ���ճɹ�");
        } else {
            state.setForeground(Color.red);
            state.setText("���ݿ����ʧ��,��ΰΰ��ϵ");
        }
    }

//���¼������ݿ�����---ˢ��
    public void jMenuItem3_actionPerformed(ActionEvent e) {
        makeSongTable(new Dao().getDate());
    }

    //�Ҽ��˵�����
    public void jMenuItem8_actionPerformed(ActionEvent e) {
        Runtime rt = Runtime.getRuntime();
        int row = songTable.getSelectedRow();
        String command = "" + (String) model.getValueAt(row, 1) + "\\" +
                         (String) model.getValueAt(row, 0);
        try {
            rt.exec("cmd /c" + command);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "�ļ�����ʧ�ܣ�������", "����",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    //�Ҽ��˵�ɾ��
    public void jMenuItem4_actionPerformed(ActionEvent e) {
        delete();
    }

    //�Ҽ� �˵������ȶ�
    public void jMenuItem5_actionPerformed(ActionEvent e) {
        makeSongTable(new Dao().getDate());
    }

    //�Ҽ� �˵������ļ���
    public void jMenuItem6_actionPerformed(ActionEvent e) {
        makeSongTable(new Dao().getDateOrDerByName());
    }

    //�Ҽ��˵����
    public void jMenuItem7_actionPerformed(ActionEvent e) {
        if (new Dao().delAll()) { //ִ��ɾ������
            model.setDataVector(new String[0][0], null); //��ģ��Ϊ��
            state.setForeground(Color.BLUE);
            state.setText("���ݿ���ճɹ�");
        } else {
            state.setForeground(Color.red);
            state.setText("���ݿ����ʧ��,��ΰΰ��ϵ");
        }
    }

//�������ź��Ҽ��˵��ĵ���
    public void songTable_mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightClick.show(songTable, e.getX(), e.getY());
            rightClick.setVisible(true);
        }
    }

//ѡ�и���ֱ�Ӱ��ո����ʵ�ֲ���
    public void songTable_keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            Runtime rt = Runtime.getRuntime();
            int row = songTable.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "û��ѡ�����");
                return;
            }
            String command = "" + (String) model.getValueAt(row, 1) + "\\" +
                             (String) model.getValueAt(row, 0);
            try {
                rt.exec("cmd /c" + command);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "�ļ�����ʧ�ܣ�������", "����",
                                              JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}


class MainFrame_jMenuItem8_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem8_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem8_actionPerformed(e);
    }
}


class MainFrame_jMenuItem7_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem7_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem7_actionPerformed(e);
    }
}


class MainFrame_songTable_mouseAdapter extends MouseAdapter {
    private MainFrame adaptee;
    MainFrame_songTable_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.songTable_mouseClicked(e);
    }
}


class MainFrame_songTable_keyAdapter extends KeyAdapter {
    private MainFrame adaptee;
    MainFrame_songTable_keyAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void keyTyped(KeyEvent e) {
        adaptee.songTable_keyTyped(e);
    }
}


class MainFrame_jMenuItem6_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem6_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem6_actionPerformed(e);
    }
}


class MainFrame_jMenuItem5_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem5_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem5_actionPerformed(e);
    }
}


class MainFrame_jMenuItem4_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem4_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem4_actionPerformed(e);
    }
}


class MainFrame_jMenuItem3_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem3_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem3_actionPerformed(e);
    }
}


class MainFrame_jMenuItem2_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem2_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem2_actionPerformed(e);
    }
}


class MainFrame_this_keyAdapter extends KeyAdapter {
    private MainFrame adaptee;
    MainFrame_this_keyAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void keyTyped(KeyEvent e) {
        adaptee.this_keyTyped(e);
    }
}


class MainFrame_jMenuItem1_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem1_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class MainFrame_sure_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_sure_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.sure_actionPerformed(e);
    }
}


class MainFrame_del_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_del_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.del_actionPerformed(e);
    }
}


class MainFrame_choosePath_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_choosePath_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.choosePath_actionPerformed(e);
    }
}


class MainFrame_addFile_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_addFile_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addFile_actionPerformed(e);
    }
}


class MainFrame_search_focusAdapter extends FocusAdapter {
    private MainFrame adaptee;
    MainFrame_search_focusAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.search_focusGained(e);
    }
}


class MainFrame_search_keyAdapter extends KeyAdapter {
    private MainFrame adaptee;
    MainFrame_search_keyAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void keyTyped(KeyEvent e) {
        adaptee.search_keyTyped(e);
    }
}


class MainFrame_addFolder_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_addFolder_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addFolder_actionPerformed(e);
    }
}


class MainFrame_jMenuFileExit_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_jMenuFileExit_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class MainFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_jMenuHelpAbout_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}


class FileFile extends FileFilter {
    //�����ļ�������ֻ��Ϊ�ļ���
    public boolean accept(File f) {
        boolean bool = false;
        if (f.isDirectory() || f.getPath().endsWith(".mp3") ||
            f.getPath().endsWith(".wma") || f.getPath().endsWith(".wav")) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    //����˵���ļ�������Ϣ
    public String getDescription() {
        return "mp3,wma,wav";
    }
}


class FileFolder extends FileFilter {
    //�����ļ�������ֻ��Ϊ�ļ���
    public boolean accept(File f) {
        boolean bool = false;
        if (f.isDirectory()) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    //����˵���ļ�������Ϣ
    public String getDescription() {
        return "ѡ���ļ���";
    }
}


class FileFilt implements java.io.FileFilter {
    //�����ļ�������Ϊ��������
    public boolean accept(File f) {
        boolean bool = false;
        if (f.isFile()) {
            if (f.getName().endsWith(".mp3") || f.getName().endsWith(".wma") ||
                f.getName().endsWith(".wav")) {
                bool = true;
            } else {
                bool = false;
            }
        } else {
            bool = false;
        }
        return bool;
    }
}
