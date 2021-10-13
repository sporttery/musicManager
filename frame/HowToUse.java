package frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToUse extends JFrame {
    GridLayout gridLayout1 = new GridLayout(15,1);
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JPanel jPanel1 = new JPanel();
    JButton jButton1 = new JButton();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    public HowToUse() {
        try {
            jbInit();
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(gridLayout1);
        jLabel1.setFont(new java.awt.Font("新宋体", Font.BOLD, 18));
        jLabel1.setBorder(BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("软件使用介绍");
        jLabel8.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jLabel8.setBorder(BorderFactory.createEtchedBorder());
        jLabel8.setText("");
        jButton1.setBackground(Color.pink);
        jButton1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jButton1.setText("返回");
        jButton1.addActionListener(new WhoToUse_jButton1_actionAdapter(this));
        jLabel7.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jLabel7.setBorder(BorderFactory.createEtchedBorder());
        jLabel5.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jLabel5.setBorder(BorderFactory.createEtchedBorder());
        jLabel6.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jLabel6.setBorder(BorderFactory.createEtchedBorder());
        jLabel4.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jLabel4.setBorder(BorderFactory.createEtchedBorder());
        jLabel3.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jLabel3.setBorder(BorderFactory.createEtchedBorder());
        jLabel2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 15));
        jLabel2.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBackground(Color.pink);
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().setBackground(Color.pink);
        jLabel9.setBorder(BorderFactory.createEtchedBorder());
        jLabel9.setText("");
        jLabel10.setBorder(BorderFactory.createEtchedBorder());
        jLabel10.setText("");
        jLabel11.setBorder(BorderFactory.createEtchedBorder());
        jLabel11.setText("");
        jLabel12.setBorder(BorderFactory.createEtchedBorder());
        jLabel12.setText("");
        jLabel13.setBorder(BorderFactory.createEtchedBorder());
        jLabel13.setText("");
        jLabel14.setBorder(BorderFactory.createEtchedBorder());
        jLabel14.setText("");
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel7);
        jLabel7.setText("  1.使用本软件之前请先安装office Access数据库，按以下步骤配置数据源");
        jLabel6.setText("    ->Access Driver->完成->数据源名:music->选择->选择数据库->确定");
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        jLabel5.setText(
                "  2.打开控制面板->管理工具->数据源 (ODBC)->系统DSN->添加->选择Microsoft->");
        this.getContentPane().add(jLabel4);
        jLabel4.setText("  3.添加歌曲,选择下载目录即可搜索.输入关键字直接按回车即执行搜索");
        this.getContentPane().add(jLabel3);
        jLabel3.setText("  4.搜出结果后按回车可将分部歌曲下载到所选目录,按1-9,0将下载对");
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(jLabel14);
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(jPanel1);
        jPanel1.add(jButton1);
        jLabel2.setText("    应的最前1-9,10歌曲,下面的状态将显示是否成功下载");
        this.setBounds(200,150,599,462);
        this.setVisible(true);
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        this.removeNotify();
    }
}


class WhoToUse_jButton1_actionAdapter implements ActionListener {
    private HowToUse adaptee;
    WhoToUse_jButton1_actionAdapter(HowToUse adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
