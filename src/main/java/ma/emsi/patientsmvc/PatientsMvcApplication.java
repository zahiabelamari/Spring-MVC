package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean //Pour que ça s'execute au démarrage
   CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Kawtar", new Date(), false,12));
            patientRepository.save(new Patient(null, "Ibtissam", new Date(), true,20));
            patientRepository.save(new Patient(null, "Reda", new Date(), false,50));
            patientRepository.save(new Patient(null, "Amine", new Date(), true,90));
            patientRepository.findAll().forEach(
                    p->{
                        System.out.println(p.getNom());
                    }
            );
        };
   }
}
