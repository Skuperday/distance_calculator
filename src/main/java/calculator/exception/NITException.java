package calculator.exception;

public class NITException extends Throwable{
    @Override
    public String toString(){
        String notInTableError = "City not in table";
        return notInTableError;
    }
}
