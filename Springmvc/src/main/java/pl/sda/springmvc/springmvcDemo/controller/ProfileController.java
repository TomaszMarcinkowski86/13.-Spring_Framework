package pl.sda.springmvc.springmvcDemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.OrderService;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController  {

    private final OrderService orderService;

    @RequestMapping
    public ModelAndView getProfilePage(Principal  principal) {
        ModelAndView mnv = new ModelAndView("profile");
        mnv.addObject("orders",orderService.getOrdersByUserLogin(principal.getName()));
        return mnv;
    }
}
