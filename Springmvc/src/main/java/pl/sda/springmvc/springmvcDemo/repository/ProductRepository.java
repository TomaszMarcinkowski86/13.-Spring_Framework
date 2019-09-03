package pl.sda.springmvc.springmvcDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


}
