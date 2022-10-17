package navigator.database.dao.mybatis;

import navigator.database.dao.interfaces.IRoadToStationDAO;
import navigator.database.models.RoadToStation;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoadToStationDAO {
    public RoadToStation getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRoadToStationDAO iRoadToStationDAO =session.getMapper(IRoadToStationDAO.class);
            return iRoadToStationDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    public List<RoadToStation> getAll(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRoadToStationDAO iRoadToStationDAO =session.getMapper(IRoadToStationDAO.class);
            return iRoadToStationDAO.getAll();
        }finally {
            session.rollback();
            session.close();
        }
    }

    public List<RoadToStation> getAllByCitiesId(int cities_id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRoadToStationDAO iRoadToStationDAO =session.getMapper(IRoadToStationDAO.class);
            return iRoadToStationDAO.getAllByCitiesId(cities_id);
        }finally {
            session.rollback();
            session.close();
        }
    }

}
