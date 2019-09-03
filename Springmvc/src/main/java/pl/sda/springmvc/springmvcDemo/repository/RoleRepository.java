package pl.sda.springmvc.springmvcDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvcDemo.entity.RoleEntity;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);

}
