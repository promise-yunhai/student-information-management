package Chuangkou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
  
public class denglv {
		public static void main(String[] args) {
	      
		}   
public  void denglv2() {
    	
        JFrame f = new JFrame("��¼");
        f.setSize(370, 330);
        f.setLocation(200, 200);
        f.setLayout(null);
  
        JPanel pNorth = new JPanel();
        pNorth.setBounds(10,150, 300, 100);
         
        JLabel lName = new JLabel("�˺ţ�");
        lName.setBounds(10, 10, 10, 20);
        JTextField tfName = new JTextField("");
        tfName.setText("");
        tfName.setPreferredSize(new Dimension(80, 30));
  
        JLabel lPassword = new JLabel("���룺");
        JPasswordField tfPassword = new JPasswordField("");
        tfPassword.setText("");
        tfPassword.setPreferredSize(new Dimension(80, 30));
  
        pNorth.add(lName);
        pNorth.add(tfName);
        pNorth.add(lPassword);
        pNorth.add(tfPassword);
        
        JLabel l = new JLabel();
        //ImageIcon i = new ImageIcon("src/Chuangkou/4.png");//���ͼƬ
        //l.setIcon(i);
       // l.setBounds(0, 1, i.getIconWidth(), i.getIconHeight());
        l.setVisible(true);
        f.add(l);
        
        JButton b= new JButton("��ʦ��½");
        b.setBounds(130, 200, 100, 30);
        f.add(b);
        JButton c= new JButton("ѧ����½");
        c.setBounds(130, 240, 100, 30);
        f.add(c);
        b.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
 
                String name = tfName.getText();
                String password = new String( tfPassword.getPassword());
                if(0==name.length()){
                    JOptionPane.showMessageDialog(f, "�˺Ų���Ϊ��");
                    tfName.grabFocus();
                    
                    return;
                }
                if(0==password.length()){
                    JOptionPane.showMessageDialog(f, "���벻��Ϊ��");
                    tfPassword.grabFocus();
                    return;
                }
                 
                if(check(name, password))
                {
                    JOptionPane.showMessageDialog(f, "��½�ɹ�");
                    zhujiemian zhujiemian1 = new zhujiemian();
                    f.dispose();
                    zhujiemian1.de2();

                }
                else
                    JOptionPane.showMessageDialog(f, "�������");
                 
            }
        });
        
        c.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
 
                String name = tfName.getText();
                String password = new String( tfPassword.getPassword());
                if(0==name.length()){
                    JOptionPane.showMessageDialog(f, "�˺Ų���Ϊ��");
                    tfName.grabFocus();
                    
                    return;
                }
                if(0==password.length()){
                    JOptionPane.showMessageDialog(f, "���벻��Ϊ��");
                    tfPassword.grabFocus();
                    return;
                }
                 
                if(check2(name, password))
                {
                    JOptionPane.showMessageDialog(f, "��½�ɹ�");
                    f.dispose();
                    zhujiemian2 zhujiemian1 = new zhujiemian2();
                    zhujiemian1.dex();

                }
                else
                    JOptionPane.showMessageDialog(f, "�������");
                 
            }
        });
         
        f.add(pNorth);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
     
    public static boolean check(String name, String password) {
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        boolean result = false;
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "1314520");
                Statement s = c.createStatement();
                  
                ) {
    
            String sql = "select * from �û���¼��Ϣ where name = '" + name +"' and password = '" + password+"'";
               
          
            ResultSet rs = s.executeQuery(sql);
               
            if(rs.next())
                result = true;
              
        } catch (SQLException e) {
      
            e.printStackTrace();
        }
         
        return result;
    
    }
    public static boolean check2(String name, String password) {
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        boolean result = false;
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "1314520");
                Statement s = c.createStatement();
                  
                ) {
    
            String sql = "select * from �û���¼��Ϣ1 where name = '" + name +"' and password = '" + password+"'";
               

            ResultSet rs = s.executeQuery(sql);
               
            if(rs.next())
                result = true;
              
        } catch (SQLException e) {

            e.printStackTrace();
        }
         
        return result;
    
    }
}