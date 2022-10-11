package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.ICitiesRoads;
import navigator.database.models.CitiesRoads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CitiesRoadsDAO implements ICitiesRoads {

    @Override
    public CitiesRoads getById(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            ps=connection.prepareStatement("SELECT * FROM cities_has_roads WHERE id=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
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
        return null;
    }
}
