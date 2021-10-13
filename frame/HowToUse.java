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
        jLabel1.setFont(new java.awt.Font("������", Font.BOLD, 18));
        jLabel1.setBorder(BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("���ʹ�ý���");
        jLabel8.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jLabel8.setBorder(BorderFactory.createEtchedBorder());
        jLabel8.setText("");
        jButton1.setBackground(Color.pink);
        jButton1.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jButton1.setText("����");
        jButton1.addActionListener(new WhoToUse_jButton1_actionAdapter(this));
        jLabel7.setFont(new java.awt.Font("������", Font.PLAIN, 13));
        jLabel7.setBorder(BorderFactory.createEtchedBorder());
        jLabel5.setFont(new java.awt.Font("������", Font.PLAIN, 13));
        jLabel5.setBorder(BorderFactory.createEtchedBorder());
        jLabel6.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jLabel6.setBorder(BorderFactory.createEtchedBorder());
        jLabel4.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jLabel4.setBorder(BorderFactory.createEtchedBorder());
        jLabel3.setFont(new java.awt.Font("������", Font.PLAIN, 15));
        jLabel3.setBorder(BorderFactory.createEtchedBorder());
        jLabel2.setFont(new java.awt.Font("������", Font.PLAIN, 15));
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
        jLabel7.setText("  1.ʹ�ñ����֮ǰ���Ȱ�װoffice Access���ݿ⣬�����²�����������Դ");
        jLabel6.setText("    ->Access Driver->���->����Դ��:music->ѡ��->ѡ�����ݿ�->ȷ��");
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        jLabel5.setText(
                "  2.�򿪿������->������->����Դ (ODBC)->ϵͳDSN->���->ѡ��Microsoft->");
        this.getContentPane().add(jLabel4);
        jLabel4.setText("  3.��Ӹ���,ѡ������Ŀ¼��������.����ؼ���ֱ�Ӱ��س���ִ������");
        this.getContentPane().add(jLabel3);
        jLabel3.setText("  4.�ѳ�����󰴻س��ɽ��ֲ��������ص���ѡĿ¼,��1-9,0�����ض�");
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
        jLabel2.setText("    Ӧ����ǰ1-9,10����,�����״̬����ʾ�Ƿ�ɹ�����");
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
