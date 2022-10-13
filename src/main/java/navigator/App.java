package navigator;

import navigator.database.cityenums.City;
import navigator.database.dao.jdbc.CitiesDAO;
import navigator.database.dao.jdbc.RoadToStationDAO;
import navigator.database.dao.jdbc.RoadsDAO;
import navigator.database.dao.jdbc.StationsDAO;
import navigator.database.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App 
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {

        //+ Cities
//        CitiesDAO citiesDAO = new CitiesDAO();
//        for (Cities c: citiesDAO.getAll()) {
//            LOGGER.info(c);
//        }
//        Cities cities = citiesDAO.getById(1L);
//        LOGGER.info(cities);


        // + RoadToStation
//        RoadToStationDAO roadToStationDAO = new RoadToStationDAO();
//        for (RoadToStation r: roadToStationDAO.getAll()) {
//            LOGGER.info(r);
//        }
//        RoadToStation road =roadToStationDAO.getById(3L);
//        LOGGER.info(road);


        // + RoadsDAO
//        RoadsDAO roadsDAO = new RoadsDAO();
//        for (Roads r: roadsDAO.getAll()) {
//            LOGGER.info(r);
//        }
//        Roads roads = roadsDAO.getById(1L);
//        LOGGER.info(roads);

        //+ Station
//        StationsDAO stationsDAO = new StationsDAO();
//        for (Stations s:stationsDAO.getAll()) {
//            LOGGER.info(s);
//        }
//        Stations stations = stationsDAO.getById(3L);
//        LOGGER.info(stations);

    }
}
