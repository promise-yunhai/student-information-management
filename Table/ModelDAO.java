package Table;

import java.util.List;
 
import javax.swing.table.AbstractTableModel;
 
import test.scoreDAO;
import test.score;
 
public class ModelDAO extends AbstractTableModel {
 
    String[] columnNames = new String[] { "姓名", "班级", "学号", "语文成绩", "数学成绩", "英语成绩" };
 
    
 
    public List<score> scores = new scoreDAO().list();
 

    public int getRowCount() {
       
        return scores.size();
    }
 
    public int getColumnCount() {
        
        return columnNames.length;
    }
 
    public String getColumnName(int columnIndex) {
      
        return columnNames[columnIndex];
    }
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        score h = scores.get(rowIndex);
        if (0 == columnIndex)
            return h.name;
        if (1 == columnIndex)
            return h.myclass;
        if (2 == columnIndex)
            return h.number;
        if (3 == columnIndex)
            return h.Chinesegrade;
        if (4 == columnIndex)
            return h.Mathgrade;
        if (5 == columnIndex)
            return h.Englishgrade;
        return null;
    }
 
}