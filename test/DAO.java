package test;

import java.util.List;
 
import test.score;
  
public interface DAO{
    //����
    public void add(score score1);
    //�޸�
    public void update(score score1);
    //ɾ��
    public void delete(int number);
    //��ȡ
    public score get(int number);
    //��ѯ
    public List<score> list();
    //��ҳ��ѯ
    public List<score> list(int start, int count);
}