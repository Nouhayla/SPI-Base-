package fr.univbrest.dosi.bussiness;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

//c lui de gerer sa classe 
@Component
public class FormationBusinessJPA  implements FormationBussiness {

	private FormationRepository repos ;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {

		this.repos = repos;
	}

	@Override
	public Formation creerFormation(Formation formationACreer) {
		// TODO Auto-generated method stub
		formationACreer.setDebutAccreditation(new Date());
		return repos.save(formationACreer);
		
	}

	@Override
	public List<Formation> rechercherFormationParNom(String nom) {
		return repos.findByNomFormation(nom);
	}

	@Override
	public List<Formation> recupererToutesLesFormations() {
		return (List<Formation>) repos.findAll();
	}

	@Override
	public Formation rechercherFormationParId(String id) {
		return repos.findOne(id);
	}
	/*@Override
	public List<Formation> recupererToutesLesFormationsParId(String codeFormation) {
		// TODO Auto-generated method stub
		return repos.findOne(codeFormation);
	}*/
	public Formation rechercheFormationId(String codeFormation) {
		return repos.findOne(codeFormation);
	}
	//defini repo + injecter par autowired pour que spring puiss injecter repos ds bussiness il faut lui dire faut soccuper de creer bussinees 
	//faut declarrer comme componenet
	


}