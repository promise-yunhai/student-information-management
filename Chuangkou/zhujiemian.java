package Chuangkou;

import Table.add;
import Table.delate;
import Table.seek;
import Table.update;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
public class zhujiemian  {
	public static void main(String[] args) {
      
	}
public  void de2() {
    	
	JFrame f = new JFrame("ѧ���ɼ�����ϵͳ");//���ô���
    f.setSize(800, 600);
    f.setLocation(100, 100);
    f.setLayout(null);
    
    JLabel l = new JLabel();
    
    //ImageIcon i = new ImageIcon("src/Chuangkou/3.jpg");//���ͼƬ
    //l.setIcon(i);
    //l.setBounds(0, 31, i.getIconWidth(), i.getIconHeight());

    JButton a = new JButton("����ѧ���ɼ���Ϣ");//��ť����
    JButton b = new JButton("ɾ��ѧ���ɼ���Ϣ");
    JButton c = new JButton("�鿴ѧ���ɼ���Ϣ");
    JButton d = new JButton("�޸�ѧ���ɼ���Ϣ");
    JButton a1 = new JButton("�����û�");
    JButton a2 = new JButton("�˳�ϵͳ");
    
    a.setBounds(0, 1, 140, 30);//��ťλ�úʹ�С
    b.setBounds(141, 1, 140, 30);
    c.setBounds(282, 1, 140, 30);
    d.setBounds(423, 1, 140, 30);
    a2.setBounds(563, 1, 100, 30);
    a1.setBounds(664, 1, 100, 30);

    // ����ť ���� ����
    a.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	add add1 = new add();
        	add1.de1();
        }
    });
    b.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	delate add1 = new delate();
        	add1.de2();
         
        }
    });
    c.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	seek add2 = new seek();
        	add2.de3();
         
        }
    });
    d.addActionListener(new ActionListener() {

        // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
        // actionPerformed �����ͻᱻִ��
        public void actionPerformed(ActionEvent e) {
        	update add2 = new update(); 
        	add2.de4();
         
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
    f.add(a);
    f.add(b);
    f.add(c);
    f.add(d);
    f.add(a2);
    
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�

    f.setVisible(true);//�ɼ�
}

	} 