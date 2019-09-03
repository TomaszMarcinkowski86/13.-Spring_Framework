package pl.sda.springmvc.springmvcDemo.exception;

public class WebApplicationException extends Exception {

    public WebApplicationException(String message){
        super(message);
    }
}