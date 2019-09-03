package pl.sda.springmvc.springmvcDemo.exception;

public class NotFoundProductException extends WebApplicationException {

    public NotFoundProductException(String message){
        super(message);
    }
}