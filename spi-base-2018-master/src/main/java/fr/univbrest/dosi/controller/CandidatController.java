package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bussiness.CandidatBussiness;


@RestController 
@RequestMapping("/Candidat")
public class CandidatController {

	private CandidatBussiness bussiness ;
	
	@Autowired
	public CandidatController(CandidatBussiness bussiness) {
		this.bussiness = bussiness;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat candidatACreer) {
		return bussiness.creerCandidat(candidatACreer);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/Supp/{id}")
	public String suppCandidat(@PathVariable String id) {
		Candidat c = recupererCandidatAvecLId (id);
		 bussiness.supprimerCandidat(c);
		return "Spprimer !!";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> recupererTousLesCandidats() {
		return bussiness.recupererTousLesCandidats();  
	}
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> recupererCandidatAvecLeNom(@PathVariable String nom) {
		return bussiness.rechercheNom(nom);
	}
	@RequestMapping(method = RequestMethod.GET, value="/UnivOrigine/{univOrigine}")
	public List<Candidat> recupererCandidatAveUnivOrigin(@PathVariable String univOrigine) {
		return bussiness.rechercheParUniversiteOrigine(univOrigine);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Candidat recupererCandidatAvecLId(@PathVariable String id) {
		return bussiness.rechercherCandidatParId(id);
	}

}
