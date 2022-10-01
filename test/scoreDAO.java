package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
import test.score;

public class scoreDAO implements DAO{
  
    public scoreDAO() {
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1314520");
    }
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from 学生成绩信息";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(score score1) {
  
        String sql = "insert into 学生成绩信息 values(?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, score1.name);
            ps.setString(2, score1.myclass);
            ps.setInt(3, score1.number);
            ps.setInt(4,score1.Chinesegrade);
            ps.setInt(5,score1.Mathgrade);
            ps.setInt(6,score1.Englishgrade);
  
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int number = rs.getInt(1);
                score1.number = number;
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    public void add2(String m ,int n) {
    	  
        String sql = "insert into 用户登录信息 values(?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, m);
            ps.setInt(2, n);
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int number = rs.getInt(1);
                n = number;
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(score score1) {
  
        String sql = "update 学生成绩信息 set name= ?, myclass = ? , Chinesegrade = ? , Mathgrade = ?, Englishgrade = ? where number = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, score1.name);
            ps.setString(2, score1.myclass);
            ps.setInt(3,score1.Chinesegrade);
            ps.setInt(4,score1.Mathgrade);
            ps.setInt(5,score1.Englishgrade);
            ps.setInt(6, score1.number);
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int number) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from 学生成绩信息 where number = " + number;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public score get(int number) {
        score score1 = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from 学生成绩信息 where number = " + number;
  
            ResultSet rs = s.executeQuery(sql);
  
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
    public int seek(int number) {
        score score1 = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from (select *,row_number() over (order by [number]) 'x' from 学生成绩信息) as asd where number=" + number;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                score1 = new score();
                
                int Chinesegrade = rs.getInt("x");
                score1.number = Chinesegrade;
                
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return score1.number;
    }
  
    public List<score> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<score> list(int start, int count) {
        List<score> scores = new ArrayList<score>();
  
        String sql = "SELECT * FROM 学生成绩信息 order by number  offset ? rows fetch next ? rows only ";
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                score score1 = new score();
                String name = rs.getString("name");
                String myclass = rs.getString("myclass");
                int number= rs.getInt("number");
                int Chinesegrade = rs.getInt("Chinesegrade");
                int Mathgrade = rs.getInt("Mathgrade");
                int Englishgrade= rs.getInt("Englishgrade");
                
                score1.name = name;
                score1.myclass = myclass;
                score1.Chinesegrade = Chinesegrade;
                score1.Mathgrade = Mathgrade;
                score1.Englishgrade = Englishgrade;
                score1.number = number;
                scores.add(score1);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return scores;
    }
  
}