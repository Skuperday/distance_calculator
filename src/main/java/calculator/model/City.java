package calculator.model;

import net.bytebuddy.description.modifier.ModifierContributor;
import org.hibernate.annotations.Generated;
import javax.persistence.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import calculator.exception.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Entity
@Table(name = "cities")
@XmlRootElement
public class City {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @XmlElement(name = "longitude")
    @Column(name = "longitude")
    private double longitude;
    @XmlElement(name = "latitude")
    @Column(name = "latitude")
    private double latitude;
    @XmlElement(name = "name")
    @Column(name = "name")
    private String name;


    public City() {
    }
    public void setId(int id){
        this.id = id;
    }
    public void setLongitude(double longitude) throws CoordinatesException{
        if (longitude < -180.0 || longitude > 180.0){
            throw new CoordinatesException();
        }
        this.longitude = longitude;
    }
    public void setLatitude(double latitude) throws CoordinatesException{
        if (latitude < -90.0 || latitude > 90.0){
            throw new CoordinatesException();
        }
        this.latitude = latitude;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(latitude) + String.valueOf(longitude) + name;
    }

    public double distanceTo(City city){
        // Погрешность расстояния полученного данным методом
        // составляет примерно 0.5% тк Земля не идеально сферическая
        // и радиус отличается в зависимости от места
        // источник: https://congyuzhou.medium.com/расстояние-между-двумя-точками-на-поверхности-земли-a398352bfbde
        double toRad = 180/Math.PI;
        double longFrom = this.getLongitude()/toRad;
        double latiFrom = this.getLatitude()/toRad;
        double longTo = city.getLongitude()/toRad;
        double latiTo = city.getLatitude()/toRad;
        double latiDelta = latiTo - latiFrom;
        double longDelta = longTo - longFrom;
        double r = 6371;

        double distanceTo = 2 * r * Math.asin(Math.pow((Math.pow(Math.sin(latiDelta/2), 2) + Math.cos(latiTo)*Math.cos(latiFrom)*Math.pow(Math.sin(longDelta/2),2)), 0.5));

        return distanceTo;
    }


}