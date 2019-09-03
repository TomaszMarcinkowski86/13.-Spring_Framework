package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.dto.LoginDTO;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public ModelAndView getLoginPage(){
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("login");
        mnv.addObject("loginform", new LoginDTO());
        return mnv;
    }

}
