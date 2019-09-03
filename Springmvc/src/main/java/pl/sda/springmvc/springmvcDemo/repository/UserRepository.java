package pl.sda.springmvc.springmvcDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);

}
