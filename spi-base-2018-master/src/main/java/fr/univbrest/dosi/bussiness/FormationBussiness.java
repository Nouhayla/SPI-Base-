package fr.univbrest.dosi.bussiness;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public interface FormationBussiness {
	Formation creerFormation(Formation formationACreer);

	 List<Formation> recupererToutesLesFormations();
	 List<Formation> rechercherFormationParNom(String nom);
	 //List<Formation> recupererToutesLesFormationsParId(String id);
	 Formation rechercherFormationParId(String id);

}
