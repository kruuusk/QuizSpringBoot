package it.circuitoinformatico.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.circuitoinformatico.model.Risposta;

public interface RispostaRepository extends CrudRepository<Risposta, Long> {

	List<Risposta> findAllByDomandaId(long idDomanda);
}
