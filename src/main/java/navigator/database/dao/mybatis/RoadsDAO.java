package navigator.database.dao.mybatis;



import navigator.database.dao.interfaces.IRoadsDAO;
import navigator.database.models.Roads;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoadsDAO {
    public Roads getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRoadsDAO iRoadsDAO =session.getMapper(IRoadsDAO.class);
            return iRoadsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    public List<Roads> getAll(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRoadsDAO iRoadsDAO =session.getMapper(IRoadsDAO.class);
            return iRoadsDAO.getAll();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
