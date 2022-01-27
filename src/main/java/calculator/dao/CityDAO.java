package calculator.dao;

import calculator.model.City;
import java.util.List;

public interface CityDAO {
    List<City> allCity();
    void add(City city);
    void delete(City city);
    void edit(City city);
    City getById(int id);
}
