package Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 



import test.scoreDAO;
import test.score;
 
public class update  {
	
public void de4() {
    
 
        JFrame f = new JFrame("修改界面");
        f.setSize(800, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        final ModelDAO htm = new ModelDAO();
 
        final JTable t = new JTable(htm);
       
        JPanel p = new JPanel();
 
        final JLabel lName = new JLabel("姓名");
        final JTextField tfName = new JTextField("");
        final JLabel lmyclass = new JLabel("班级");
        final JTextField tfmyclass = new JTextField("");
        
        final JLabel lnumber = new JLabel("学号");
        final JTextField tfnumber = new JTextField("");
        final JLabel lChinesegrade = new JLabel("语文成绩");
        final JTextField tfChinesegrade = new JTextField("");
        
        final JLabel lMathgrade = new JLabel("数学成绩");
        final JTextField tfMathgrade = new JTextField("");
        final JLabel lEnglishgrade = new JLabel("英语成绩");
        final JTextField tfEnglishgrade = new JTextField("");
        
        JButton bAdd = new JButton("修改");
        tfName.setPreferredSize(new Dimension(40, 30));
        tfmyclass.setPreferredSize(new Dimension(40, 30));
        tfnumber.setPreferredSize(new Dimension(100, 30));
        tfChinesegrade.setPreferredSize(new Dimension(40, 30));
        tfMathgrade.setPreferredSize(new Dimension(40, 30));
        tfEnglishgrade.setPreferredSize(new Dimension(40, 30));
 
        p.add(lName);
        p.add(tfName);
        p.add(lmyclass);
        p.add(tfmyclass);
        
        p.add(lnumber);
        p.add(tfnumber);
        p.add(lChinesegrade);
        p.add(tfChinesegrade);
        
        p.add(lMathgrade);
        p.add(tfMathgrade);
        p.add(lEnglishgrade);
        p.add(tfEnglishgrade);
        p.add(bAdd);
        
        JButton a5 = new JButton("返回");
        p.add(a5);
        a5.addActionListener(new ActionListener() {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        
 
        // 为增加按钮添加监听
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
 
            	
            	 String name = tfName.getText();
                 String name1 = tfmyclass.getText();
                 String name2 = tfnumber.getText();
                 String name3 = tfChinesegrade.getText();
                 String name4 = tfMathgrade.getText();
                 String name5 = tfEnglishgrade.getText();
                 if(0==name.length()||0==name1.length()||0==name2.length()||0==name3.length()||0==name4.length()||0==name5.length()){
                     JOptionPane.showMessageDialog(f, "输入错误！");
                     tfnumber.grabFocus();
                     
                     return;
                 }
                scoreDAO dao = new scoreDAO();
 
  
                score h = new score();
                h.name = tfName.getText();
                h.myclass= tfmyclass.getText();
                h.number= Integer.parseInt(tfnumber.getText());
                h.Chinesegrade= Integer.parseInt(tfChinesegrade.getText());
                h.Mathgrade= Integer.parseInt(tfMathgrade.getText());
                h.Englishgrade= Integer.parseInt(tfnumber.getText());
 
               

                dao.update(h);
 

                htm.scores = dao.list();

 
                t.updateUI();
            }
        });
 
        JScrollPane sp = new JScrollPane(t);
 
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}