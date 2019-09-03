package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;

@ControllerAdvice // kontroler ma zasęg globalny
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundProductException.class)
    public ModelAndView productNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}