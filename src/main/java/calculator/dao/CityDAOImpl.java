package calculator.dao;

import calculator.model.City;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CityDAOImpl implements  CityDAO{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, City> cities = new HashMap<>();

    static {
        City city1 = new City(0,0,"");
        city1.setLongitude(55.1122);
        city1.setLatitude(55.3212);
        city1.setName("Moscow");
        city1.setId(AUTO_ID.getAndIncrement());
        cities.put(city1.getId(), city1);
    }

    @Override
    public List<City> allCity() {
        return new ArrayList<>(cities.values());
    }

    @Override
    public void add(City city) {
        city.setId(AUTO_ID.getAndIncrement());
        cities.put(city.getId(), city);
    }

    @Override
    public void delete(City city) {
        cities.remove(city.getId());
    }

    @Override
    public void edit(City city) {
        cities.put(city.getId(), city);
    }

    @Override
    public City getById(int id) {
        return cities.get(id);
    }
}