package ma.emsi.CRMSAHRAOUI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.emsi.CRMSAHRAOUI.entities.Customer;
import ma.emsi.CRMSAHRAOUI.repositories.CustomerRepository;

@SpringBootApplication
public class CrmSahraouiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmSahraouiApplication.class, args);
	}
	//@Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return  args -> {
            customerRepository.save(new Customer(null,"fatimaezzahra","sahraoui","fati@gmail.com","adresse1","casablanca","Maroc","0645246362"));
            customerRepository.save(new Customer(null,"mohamed","sahraoui","med@gmail.com","adresse2","casablanca","Maroc","0645245457"));
            customerRepository.save(new Customer(null,"souha","sahraoui","souha@gmail.com","adresse3","Fes","Maroc","0644558762"));

    customerRepository.findAll().forEach(p->{
        System.out.println(p.getFirstName());
    });

        };
    }
}
