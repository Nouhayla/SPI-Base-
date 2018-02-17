package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Candidat;

import fr.univbrest.dosi.bussiness.CandidatBussinessJPA;
import fr.univbrest.dosi.repositories.CandidatRepository;




public class CandidatBussinessJPATest {
	
	CandidatBussinessJPA bussiness;

	@Test

	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		bussiness = new CandidatBussinessJPA(repos);
		Candidat candidatACreer = new Candidat("33", "29200", "EL GHARSS","UAE" );

		bussiness.creerCandidat(candidatACreer);

		//assertThat(resultat.getDateNaissance()).isCloseTo(new Date(), 1000);
		assertThat(repos.count()).isEqualTo(1);

	}
	@Test
	public void doitSuppUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		bussiness = new CandidatBussinessJPA(repos);
		Candidat candidatASupprimer = new Candidat("33", "29200", "EL GHARSS","UAE" );
		bussiness.creerCandidat(candidatASupprimer);

		bussiness.supprimerCandidat(candidatASupprimer);
		assertThat(repos.count()).isEqualTo(0);
		
	}
	@Test
	public void doitChercherCandidatNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		bussiness = new CandidatBussinessJPA(repos);
		Candidat candidatAChercher = new Candidat("33", "29200", "EL GHARSS","UAE" );
		bussiness.creerCandidat(candidatAChercher);

		List<Candidat>resultat = bussiness.rechercheNom("EL GHARSS");
		assertThat(resultat.get(0).getNom()).isEqualTo("EL GHARSS");

		
	}
	@Test
	public void doitChercherCandidatUnivOrigine() {
		CandidatRepository repos = new CandidatRepositoryList();
		bussiness = new CandidatBussinessJPA(repos);
		Candidat candidatAChercherUniv = new Candidat("33", "29200", "EL GHARSS","UAE");
		bussiness.creerCandidat(candidatAChercherUniv);
		System.out.println(candidatAChercherUniv.getUniversiteOrigine());

		List<Candidat> resultat = bussiness.rechercheParUniversiteOrigine("UAE");
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("UAE");
		
	}
	
	class CandidatRepositoryList implements CandidatRepository {

		
		private List<Candidat> data;

		public CandidatRepositoryList() {
			data = Lists.newArrayList();
		}
		@Override
		public <S extends Candidat> S save(S entity) {
			// TODO Auto-generated method stub
			data.add(entity);
			return entity;
		}
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Candidat candidat) {
			// TODO Auto-generated method stub
			data.remove(candidat);
			
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNom(String nom) {
			List<Candidat> liste=Lists.newArrayList();
			for(Candidat c : data) {
				if(c.getNom()==nom) {
					liste.add(c);
				}
			}
			return liste;
		}

		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			List<Candidat> liste=Lists.newArrayList();
			for(Candidat c : data) {
				if(c.getUniversiteOrigine().equalsIgnoreCase(universiteOrigine)) {
					liste.add(c);
				}
			}
			return liste;
		}
		
		
	}
	
}
