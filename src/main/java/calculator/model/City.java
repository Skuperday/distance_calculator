package calculator.model;

public class City {
    private double longitude;
    private double latitude;
    private String name = "";
    private int id;

    public City(double longitude, double latitude, String name){
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
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