package codewiththugboy.tourist.exceptions;

public class TouristExceptions extends Throwable{
    private int statusCode;


    public TouristExceptions(String message) {
        super(message);
        this.statusCode = this.statusCode;


    }
    public int getStatusCode(){
        return  statusCode;}


}
