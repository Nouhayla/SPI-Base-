package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.univbrest.dosi.bean.Enseignant;

import fr.univbrest.dosi.bussiness.EnseignantBusiness;

@RestController 
@RequestMapping("/Enseignant")
public class EnseignantController {

	
private EnseignantBusiness bussiness ;
	
	@Autowired
	public EnseignantController(EnseignantBusiness bussiness) {
		this.bussiness = bussiness;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return bussiness.creerEnseignant(enseignantACreer);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/Supp/{id}")
	public String suppEnseignant(@PathVariable long id) {
	    bussiness.supprimerEnseignantByID(id);
		return "Spprimer !!";
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> recupererTousLesEnseignants() {
		return bussiness.recupererTousLesEnseignants();
	}
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> recupererCandidatAvecLeNom(@PathVariable String nom) {
		return bussiness.rechercheEnseignantParNom(nom);
	}
	@RequestMapping(method = RequestMethod.GET, value="/id/{noEnseignant}")
	public Enseignant recupererEnseignantAvecLId(@PathVariable long noEnseignant) {
		return bussiness.rechercherEnseignantParId(noEnseignant);
	}
	@RequestMapping(method = RequestMethod.GET, value="/Adresse/{adresse}")
	public Enseignant recupererEnseignantAvecAdresse(@PathVariable String adresse) {
		return bussiness.rechercherParAdresse(adresse);
	}
}
