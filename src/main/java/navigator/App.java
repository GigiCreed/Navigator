package navigator;

import navigator.database.dao.jdbc.CitiesDAO;
import navigator.database.dao.jdbc.CitiesRoadsDAO;
import navigator.database.dao.jdbc.RoadDAO;
import navigator.database.models.Cities;
import navigator.database.models.CitiesRoads;
import navigator.database.models.Road;
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
  static void distance(Long one,Long two){
        CitiesDAO citiesDAO = new CitiesDAO();
        CitiesDAO citiesDAO1 = new CitiesDAO();

        Cities city1= citiesDAO.getByName(one);
        Cities city2= citiesDAO1.getByName(two);
        CitiesRoadsDAO citiesRoadsDAO = new CitiesRoadsDAO();
        CitiesRoadsDAO citiesRoadsDAO2 = new CitiesRoadsDAO();

        CitiesRoads citiesRoads1 = citiesRoadsDAO.getByCityId(one);
        CitiesRoads citiesRoads2 = citiesRoadsDAO2.getByCityId(two);

        if(citiesRoads1.getRoads_Id()==citiesRoads2.getRoads_Id()){
            System.out.println("Distance  sd");
        }
    }


   private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
//        CitiesDAO citiesDAO = new CitiesDAO();
//
//        for (Cities c : citiesDAO.getAll()) {
//            System.out.println(c);
//        }
////
//        CitiesRoadsDAO citiesRoadsDAO = new CitiesRoadsDAO();
//
//        for (CitiesRoads ci: citiesRoadsDAO.getAll()) {
//            System.out.println(ci);
//        }
//
//        RoadDAO roadDAO = new RoadDAO();
//
//        for (Road r:roadDAO.getAll()){
//            System.out.println(r);
//        }

        distance(2L,3L);

    }
}
