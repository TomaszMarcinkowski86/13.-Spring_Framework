package pl.sda.springmvc.springmvcDemo.service.impl;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.dto.SignInFormDTO;
import pl.sda.springmvc.springmvcDemo.entity.RoleEntity;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.RoleRepository;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.UserService;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


//    @Autowired - generalnie powinno być w starszych wersjach
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(SignInFormDTO signInFormDTO) throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(signInFormDTO.getLogin());
        String encodedPassword = passwordEncoder.encode(signInFormDTO.getPassword());
        userEntity.setPassword(encodedPassword);

        Optional<RoleEntity> roleEntity;
        if(signInFormDTO.getLogin().startsWith("ADMIN")){
           roleEntity= roleRepository.findByName("ADMIN");
        }else{
            roleEntity = roleRepository.findByName("USER");
        }
        RoleEntity role = roleEntity.orElseThrow(()->new Exception("Role not Found"));
        userEntity.getRoles().add(role);
        userRepository.save(userEntity);
    }


}
