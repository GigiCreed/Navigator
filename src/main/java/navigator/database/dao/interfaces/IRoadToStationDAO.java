package navigator.database.dao.interfaces;


import navigator.database.models.RoadToStation;

import java.util.List;

public interface IRoadToStationDAO extends IBaseDAO<RoadToStation>{
    List<RoadToStation> getAllByCitiesId(int cities_id);


}
