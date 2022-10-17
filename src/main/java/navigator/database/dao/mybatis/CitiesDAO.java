package navigator.database.dao.mybatis;

import navigator.database.dao.interfaces.ICitiesDAO;
import navigator.database.models.Cities;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CitiesDAO {
    public Cities getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ICitiesDAO iCitiesDAO =session.getMapper(ICitiesDAO.class);
            return iCitiesDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
     }

     public List<Cities> getAll(){
         SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
         try {
             ICitiesDAO iCitiesDAO =session.getMapper(ICitiesDAO.class);
             return iCitiesDAO.getAll();
         }finally {
             session.rollback();
             session.close();
         }
     }
}
