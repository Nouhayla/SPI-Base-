package fr.univbrest.dosi.bussiness;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;



public interface CandidatBussiness {
	Candidat creerCandidat(Candidat candidatACreer);
	List<Candidat> recupererTousLesCandidats();
	void supprimerCandidat(Candidat candidatASupp);
	//void supprimerCandidat(String Id);
	List<Candidat> rechercheNom(String nom);
	List<Candidat> rechercheParUniversiteOrigine(String UnivOrigine);
	Candidat rechercherCandidatParId(String id);
	//Candidat supprimerCandidat(Candidat candidatASupprimer) ;
}
