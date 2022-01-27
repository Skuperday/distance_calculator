package calculator.service;

import calculator.dao.CityDAO;
import calculator.dao.CityDAOImpl;
import calculator.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private CityDAO cityDAO;

    @Autowired
    public void setCityDAO(CityDAO cityDAO){
        this.cityDAO = cityDAO;
    }

    @Override
    public List<City> allCity() {
        return cityDAO.allCity();
    }

    @Override
    public void add(City city) {
        cityDAO.add(city);
    }

    @Override
    public void delete(City city) {
        cityDAO.delete(city);
    }

    @Override
    public void edit(City city) {
        cityDAO.edit(city);
    }

    @Override
    public City getById(int id) {
        return cityDAO.getById(id);
    }
}
