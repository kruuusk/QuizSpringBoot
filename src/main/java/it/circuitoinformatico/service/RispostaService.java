package it.circuitoinformatico.service;

import java.util.List;

import it.circuitoinformatico.model.Risposta;

public interface RispostaService {

	public List<Risposta> getAllRisposte();
	
	public List<Risposta> getAllRisposteByDomandaId(long idDomanda);
	
	public Risposta getRispostaById(long id);
	
	public void saveOrUpdate(Risposta risposta);
	
	public void deleteRisposta(long id);
}
