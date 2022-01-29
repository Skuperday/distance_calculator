package calculator.exception;

public class CoordinatesException extends Throwable{

    @Override
    public String toString(){
        String coordinatesError = "coordinates are incorrect";
        return coordinatesError;
    }
}
