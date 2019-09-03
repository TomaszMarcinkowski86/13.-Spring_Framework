package pl.sda.springmvc.springmvcDemo.dto;


import lombok.Data;

@Data
public class SignInFormDTO {

    private String login;
    private String password;
    private String repeatedPassword;

}
