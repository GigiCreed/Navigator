package navigator.database.dao.jdbc;

import navigator.database.dao.conectionpool.ConnectionPool;
import navigator.database.dao.interfaces.IBaseDAO;
import navigator.database.models.Cities;
import navigator.database.models.Road;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoadDAO implements IBaseDAO<Road> {
    private static final Logger LOGGER = LogManager.getLogger(RoadDAO.class);

    @Override
    public Road getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        Road road = new Road();
        try {
            preparedStatement = connection.prepareStatement("Select * from road Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                road.setId(resultSet.getLong("id"));
                road.setDistance(resultSet.getDouble("distance"));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            }catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return road;
    }

    @Override
    public List<Road> getAll() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Road> roadList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from road");
            while (resultSet.next()){
                Road road = new Road();

                road.setId(resultSet.getLong("id"));
                road.setDistance(resultSet.getDouble("distance"));



                roadList.add(road);
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
        return roadList;
    }
}
