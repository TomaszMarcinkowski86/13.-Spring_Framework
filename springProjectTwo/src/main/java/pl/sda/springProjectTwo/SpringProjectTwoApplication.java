package pl.sda.springProjectTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import pl.sda.springProjectTwo.model.User;

import java.util.List;

@SpringBootApplication
public class SpringProjectTwoApplication implements CommandLineRunner {

//	@Autowired
//	private AppService appService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceTest serviceTest;

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectTwoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("user1", "user1"));
        userRepository.save(new User("user1", "user2"));
        userRepository.save(new User("user1", "user33"));
        userRepository.save(new User("user1", "user22"));
        userRepository.save(new User("user2", "user2"));
        userRepository.save(new User("user3", "user3"));
        userRepository.save(new User("user4", "user4"));


        List<User> users = userRepository.findByFirstNameOrderByLastName("user1");
        users.forEach(System.out::println);
        System.out.println(userRepository.countByFirstName("user1"));

        serviceTest.persist();
        serviceTest.updateCollection();
        serviceTest.delete();

//		appService.persist();
//		appService.addUserOrder();
//		appService.manyToManyPersist();
//		appService.remove();
//		appService.update();
//		appService.deleteOneToMany();
    }
}
