package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.ICitiesRoads;
import navigator.database.models.CitiesRoads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesRoadsDAO implements ICitiesRoads {

    @Override
    public CitiesRoads getById(Long id) {
        Connection connection=ConnectionPool.getInstance().retrieve();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM cities_has_road WHERE id=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new CitiesRoads(rs.getLong("id"),rs.getLong("road_id"),rs.getLong("cities_id"));
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
    public List<CitiesRoads> getAll() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            connection = ConnectionPool.getInstance().retrieve();
            ps=connection.prepareStatement("SELECT * FROM cities_has_road");
            rs=ps.executeQuery();
            List<CitiesRoads> list= new ArrayList<>();
            while (rs.next()){
                list.add( new CitiesRoads(rs.getLong("id"),rs.getLong("road_id"),rs.getLong("cities_id")));
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

    public CitiesRoads getByCityId(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM cities_has_road WHERE cities_id=?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new CitiesRoads(rs.getLong("id"), rs.getLong("road_id"), rs.getLong("cities_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!connection.isClosed()) connection.close();
                if (!ps.isClosed()) ps.close();
                if (!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
