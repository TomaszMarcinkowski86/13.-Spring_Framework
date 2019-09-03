package pl.sda.springmvc.springmvcDemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.dto.SignInFormDTO;
import pl.sda.springmvc.springmvcDemo.service.UserService;

@Controller
@RequestMapping("/sign-in")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ModelAndView getSignPage() {
        ModelAndView mnv = new ModelAndView("signin");
        mnv.addObject("signInForm", new SignInFormDTO());
        return mnv;
    }

    //    @RequestMapping(method = RequestMethod.POST) - to samo co niżej
    @PostMapping
    public ModelAndView registerUser(@ModelAttribute("signInForm") SignInFormDTO signInFormDTO) throws Exception {
        System.out.println(signInFormDTO);
        userService.createUser(signInFormDTO);
        return new ModelAndView("redirect:/login");
    }


}

