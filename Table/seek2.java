package Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
 




import test.scoreDAO;
import test.score;
 
public class seek2  {
	
public void de3() {
    
 
        JFrame f = new JFrame("查找界面");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 

        JPanel p = new JPanel();
        
        final JLabel lnumber = new JLabel("学号");
        final JTextField tfnumber = new JTextField("");
        
        JButton bAdd = new JButton("查找");
        JButton a5 = new JButton("返回");
        
        tfnumber.setPreferredSize(new Dimension(100, 30));

        p.add(lnumber);
        p.add(tfnumber);
        p.add(bAdd);
        p.add(a5);
        a5.addActionListener(new ActionListener() {
        	 
      
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        // 为增加按钮添加监听
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String name = tfnumber.getText();
                if(0==name.length()){
                    JOptionPane.showMessageDialog(f, "输入错误！");
                    tfnumber.grabFocus();
                    
                    return;
                }
 
                scoreDAO dao = new scoreDAO();
                

                score h = new score();
                h.number= Integer.parseInt(tfnumber.getText());

                h = dao.get(h.number);
                String a = h.name;
                String b = h.myclass;
                String c="";
                c=String.valueOf(h.number);
                String d="";
                d=String.valueOf(h.Chinesegrade);
                String m="";
                m=String.valueOf(h.Mathgrade);
                String g="";
                g=String.valueOf(h.Englishgrade);    
                
                String[] columnNames = new String[] { "姓名", "班级", "学号", "语文成绩", "数学成绩", "英语成绩" };
                String[][] heros = new String[][] { { "a", "b", "c", "d", "m", "g" } };
                heros[0][0]=a;
                heros[0][1]=b;
                heros[0][2]=c;
                heros[0][3]=d;
                heros[0][4]=m;
                heros[0][5]=g;
                JTable t = new JTable(heros, columnNames);

                // 根据t创建 JScrollPane
                JScrollPane sp = new JScrollPane(t);
                f.add(sp, BorderLayout.CENTER);
                f.setVisible(true);
               
            }
        });
  

        
        f.add(p, BorderLayout.NORTH);

 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}