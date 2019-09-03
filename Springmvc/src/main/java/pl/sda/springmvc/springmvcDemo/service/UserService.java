package pl.sda.springmvc.springmvcDemo.service;


import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.dto.SignInFormDTO;

public interface UserService {

  void createUser(SignInFormDTO signInFormDTO) throws Exception;
}
