package Chuangkou;

import Table.seek2;

import javax.swing.*;

import java.awt.event.*;
public class zhujiemian2  {
	public static void main(String[] args) {
      
	}
public  void dex() {
    	
	JFrame f = new JFrame("学生成绩管理系统");//设置窗口
    f.setSize(800, 600);
    f.setLocation(100, 100);
    f.setLayout(null);
    
    JLabel l = new JLabel();
    
    //ImageIcon i = new ImageIcon("src/Chuangkou/3.jpg");//添加图片
    //l.setIcon(i);
    //l.setBounds(0, 31, i.getIconWidth(), i.getIconHeight());

    JButton c = new JButton("查看学生成绩信息");
    JButton a2 = new JButton("退出系统");
    a2.setBounds(333, 1, 140, 30);
    c.setBounds(111, 1, 140, 30);
    

    // 给按钮 增加 监听

    c.addActionListener(new ActionListener() {

        // 当按钮被点击时，就会触发 ActionEvent事件
        // actionPerformed 方法就会被执行
        public void actionPerformed(ActionEvent e) {
        	seek2 add2 = new seek2();
        	add2.de3();
         
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

    f.add(c);
    f.add(a2);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭

    f.setVisible(true);//可见
}

	} 