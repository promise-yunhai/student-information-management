package Chuangkou;

import Table.seek2;

import javax.swing.*;

import java.awt.event.*;
public class zhujiemian2  {
	public static void main(String[] args) {
      
	}
public  void dex() {
    	
	JFrame f = new JFrame("ѧ���ɼ�����ϵͳ");//���ô���
    f.setSize(800, 600);
    f.setLocation(100, 100);
    f.setLayout(null);
    
    JLabel l = new JLabel();
    
    //ImageIcon i = new ImageIcon("src/Chuangkou/3.jpg");//���ͼƬ
    //l.setIcon(i);
    //l.setBounds(0, 31, i.getIconWidth(), i.getIconHeight());

    JButton c = new JButton("�鿴ѧ���ɼ���Ϣ");
    JButton a2 = new JButton("�˳�ϵͳ");
    a2.setBounds(333, 1, 140, 30);
    c.setBounds(111, 1, 140, 30);
    

    // ����ť ���� ����

    c.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	seek2 add2 = new seek2();
        	add2.de3();
         
        }
    });
    a2.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	f.dispose();     
        }
    });




    f.add(l);//��ť�ӽ�ȥ

    f.add(c);
    f.add(a2);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�

    f.setVisible(true);//�ɼ�
}

	} 