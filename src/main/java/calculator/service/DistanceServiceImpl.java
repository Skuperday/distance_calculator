package calculator.service;

import calculator.dao.CityDAO;
import calculator.dao.DistanceDAO;
import calculator.model.Distance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService{

    private DistanceDAO distanceDAO;

    @Autowired
    public void setDistanceDAO(DistanceDAO distanceDAO){
        this.distanceDAO = distanceDAO;
    }

    @Override
    public List<Distance> allDistance() {
        return distanceDAO.allDistance();
    }

    @Override
    public void add(Distance distance) {
        distanceDAO.add(distance);
    }

    @Override
    public void delete(Distance distance) {
        distanceDAO.delete(distance);
    }

    @Override
    public void edit(Distance distance) {
        distanceDAO.edit(distance);
    }

    @Override
    public Distance getById(int id) {
        return distanceDAO.getById(id);
    }
}
