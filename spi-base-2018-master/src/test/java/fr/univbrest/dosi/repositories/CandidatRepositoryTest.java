package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {

	@Autowired
	CandidatRepository CandidatRepo;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("33", "29200", "EL GHARSS","UAE" );
		Candidat candidat2 = new Candidat("29", "29200", "MORCHID", "UAE");

		CandidatRepo.save(candidat1);
		CandidatRepo.save(candidat2 );
	}
	
	@Test
	public void doitCompterLesCandidats() {
		long resultat = CandidatRepo.count();
		
		assertThat(resultat).isEqualTo(2);
	}
	
	@Test
	public void doitRechercherParNomCandidat() {
		List<Candidat > resultat = CandidatRepo.findByNom("EL GHARSS");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("EL GHARSS");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("33");
	}
	@Test
	public void doitRechercherParUniversiteOrigineCandidat() {
		List<Candidat > resultat = CandidatRepo.findByUniversiteOrigine("UAE");
		
		assertThat(resultat).hasSize(2);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("UAE");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("33");
	}
	
	
}
