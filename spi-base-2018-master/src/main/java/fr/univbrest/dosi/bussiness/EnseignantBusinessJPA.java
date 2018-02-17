package fr.univbrest.dosi.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;

import fr.univbrest.dosi.repositories.EnseignantRepository;



@Component
public class EnseignantBusinessJPA implements EnseignantBusiness{

	private EnseignantRepository repos ;

	@Autowired 
	
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		
		this.repos = repos;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		// TODO Auto-generated method stub
		//candidatACreer.setDateNaissance(new Date());
		return repos.save(enseignantACreer);
	}

	public void supprimerEnseignant(Enseignant enseignantASupp) {
		// TODO Auto-generated method stub
		repos.delete(enseignantASupp);
	}
	

	@Override
	public List<Enseignant> rechercheEnseignantParNom(String nom) {
		// TODO Auto-generated method stub
		List<Enseignant> enseignantRecherche = repos.findByNom(nom);
		return enseignantRecherche;
	}
	
	@Override
	public List<Enseignant> recupererTousLesEnseignants() {
		return (List<Enseignant>) repos.findAll();
	}
	@Override
	public Enseignant rechercherEnseignantParId(long id) {
		return repos.findByNoEnseignant(id);
	}

//	@Override
//	public Enseignant rechercherParEmailUbo(String emailUbo)
//	{
////		Enseignant enseignantRecherche = repos.findByEmailUbo(emailUbo);
//		return repos.findByEmailUbo(emailUbo);
//	}
	
	@Override
	public Enseignant rechercherParAdresse(String adresse)
	{
//		Enseignant enseignantRecherche = repos.findByEmailUbo(emailUbo);
		return repos.findByAdresse(adresse);
	}

	@Override
	public void supprimerEnseignantByID(long id) {
		// TODO Auto-generated method stub
		Enseignant e = repos.findByNoEnseignant(id);
		repos.delete(e);
	}


	
	
}
