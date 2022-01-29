package calculator.service;


import calculator.dao.DistanceDAO;
import calculator.model.Distance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService{

    private DistanceDAO distanceDAO;

    @Autowired
    public void setDistanceDAO(DistanceDAO distanceDAO){
        this.distanceDAO = distanceDAO;
    }

    @Override
    @Transactional
    public List<Distance> allDistance() {
        return distanceDAO.allDistance();
    }

    @Override
    @Transactional
    public void add(Distance distance) {
        distanceDAO.add(distance);
    }

    @Override
    @Transactional
    public void delete(Distance distance) {
        distanceDAO.delete(distance);
    }

    @Override
    @Transactional
    public void edit(Distance distance) {
        distanceDAO.edit(distance);
    }

    @Override
    @Transactional
    public Distance getById(int id) {
        return distanceDAO.getById(id);
    }
}
