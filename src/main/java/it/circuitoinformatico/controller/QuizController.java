package it.circuitoinformatico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.circuitoinformatico.model.Domanda;
import it.circuitoinformatico.model.Quiz;
import it.circuitoinformatico.model.Risposta;
import it.circuitoinformatico.service.DomandaService;
import it.circuitoinformatico.service.QuizService;
import it.circuitoinformatico.service.RispostaService;

@Controller
@RequestMapping(value="/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	@Autowired
	DomandaService domandaService;
	@Autowired
	RispostaService rispostaService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("quiz_list");
		List<Quiz> quizList = quizService.getAllQuizzes();
		model.addObject("quizList", quizList);

		return model;
	}

	@RequestMapping(value="/addQuiz/", method=RequestMethod.GET)
	public ModelAndView addQuiz() {
		ModelAndView model = new ModelAndView();

		Quiz quiz = new Quiz();
		model.addObject("quizForm", quiz);
		model.setViewName("quiz_form");

		return model;
	}

	@RequestMapping(value="/updateQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView editQuiz(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Quiz quiz = quizService.getQuizById(id);
		model.addObject("quizForm", quiz);
		model.setViewName("quiz_form");

		return model;
	}

	@RequestMapping(value="/saveQuiz", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("quizForm") Quiz quiz) {
		quizService.saveOrUpdate(quiz);

		return new ModelAndView("redirect:/quiz/list");
	}

	@RequestMapping(value="/deleteQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		quizService.deleteQuiz(id);

		return new ModelAndView("redirect:/quiz/list");
	}

	@RequestMapping(value="/showQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView showQuiz(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Quiz quiz = quizService.getQuizById(id);
		model.addObject("quizDetail", quiz);

		List<Domanda> domandaList = domandaService.getAllDomandeByQuizId(id);
		model.addObject("domandaList", domandaList);

		model.setViewName("quiz_detail");

		return model;
	}

	@RequestMapping(value="/listDomande", method=RequestMethod.GET)
	public ModelAndView listDomande() {
		ModelAndView model = new ModelAndView("quiz_list");
		List<Domanda> domandaList = domandaService.getAllDomande();
		model.addObject("domandaList", domandaList);

		return model;
	}

	@RequestMapping(value="/addDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView addDomanda(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Quiz quiz = quizService.getQuizById(id);
		Domanda domanda = new Domanda();
		domanda.setQuiz(quiz);
		model.addObject("domandaForm", domanda);
		model.addObject("quizDetail", quiz);
		model.setViewName("domanda_form");

		return model;
	}

	@RequestMapping(value="/updateDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView editDomanda(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Domanda domanda = domandaService.getDomandaById(id);
		model.addObject("domandaForm", domanda);
		model.setViewName("domanda_form");

		return model;
	}

	@RequestMapping(value="/saveDomanda", method=RequestMethod.POST)
	public ModelAndView saveDomanda(@ModelAttribute("domandaForm") Domanda domanda) {
		Quiz quiz = quizService.getQuizById(domanda.getQuiz().getId());
		domanda.setQuiz(quiz);
		
		domandaService.saveOrUpdate(domanda);

		return new ModelAndView("redirect:/quiz/showQuiz/" + domanda.getQuiz().getId());
	}

	@RequestMapping(value="/deleteDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView deleteDomanda(@PathVariable("id") long id) {
		Domanda domanda = domandaService.getDomandaById(id);

		domandaService.deleteDomanda(id);

		return new ModelAndView("redirect:/quiz/showQuiz/" + domanda.getQuiz().getId() );
	}

	@RequestMapping(value="/showDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView showDomanda(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Domanda domanda = domandaService.getDomandaById(id);
		model.addObject("domandaDetail", domanda);

		Quiz quiz = quizService.getQuizById(domanda.getQuiz().getId());
		model.addObject("quizDetail", quiz);

		List<Risposta> rispostaList = rispostaService.getAllRisposteByDomandaId(id);
		model.addObject("rispostaList", rispostaList);

		model.setViewName("domanda_detail");

		return model;
	}

	@RequestMapping(value="/listRisposte", method=RequestMethod.GET)
	public ModelAndView listRisposte() {
		ModelAndView model = new ModelAndView("quiz_list");
		List<Risposta> rispostaList = rispostaService.getAllRisposte();
		model.addObject("rispostaList", rispostaList);

		return model;
	}

	@RequestMapping(value="/addRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView addRisposta(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Domanda domanda = domandaService.getDomandaById(id);
		Risposta risposta = new Risposta();
		risposta.setDomanda(domanda);
		model.addObject("rispostaForm", risposta);
		model.addObject("domandaDetail", domanda);
		model.setViewName("risposta_form");

		return model;
	}

	@RequestMapping(value="/updateRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView editRisposta(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Risposta risposta = rispostaService.getRispostaById(id);
		model.addObject("rispostaForm", risposta);
		model.setViewName("risposta_form");

		return model;
	}

	@RequestMapping(value="/saveRisposta", method=RequestMethod.POST)
	public ModelAndView saveRisposta(@ModelAttribute("rispostaForm") Risposta risposta) {
		Domanda domanda = domandaService.getDomandaById(risposta.getDomanda().getId());
		risposta.setDomanda(domanda);
		rispostaService.saveOrUpdate(risposta);

		return new ModelAndView("redirect:/quiz/showDomanda/" + risposta.getDomanda().getId());
	}

	@RequestMapping(value="/deleteRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRisposta(@PathVariable("id") long id) {
		Risposta risposta = rispostaService.getRispostaById(id);

		rispostaService.deleteRisposta(id);

		return new ModelAndView("redirect:/quiz/showDomanda/" + risposta.getDomanda().getId());
	}

	@RequestMapping(value="/showRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView showRisposta(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Risposta risposta = rispostaService.getRispostaById(id);
		model.addObject("rispostaDetail", risposta);

		Domanda domanda = domandaService.getDomandaById(risposta.getDomanda().getId());
		model.addObject("domandaDetail", domanda);

		Quiz quiz = quizService.getQuizById(domanda.getQuiz().getId());
		model.addObject("quizDetail", quiz);

		model.setViewName("risposta_detail");

		return model;
	}
}
