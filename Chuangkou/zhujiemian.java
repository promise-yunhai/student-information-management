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
    	
	JFrame f = new JFrame("学生成绩管理系统");//设置窗口
    f.setSize(800, 600);
    f.setLocation(100, 100);
    f.setLayout(null);
    
    JLabel l = new JLabel();
    
    //ImageIcon i = new ImageIcon("src/Chuangkou/3.jpg");//添加图片
    //l.setIcon(i);
    //l.setBounds(0, 31, i.getIconWidth(), i.getIconHeight());

    JButton a = new JButton("增加学生成绩信息");//按钮名称
    JButton b = new JButton("删除学生成绩信息");
    JButton c = new JButton("查看学生成绩信息");
    JButton d = new JButton("修改学生成绩信息");
    JButton a1 = new JButton("管理用户");
    JButton a2 = new JButton("退出系统");
    
    a.setBounds(0, 1, 140, 30);//按钮位置和大小
    b.setBounds(141, 1, 140, 30);
    c.setBounds(282, 1, 140, 30);
    d.setBounds(423, 1, 140, 30);
    a2.setBounds(563, 1, 100, 30);
    a1.setBounds(664, 1, 100, 30);

    // 给按钮 增加 监听
    a.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	add add1 = new add();
        	add1.de1();
        }
    });
    b.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	delate add1 = new delate();
        	add1.de2();
         
        }
    });
    c.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	seek add2 = new seek();
        	add2.de3();
         
        }
    });
    d.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	update add2 = new update(); 
        	add2.de4();
         
        }
    });
    a2.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	f.dispose();     
        }
    });


    f.add(l);//按钮加进去
    f.add(a);
    f.add(b);
    f.add(c);
    f.add(d);
    f.add(a2);
    
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭

    f.setVisible(true);//可见
}

	} 