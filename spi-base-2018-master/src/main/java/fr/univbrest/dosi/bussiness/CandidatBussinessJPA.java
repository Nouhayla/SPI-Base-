package fr.univbrest.dosi.bussiness;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;

import fr.univbrest.dosi.repositories.CandidatRepository;

@Component
public class CandidatBussinessJPA implements CandidatBussiness {
	
	private CandidatRepository repos ;

	@Autowired 
	
	public CandidatBussinessJPA(CandidatRepository repos) {
		
		this.repos = repos;
	}

	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		// TODO Auto-generated method stub
		//candidatACreer.setDateNaissance(new Date());
		return repos.save(candidatACreer);
	}

	@Override
	public void supprimerCandidat(Candidat candidatASupp) {
		// TODO Auto-generated method stub
		 repos.delete(candidatASupp);
	}

	@Override
	public List<Candidat> rechercheNom(String nom) {
		// TODO Auto-generated method stub
		List<Candidat> candidatRecherche = repos.findByNom(nom);
		return candidatRecherche;
		
	}

	@Override
	public List<Candidat> rechercheParUniversiteOrigine(String UnivOrigine) {
		// TODO Auto-generated method stub
		List<Candidat> candidatRecherche = repos.findByUniversiteOrigine(UnivOrigine);
		return candidatRecherche;
	}
	
	@Override
	public List<Candidat> recupererTousLesCandidats() {
		return (List<Candidat>) repos.findAll();
	}
	@Override
	public Candidat rechercherCandidatParId(String id) {
		return repos.findOne(id);
	}

}
