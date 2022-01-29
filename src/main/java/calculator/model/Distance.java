package calculator.model;

import org.hibernate.annotations.Generated;
import javax.persistence.*;
import calculator.exception.*;

@Entity
@Table(name = "distance_matrix")
public class Distance{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fromCity")
    private String fromCity;
    @Column(name = "toCity")
    private String toCity;
    @Column(name = "distance")
    private double distance;

    public Distance(){
    }
    public void setId(int id){
        this.id = id;
    }
    public void setFromCity(String fromCity){
        this.fromCity = fromCity;
    }
    public void setToCity(String toCity){
        this.toCity = toCity;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }

    public String getToCity() {
        return toCity;
    }
    public String getFromCity() {
        return fromCity;
    }
    public double getDistance() {
        return distance;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", distance=" + distance +
                '}';
    }
}
