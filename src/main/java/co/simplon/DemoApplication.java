package co.simplon;

import co.simplon.dao.TacheRepository;
import co.simplon.entities.AppRole;
import co.simplon.entities.Tache;
import co.simplon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private TacheRepository tacheRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override

	public void run(String... args) throws Exception {
		tacheRepository.save(new Tache(null,"entretenir sa voiture"));
		tacheRepository.save(new Tache(null,"faire son dossier projet"));
		tacheRepository.save(new Tache(null,"acheter un gateau"));
		tacheRepository.save(new Tache(null,"déposer les enfanrs a l'ecole"));

		tacheRepository.findAll().forEach(tache->{
			System.out.println(tache);
		});
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.save(new AppRole(null, "USER"));
			accountService.save(new AppRole(null, "ADMIN"));
			Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
				accountService.saveUser(null, "1234", "1234");
			});
			accountService.addRoleToUser("admin", "ADMIN");
		};
	}
}
