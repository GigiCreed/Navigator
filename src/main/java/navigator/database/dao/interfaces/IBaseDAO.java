package navigator.database.dao.interfaces;

import java.util.List;

public interface IBaseDAO <T>{
    T getById (Long id);

    List<T>getAll();
}
