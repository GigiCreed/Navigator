package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.IBaseDAO;
import navigator.database.dao.interfaces.IStationsDAO;
import navigator.database.models.Roads;
import navigator.database.models.Stations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationsDAO implements IStationsDAO {
    private static final Logger LOGGER = LogManager.getLogger(StationsDAO.class);
    @Override
    public Stations getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Stations stations = new Stations();
        try {
            preparedStatement=connection.prepareStatement("Select * From stations where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                stations.setId(resultSet.getLong("id"));
                stations.setName(resultSet.getString("name"));
                stations.setCitiesId(resultSet.getLong("cities_id"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return stations;
    }

    @Override
    public List<Stations> getAll() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Stations> stationsList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from stations");
            while (resultSet.next()){
                Stations stations = new Stations();

                stations.setId(resultSet.getLong("id"));
                stations.setName(resultSet.getString("name"));
                stations.setCitiesId(resultSet.getLong("cities_id"));

                stationsList.add(stations);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert statement != null;
                statement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return stationsList;
    }

    @Override
    public Stations getByName(String name) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Stations stations = new Stations();
        try {
            preparedStatement=connection.prepareStatement("Select * From stations where name = ?");
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                stations.setId(resultSet.getLong("id"));
                stations.setName(resultSet.getString("name"));
                stations.setCitiesId(resultSet.getLong("cities_id"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return stations;
    }

    @Override
    public List<Stations> getAllByCityId(Long citiesId) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Stations> lst = new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("Select * From stations where Cities_id = ?");
            preparedStatement.setLong(1,citiesId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Stations stations = new Stations();
                stations.setId(resultSet.getLong("id"));
                stations.setName(resultSet.getString("name"));
                stations.setCitiesId(resultSet.getLong("cities_id"));
                lst.add(stations);
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return lst;
    }
}
