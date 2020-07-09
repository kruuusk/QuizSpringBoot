package it.circuitoinformatico.service;

import java.util.List;

import it.circuitoinformatico.model.Domanda;

public interface DomandaService {

	public List<Domanda> getAllDomande();
	
	public List<Domanda> getAllDomandeByQuizId(long idQuiz);
	
	public Domanda getDomandaById(long id);
	
	public void saveOrUpdate(Domanda domanda);
	
	public void deleteDomanda(long id);
}
