package navigator;

import navigator.database.cityenums.City;
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
  static void distance(City one, City two){
        CitiesDAO citiesDAO = new CitiesDAO();
        CitiesDAO citiesDAO1 = new CitiesDAO();

        Cities city1= citiesDAO.getByName(one.toString());
        Cities city2= citiesDAO1.getByName(two.toString());
        CitiesRoadsDAO citiesRoadsDAO = new CitiesRoadsDAO();
        CitiesRoadsDAO citiesRoadsDAO2 = new CitiesRoadsDAO();

        CitiesRoads citiesRoads1 = citiesRoadsDAO.getByCityId(city1.getId());
        CitiesRoads citiesRoads2 = citiesRoadsDAO2.getByCityId(city2.getId());


        if(citiesRoads1.getRoads_Id()==citiesRoads2.getRoads_Id()){
            RoadDAO roadDAO = new RoadDAO();
            Road road = roadDAO.getById(citiesRoads2.getRoads_Id());
            System.out.println("Distance "+road.getDistance());
        }
    }


   private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        distance(City.Batumi,City.Tbilisi);
    }
}
