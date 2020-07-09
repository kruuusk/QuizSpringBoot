package it.circuitoinformatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.circuitoinformatico.model.Risposta;
import it.circuitoinformatico.repository.RispostaRepository;

@Service
@Transactional
public class RispostaServiceImpl implements RispostaService {

	@Autowired
	RispostaRepository rispostaRepository;
	
	@Override
	public List<Risposta> getAllRisposte() {
		return (List<Risposta>) rispostaRepository.findAll();
	}
	
	@Override
	public Risposta getRispostaById(long id) {
		return rispostaRepository.findById(id).get();
	}
	
	@Override
	public void saveOrUpdate(Risposta risposta) {
		rispostaRepository.save(risposta);
	}
	
	@Override
	public void deleteRisposta(long id) {
		rispostaRepository.deleteById(id);
	}

	@Override
	public List<Risposta> getAllRisposteByDomandaId(long idDomanda) {
		return (List<Risposta>) rispostaRepository.findAllByDomandaId(idDomanda);
	}
}