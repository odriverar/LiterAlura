package drr.aluracursos.frontend;

import drr.aluracursos.frontend.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendApplication implements CommandLineRunner {
    // private IPrincipalService principalService;

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.mostrarMenu();
    }
}
