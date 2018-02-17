package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bussiness.EnseignantBusiness;
import fr.univbrest.dosi.bussiness.EnseignantBusinessJPA;
import fr.univbrest.dosi.repositories.EnseignantRepository;


public class EnseignantBusinessJPATest {
	
	EnseignantBusiness bussiness;
	
	
	@Test

	public void doitCreerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		bussiness = new EnseignantBusinessJPA(repos);
		Enseignant enseignantACreer = new Enseignant(12, "elgharss@univbrest.com","elgharss","Brest" );
		
		bussiness.creerEnseignant(enseignantACreer);

		//assertThat(resultat.getDateNaissance()).isCloseTo(new Date(), 1000);
		assertThat(repos.count()).isEqualTo(1);

	}
	@Test
	public void doitSuppUnCandidat() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		bussiness = new EnseignantBusinessJPA(repos);
		Enseignant enseignantACreer = new Enseignant(12, "2,rue des archives","elgharss@univbrest.com","elgharss" );
		Enseignant enseignantACreer2 = new Enseignant(13, "4,rue des archives","elgharss@univbrest.com","elgharss" );
		
		bussiness.creerEnseignant(enseignantACreer);
		bussiness.creerEnseignant(enseignantACreer2);
		bussiness.supprimerEnseignantByID(12);
		assertThat(repos.count()).isEqualTo(1);
		
	}
	@Test
	public void doitChercherParID() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		bussiness = new EnseignantBusinessJPA(repos);
		Enseignant enseignantACreer = new Enseignant(12, "2,rue des archives","elgharss@univbrest.com","elgharss" );
		
		bussiness.creerEnseignant(enseignantACreer);
		Enseignant resultat = bussiness.rechercherEnseignantParId(12);
		assertThat(resultat.getNoEnseignant()).isEqualTo(12);
		
	}
	@Test
	public void doitChercherEnseignantParNom() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		bussiness = new EnseignantBusinessJPA(repos);
		Enseignant enseignantACreer = new Enseignant(12, "2,rue des archives","elgharss@univbrest.com","elgharss" );
		
		bussiness.creerEnseignant(enseignantACreer);
		List<Enseignant> resultat = bussiness.rechercheEnseignantParNom("elgharss");
		assertThat(resultat.get(0).getNom()).isEqualTo("elgharss");

		
	}
	
	@Test
	public void doitChercherEnseignantParAdress() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		bussiness = new EnseignantBusinessJPA(repos);
		Enseignant enseignantACreer = new Enseignant(12, "2,rue des archives","elgharss@univbrest.com","elgharss" );
	
		
		bussiness.creerEnseignant(enseignantACreer);
		Enseignant resultat = bussiness.rechercherParAdresse("2,rue des archives");
		assertThat(resultat.getAdresse()).isEqualTo("2,rue des archives");
		
	}
	class EnseignantRepositoryList implements EnseignantRepository {

		
		private List<Enseignant> data;

		public EnseignantRepositoryList() {
			data = Lists.newArrayList();
		}

		@Override
		public <S extends Enseignant> S save(S entity) {
			// TODO Auto-generated method stub
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Enseignant entity) {
			// TODO Auto-generated method stub
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Enseignant> findByNom(String nom) {
			// TODO Auto-generated method stub
			List<Enseignant> liste=Lists.newArrayList();
			for(Enseignant p : data) {
				if(p.getNom()==nom) {
					liste.add(p);
				}
			}
			return liste;
		}

		@Override
		public Enseignant findByNoEnseignant(long id) {
			// TODO Auto-generated method stub
			Enseignant enseignant=new Enseignant();
			for(Enseignant e : data) {
				if(e.getNoEnseignant()==id) {
					enseignant=e;
				}
			}
			return enseignant;
		}

//		@Override
//		public Enseignant findByEmailUbo(String emailUbo) {
//			// TODO Auto-generated method stub
//			Enseignant enseignant=new Enseignant();
//			for(Enseignant e : data) {
//				if(e.getEmailUbo()==emailUbo) {
//					enseignant=e;
//				}
//			}
//			return enseignant;
//		}

		@Override
		public Enseignant findByAdresse(String adresse) {
			// TODO Auto-generated method stub
			Enseignant enseignant=new Enseignant();
			for(Enseignant e : data) {
				if(e.getAdresse()==adresse) {
					enseignant=e;
				}
			}
			return enseignant;
		}

		@Override
		public Enseignant findByEmailUbo(String emailUbo) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
