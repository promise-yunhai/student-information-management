package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  

import test.score;
   
public class idear {
   
    public static score get(int number) {
        score score1 = null;
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1314520");
            Statement s = c.createStatement();) {
 
            String sql = "select * from 学生成绩信息 where number = " + number;
   
            ResultSet rs = s.executeQuery(sql);
   
            // 因为number是唯一的，ResultSet最多只能有一条记录
            // 所以使用if代替while
            if (rs.next()) {
                score1 = new score();
                
                String name = rs.getString("name");
                String myclass = rs.getString("myclass");
                int Chinesegrade = rs.getInt("Chinesegrade");
                int Mathgrade = rs.getInt("Mathgrade");
                int Englishgrade= rs.getInt("Englishgrade");
                
                score1.name = name;
                score1.myclass = myclass;
                score1.Chinesegrade = Chinesegrade;
                score1.Mathgrade = Mathgrade;
                score1.Englishgrade = Englishgrade;
                score1.number = number;
            }
   
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        return score1;
   
    }
   
    public static void main(String[] args) {
           
    	score h = get(2016403211);
        System.out.println(h.name );
        System.out.println(h.myclass );
        System.out.println(h.number );
        System.out.println(h.Chinesegrade );
        System.out.println(h.Mathgrade );
        System.out.println(h.Englishgrade );
   
    }
}