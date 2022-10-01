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
import javax.swing.ListSelectionModel;
 





import test.scoreDAO;
import test.score;
 
public class seek  {
	
public void de3() {
    
 
        JFrame f = new JFrame("查找界面");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        final ModelDAO htm = new ModelDAO();

        final JTable t = new JTable(htm);
  
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        t.getSelectionModel().setSelectionInterval(0, 0);
        JPanel p = new JPanel();
        
        final JLabel lnumber = new JLabel("学号");
        final JTextField tfnumber = new JTextField("");
        
        JButton bAdd = new JButton("查找");
        
        tfnumber.setPreferredSize(new Dimension(120, 30));

        JButton a5 = new JButton("返回");
        p.add(a5);
        a5.addActionListener(new ActionListener() {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        
        p.add(lnumber);
        p.add(tfnumber);
        p.add(bAdd);
 
    
        bAdd.addActionListener(new ActionListener() {
 

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
        
                int a = dao.seek(h.number);
                t.getSelectionModel().setSelectionInterval(a-1, a-1);
            
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