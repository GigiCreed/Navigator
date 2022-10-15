package navigator.database.dao.interfaces;

import navigator.database.models.Stations;

import java.util.List;

public interface IStationsDAO extends IBaseDAO<Stations> {
    Stations getByName(String name);
    List<Stations> getAllByCityId(Long citiesId);
}
