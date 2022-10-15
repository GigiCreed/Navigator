package navigator.service;

import navigator.algorithm.Floyd;
import navigator.database.dao.jdbc.RoadToStationDAO;
import navigator.database.dao.jdbc.RoadsDAO;
import navigator.database.dao.jdbc.StationsDAO;
import navigator.database.models.RoadToStation;
import navigator.database.models.Roads;
import navigator.database.models.Stations;

import java.util.List;

public class Navigator {
    private final double INF = 9999;
    private RoadToStationDAO rd = new RoadToStationDAO();
    private StationsDAO st = new StationsDAO();
    private RoadsDAO roadsDAO = new RoadsDAO();
    private Stations first = new Stations();
    private Stations second = new Stations();
    private Floyd floyd = new Floyd();

    public void showDistance(String from,String to) {
        Stations stationFirst = st.getByName(from);
        Stations stationSecond = st.getByName(to);
        if (stationFirst.getCitiesId() == stationSecond.getCitiesId()) {
            List<Stations> lst = st.getAllByCityId(stationFirst.getCitiesId());



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
        }
    }


}
