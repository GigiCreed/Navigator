package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.IRoadToStationDAO;
import navigator.database.models.RoadToStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoadToStationDAO implements IRoadToStationDAO {

    @Override
    public RoadToStation getById(Long id) {
        Connection connection=ConnectionPool.getInstance().retrieve();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM roadtostation WHERE id=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new RoadToStation(rs.getLong("id"),rs.getLong("roads_id"),rs.getLong("stations_id"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(!connection.isClosed()) connection.close();
                if(!ps.isClosed()) ps.close();
                if(!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<RoadToStation> getAll() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            connection = ConnectionPool.getInstance().retrieve();
            ps=connection.prepareStatement("SELECT * FROM roadtostation");
            rs=ps.executeQuery();
            List<RoadToStation> list= new ArrayList<>();
            while (rs.next()){
                list.add( new RoadToStation(rs.getLong("id"),rs.getLong("roads_id"),rs.getLong("stations_id")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(!connection.isClosed()) connection.close();
                if(!ps.isClosed()) ps.close();
                if(!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<RoadToStation> getAllByCitiesId(int cities_id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            connection = ConnectionPool.getInstance().retrieve();
            ps=connection.prepareStatement("SELECT * FROM roadtostation where Stations_id <= ? and Roads_id <= ? ");
            ps.setInt(1,cities_id);
            ps.setInt(2,cities_id);
            rs=ps.executeQuery();
            List<RoadToStation> list= new ArrayList<>();
            while (rs.next()){
                list.add( new RoadToStation(rs.getLong("id"),rs.getLong("roads_id"),rs.getLong("stations_id")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(!connection.isClosed()) connection.close();
                if(!ps.isClosed()) ps.close();
                if(!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
