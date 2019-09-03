package pl.sda.springProjectTwo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springProjectTwo.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

//    User findByFirstName(String firstName);
    List<User> findByFirstNameOrderByLastName(String firstName); // tu nazwa metody ma składnię odpowiadającą zapytaniu SQL

    int countByFirstName(String firstName);



}
