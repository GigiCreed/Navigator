package navigator.service;

import navigator.algorithm.Floyd;
import navigator.database.dao.jdbc.RoadToStationDAO;
import navigator.database.dao.jdbc.RoadsDAO;
import navigator.database.dao.jdbc.StationsDAO;
import navigator.database.models.RoadToStation;
import navigator.database.models.Roads;
import navigator.database.models.Stations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Navigator {
    private final double INF = 9999;
    private final RoadToStationDAO rd = new RoadToStationDAO();
    private final StationsDAO st = new StationsDAO();
    private final RoadsDAO roadsDAO = new RoadsDAO();
    private static final Logger LOGGER = LogManager.getLogger(Navigator.class);

    public void showDistance(StationEnum from ,StationEnum to) {
        String from_Station = from.toString().replace("_"," ");
        String to_Station = to.toString().replace("_"," ");

        Stations stationFirst = st.getByName(from_Station);
        Stations stationSecond = st.getByName(to_Station);


        if (Objects.equals(stationFirst.getCitiesId(), stationSecond.getCitiesId())) {
            List<Stations> lst = st.getAllByCityId(stationFirst.getCitiesId());


            int [] ints = new int[2];
            for (int i =0; i<lst.size();i++){
                Stations stations = lst.get(i);
                if(stations.getName().equals(from_Station)){
                   ints[0]=i;
                }
                if(stations.getName().equals(to_Station)){
                    ints[1]=i;
                }
            }


            Floyd floyd = new Floyd(lst.size());

            List<RoadToStation> arr = rd.getAllByCitiesId(lst.size());
            double[][] array = new double[lst.size()][lst.size()];


            for (int i = 0; i < arr.size(); i+= 2) {
                int x = i;
                RoadToStation f = arr.get(x++);
                RoadToStation s = arr.get(x);

                Roads roads = roadsDAO.getById(f.getRoadsId());

                array[(int) (f.getCitiesId()-1)][(int) (s.getCitiesId()-1)] = roads.getDistance();
                array[(int) (s.getCitiesId()-1)][(int) (f.getCitiesId()-1)] = roads.getDistance();
            }

            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array.length; ++j) {
                    if (array[i][j] == 0 && i != j) {
                        array[i][j] = INF;
                    }
                }
            }

            floyd.floydWarshall(array,lst.size());

            int sub = ints[0];
            List<Integer> route = new ArrayList<>();
            route.add(sub);

            while (true) {
                if (floyd.getDirections()[sub][ints[1]]-1 == ints[1]) {
                    route.add(ints[1]);
                    break;
                } else {
                    route.add((int) floyd.getDirections()[sub][ints[1]]-1 );
                    sub = (int) floyd.getDirections()[sub][ints[1]]-1;
                }
            }

            LOGGER.info("To Reach Your destination you have to go through: ");
            for (int i = 0; i < route.size(); i++) {
                System.out.print(lst.get(route.get(i)).getName() + " - ");
            }

            LOGGER.info("Distance is "+ floyd.getDistances()[ints[0]][ints[1]]+"Km");
        } else {
            List<Stations> list = st.getAll();

            Floyd floyd = new Floyd(list.size());

            List<RoadToStation> arr = rd.getAllByCitiesId(list.size()+1);

            int [] ints = new int[2];
            for (int i =0; i<list.size();i++){
                Stations stations = list.get(i);
                if(stations.getName().equals(from_Station)){
                    ints[0]=i;
                }
                if(stations.getName().equals(to_Station)){
                    ints[1]=i;
                }
            }

            double[][] array = new double[list.size()][list.size()];

            for (int i = 0; i < arr.size(); i+= 2) {
                int x = i;
                RoadToStation f = arr.get(x++);
                RoadToStation s = arr.get(x);

                Roads roads = roadsDAO.getById(f.getRoadsId());
                array[(int) (f.getCitiesId()-1)][(int) (s.getCitiesId()-1)] = roads.getDistance();
                array[(int) (s.getCitiesId()-1)][(int) (f.getCitiesId()-1)] = roads.getDistance();

            }

            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array.length; ++j) {
                    if (array[i][j] == 0 && i != j) {
                        array[i][j] = INF;
                    }
                }
            }

            floyd.floydWarshall(array,list.size());

            int sub = ints[0];
            List<Integer> route = new ArrayList<>();
            route.add(sub);

            while (true) {

                if (floyd.getDirections()[sub][ints[1]]-1 == ints[1]) {
                    route.add(ints[1]);
                    break;
                } else {
                    route.add((int) floyd.getDirections()[sub][ints[1]]-1 );
                    sub = (int) floyd.getDirections()[sub][ints[1]]-1;
                }
            }

            LOGGER.info("To Reach Your destination you have to go through: ");
            for (int i = 0; i < route.size(); i++) {
                System.out.print(list.get(route.get(i)).getName() + " - ");
            }

            LOGGER.info("\nDistance is "+ floyd.getDistances()[ints[0]][ints[1]]+"Km");

        }
    }


}
