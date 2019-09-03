package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springmvc.springmvcDemo.entity.RoleEntity;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceDetailImpl implements UserDetailsService {

    private final UserRepository userRepository;

    //    @Autowired
    public UserServiceDetailImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserEntity> byLogin = userRepository.findByLogin(login);

        UserEntity user = byLogin.orElseThrow(() -> new UsernameNotFoundException("Not found user with login: " + login));

        return new User(user.getLogin(), user.getPassword(), getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(UserEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(RoleEntity roleEntity: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleEntity.getName()));
        }
        return authorities;
    }
}

