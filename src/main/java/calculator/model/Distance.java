package calculator.model;

public class Distance{
    private City fromCity;
    private City toCity;
    private double distance;
    private int id;

    public void setFromCity(City fromCity){
        this.fromCity = fromCity;
    }
    public void setToCity(City toCity) {
        this.toCity = toCity;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getToCity() {
        return toCity;
    }
    public City getFromCity() {
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
