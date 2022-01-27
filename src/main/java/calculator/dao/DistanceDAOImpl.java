package calculator.dao;

import calculator.model.City;
import calculator.model.Distance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DistanceDAOImpl implements DistanceDAO{

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Distance> distances = new HashMap<>();

    @Override
    public List<Distance> allDistance() {
        return new ArrayList<>(distances.values());
    }

    @Override
    public void add(Distance distance) {
        distance.setId(AUTO_ID.getAndIncrement());
        distances.put(distance.getId(), distance);
    }

    @Override
    public void delete(Distance distance) {
        distances.remove(distance.getId());
    }

    @Override
    public void edit(Distance distance) {
        distances.put(distance.getId(), distance);
    }

    @Override
    public Distance getById(int id) {
        return distances.get(id);
    }
}
