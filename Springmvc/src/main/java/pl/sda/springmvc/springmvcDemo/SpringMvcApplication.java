package pl.sda.springmvc.springmvcDemo;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springmvc.springmvcDemo.service.RoleService;

@SpringBootApplication
@AllArgsConstructor
public class SpringMvcApplication implements CommandLineRunner {

	private final RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		roleService.createRole("ADMIN");
		roleService.createRole("USER");

	}
}
