package navigator.database.dao.mybatis;

import navigator.database.dao.interfaces.IStationsDAO;
import navigator.database.models.Stations;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StationsDAO {
    public Stations getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStationsDAO iStationsDAO =session.getMapper(IStationsDAO.class);
            return iStationsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    public List<Stations> getAll(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStationsDAO iStationsDAO =session.getMapper(IStationsDAO.class);
            return iStationsDAO.getAll();
        }finally {
            session.rollback();
            session.close();
        }
    }

    public List<Stations> getAllByCityId(Long cities_id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStationsDAO iStationsDAO =session.getMapper(IStationsDAO.class);
            return iStationsDAO.getAllByCityId(cities_id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    public Stations getByName(String name){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStationsDAO iStationsDAO =session.getMapper(IStationsDAO.class);
            return iStationsDAO.getByName(name);
        }finally {
            session.rollback();
            session.close();
        }
    }

}
