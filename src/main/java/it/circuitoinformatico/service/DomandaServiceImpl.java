package it.circuitoinformatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.circuitoinformatico.model.Domanda;
import it.circuitoinformatico.repository.DomandaRepository;

@Service
@Transactional
public class DomandaServiceImpl implements DomandaService {

	@Autowired
	DomandaRepository domandaRepository;
	
	@Override
	public List<Domanda> getAllDomande() {
		return (List<Domanda>) domandaRepository.findAll();
	}
	
	@Override
	public Domanda getDomandaById(long id) {
		return domandaRepository.findById(id).get();
	}
	
	@Override
	public void saveOrUpdate(Domanda domanda) {
		domandaRepository.save(domanda);
	}
	
	@Override
	public void deleteDomanda(long id) {
		domandaRepository.deleteById(id);
	}

	@Override
	public List<Domanda> getAllDomandeByQuizId(long idQuiz) {
		return (List<Domanda>) domandaRepository.findAllByQuizId(idQuiz);
	}
}