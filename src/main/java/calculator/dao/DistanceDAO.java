package calculator.dao;


import calculator.model.Distance;
import java.util.List;

public interface DistanceDAO {
    List<Distance> allDistance();
    void add(Distance distance);
    void delete(Distance distance);
    void edit(Distance distance);
    Distance getById(int id);
}
