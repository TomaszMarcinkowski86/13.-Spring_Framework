package pl.sda.springmvc.springmvcDemo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvcDemo.entity.RoleEntity;
import pl.sda.springmvc.springmvcDemo.repository.RoleRepository;
import pl.sda.springmvc.springmvcDemo.service.RoleService;

import javax.persistence.RollbackException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void createRole(String name) {
        Optional<RoleEntity> byName = roleRepository.findByName(name);

        if (byName.isPresent()) {
            return;
        }
        RoleEntity newRole = new RoleEntity();
        newRole.setName(name);
        roleRepository.save(newRole);
    }
}
