package test;

import java.util.List;
 
import test.score;
  
public interface DAO{
    //增加
    public void add(score score1);
    //修改
    public void update(score score1);
    //删除
    public void delete(int number);
    //获取
    public score get(int number);
    //查询
    public List<score> list();
    //分页查询
    public List<score> list(int start, int count);
}