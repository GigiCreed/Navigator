package navigator;

import navigator.database.dao.jdbc.CitiesDAO;
import navigator.database.dao.jdbc.CitiesRoadsDAO;
import navigator.database.dao.jdbc.RoadDAO;
import navigator.database.models.Cities;
import navigator.database.models.CitiesRoads;
import navigator.database.models.Road;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */

public class App 
{
    void distance(Long one,Long two){


    }


   private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        CitiesDAO citiesDAO = new CitiesDAO();

        for (Cities c : citiesDAO.getAll()) {
            System.out.println(c);
        }
//
        CitiesRoadsDAO citiesRoadsDAO = new CitiesRoadsDAO();

        for (CitiesRoads ci: citiesRoadsDAO.getAll()) {
            System.out.println(ci);
        }

        RoadDAO roadDAO = new RoadDAO();

        for (Road r:roadDAO.getAll()){
            System.out.println(r);
        }

    }
}
