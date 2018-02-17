package fr.univbrest.dosi.business;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;


import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

import fr.univbrest.dosi.bussiness.PromotionBussiness;
import fr.univbrest.dosi.bussiness.PromotionBussinessJPA;
import fr.univbrest.dosi.repositories.PromotionRepository;


public class PromotionBussinessJPATest {

	PromotionBussiness bussiness;
	
	
	@Test

	public void doitCreerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		bussiness = new PromotionBussinessJPA(repos);
		Promotion promotionACreer = new Promotion(new PromotionPK("2017/2018","Dosi"), "PE","Dosi8" );

		bussiness.creerPromotion(promotionACreer);

		//assertThat(resultat.getDateNaissance()).isCloseTo(new Date(), 1000);
		assertThat(repos.count()).isEqualTo(1);

	}
	@Test
	public void doitChercherPromoSiglePromo() {
		PromotionRepository repos = new PromotionRepositoryList();
		bussiness = new PromotionBussinessJPA(repos);
		Promotion promotionACreer = new Promotion(new PromotionPK("2017/2018","Dosi"), "PE","Dosi8" );

		bussiness.creerPromotion(promotionACreer);

		List<Promotion> resultat = bussiness.rechercheSiglePromotion("Dosi8");
		assertThat(resultat.get(0).getSiglePromotion()).isEqualTo("Dosi8");

		
	}
	
	@Test
	public void doitChercherPromoProcessusStage() {
		PromotionRepository repos = new PromotionRepositoryList();
		bussiness = new PromotionBussinessJPA(repos);
		Promotion promotionACreer = new Promotion(new PromotionPK("2017/2018","Dosi"), "PE","Dosi8" );

		bussiness.creerPromotion(promotionACreer);

		Promotion resultat = bussiness.rechercherParTypeProcessusStage("PE");
		assertThat(resultat.getProcessusStage()).isEqualTo("PE");
		
	}
	@Test
	public void doitSuppUnCandidat() {
		PromotionRepository repos = new PromotionRepositoryList();
		bussiness = new PromotionBussinessJPA(repos);
		Promotion promotionASupp = new Promotion(new PromotionPK("2017/2018","Dosi"), "PE","Dosi8" );

		bussiness.creerPromotion(promotionASupp);

		bussiness.supprimerPromotionByID(promotionASupp.getId());
		assertThat(repos.count()).isEqualTo(0);
		
	}
	@Test
	public void doitChercherParID() {
		PromotionRepository repos = new PromotionRepositoryList();
		bussiness = new PromotionBussinessJPA(repos);
		Promotion promotionACreer = new Promotion(new PromotionPK("2017/2018","Dosi"), "PE","Dosi8" );

		bussiness.creerPromotion(promotionACreer);

		Promotion resultat = bussiness.rechercherPromotionParId(promotionACreer.getId());
		assertThat(resultat.getId()).isEqualTo(new PromotionPK("2017/2018","Dosi"));
		
	}
	
	class PromotionRepositoryList implements PromotionRepository {

		
		private List<Promotion> data;

		public PromotionRepositoryList() {
			data = Lists.newArrayList();
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}



		@Override
		public void delete(Promotion entity) {
         data.remove(entity);			
		}

		@Override
		public void delete(Iterable<? extends Promotion> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(PromotionPK arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Promotion> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Promotion> findAll(Iterable<PromotionPK> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findOne(PromotionPK pk) {
			// TODO Auto-generated method stub
			Promotion liste=new Promotion();
			for(Promotion p : data) {
				if(p.getId()==pk) {
					liste=p;
				}
			}
			return liste;
		}

		@Override
		public <S extends Promotion> S save(S entity) {
			// TODO Auto-generated method stub
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Promotion> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Promotion> findBySiglePromotion(String siglePromotion) {
			// TODO Auto-generated method stub
			List<Promotion> liste=Lists.newArrayList();
			for(Promotion p : data) {
				if(p.getSiglePromotion()==siglePromotion) {
					liste.add(p);
				}
			}
			return liste;
		}

		@Override
		public Promotion findByProcessusStage(String processusStage) {
			Promotion liste=new Promotion();
			for(Promotion p : data) {
				if(p.getProcessusStage()==processusStage) {
					liste=p;
				}
			}
			return liste;
			// TODO Auto-generated method stub
		
      }

		@Override
		public void delete(PromotionPK id) {
			// TODO Auto-generated method stub
			
		}
}
}
