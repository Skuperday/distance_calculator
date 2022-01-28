package calculator.service;

import calculator.dao.CityDAO;
import calculator.dao.CityDAOImpl;
import calculator.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private CityDAO cityDAO;

    @Autowired
    public void setCityDAO(CityDAO cityDAO){
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional
    public List<City> allCity() {
        return cityDAO.allCity();
    }

    @Override
    @Transactional
    public void add(City city) {
        cityDAO.add(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        cityDAO.delete(city);
    }

    @Override
    @Transactional
    public void edit(City city) {
        cityDAO.edit(city);
    }

    @Override
    @Transactional
    public City getById(int id) {
        return cityDAO.getById(id);
    }
}
