package it.circuitoinformatico.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.circuitoinformatico.model.Domanda;

public interface DomandaRepository extends CrudRepository<Domanda, Long> {

	List<Domanda> findAllByQuizId(long idQuiz);
}
