package ma.projet.graph;

import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.entities.Transaction;
import ma.projet.graph.entities.TypeTransaction;
import ma.projet.graph.repositories.CompteRepository;
import ma.projet.graph.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
		return args -> {

			Compte compte1 = new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE);
			Compte compte2 = new Compte(Math.random() * 9000, new Date(), TypeCompte.COURANT);
			Compte compte3 = new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE);
			Compte compte4 = new Compte(Math.random() * 9000, new Date(), TypeCompte.COURANT);
			Compte compte5 = new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE);


			compteRepository.save(compte1);
			compteRepository.save(compte2);
			compteRepository.save(compte3);
			compteRepository.save(compte4);
			compteRepository.save(compte5);


			transactionRepository.save(new Transaction(100.0, new Date(), TypeTransaction.DEPOT, compte1));
			transactionRepository.save(new Transaction(50.0, new Date(), TypeTransaction.RETRAIT, compte1));

			transactionRepository.save(new Transaction(200.0, new Date(), TypeTransaction.DEPOT, compte2));
			transactionRepository.save(new Transaction(150.0, new Date(), TypeTransaction.RETRAIT, compte2));

			transactionRepository.save(new Transaction(300.0, new Date(), TypeTransaction.DEPOT, compte3));
			transactionRepository.save(new Transaction(250.0, new Date(), TypeTransaction.RETRAIT, compte3));

			transactionRepository.save(new Transaction(400.0, new Date(), TypeTransaction.DEPOT, compte4));
			transactionRepository.save(new Transaction(350.0, new Date(), TypeTransaction.RETRAIT, compte4));

			transactionRepository.save(new Transaction(500.0, new Date(), TypeTransaction.DEPOT, compte5));
			transactionRepository.save(new Transaction(450.0, new Date(), TypeTransaction.RETRAIT, compte5));
		};
	}
}
