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
 
public class delate  {
	
public void de2() {
    
 
        JFrame f = new JFrame("ɾ������");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        final ModelDAO htm = new ModelDAO();
 
        final JTable t = new JTable(htm);
    
        JPanel p = new JPanel();
        
        final JLabel lnumber = new JLabel("ѧ��");
        final JTextField tfnumber = new JTextField("");
        tfnumber.setText("");
        
        JButton bAdd = new JButton("ɾ��");
        
        tfnumber.setPreferredSize(new Dimension(120, 30));

        
        JButton a5 = new JButton("����");
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
        

        // Ϊ���Ӱ�ť��Ӽ���
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String name = tfnumber.getText();
                if(0==name.length()){
                    JOptionPane.showMessageDialog(f, "�������");
                    tfnumber.grabFocus();
                    
                    return;
                }

                scoreDAO dao = new scoreDAO();
 
            
                score h = new score();
                h.number= Integer.parseInt(tfnumber.getText());
              
                dao.delete(h.number);
 
           
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