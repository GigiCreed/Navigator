package navigator.service;

import navigator.algorithm.Floyd;
import navigator.database.dao.jdbc.RoadToStationDAO;
import navigator.database.dao.jdbc.RoadsDAO;
import navigator.database.dao.jdbc.StationsDAO;
import navigator.database.models.RoadToStation;
import navigator.database.models.Roads;
import navigator.database.models.Stations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Navigator {
    private final double INF = 9999;
    private final RoadToStationDAO rd = new RoadToStationDAO();
    private final StationsDAO st = new StationsDAO();
    private final RoadsDAO roadsDAO = new RoadsDAO();
    private final Stations first = new Stations();
    private final Stations second = new Stations();

    public void showDistance(String from,String to) {
        Stations stationFirst = st.getByName(from);
        Stations stationSecond = st.getByName(to);
        if (Objects.equals(stationFirst.getCitiesId(), stationSecond.getCitiesId())) {
            List<Stations> lst = st.getAllByCityId(stationFirst.getCitiesId());
            int [] ints = new int[2];
            for (int i =0; i<lst.size();i++){
                Stations stations = lst.get(i);
                if(stations.getName().equals(from)){
                   ints[0]=i;
                }
                if(stations.getName().equals(to)){
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
            floyd.printMatrix(floyd.getDistances());
            System.out.println();
            floyd.printMatrix(floyd.getDirections());
            System.out.println();
            System.out.println("Distance is "+ floyd.getDistances()[ints[0]][ints[1]]+"Km");
            List<Integer> raime = new ArrayList<>();
            raime.add(ints[0]);
            int r = ints[0];
            while (true){
                 if (floyd.getDirections()[r][ints[1]]==ints[1]){
                     raime.add(ints[1]);
                     break;
                 }else {
                     r = (int) floyd.getDirections()[r][ints[1]];
                     raime.add(r);
                 }
             }
            System.out.println(raime);
        }
    }


}
