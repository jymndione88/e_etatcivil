package com.administration.etatcivil.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.administration.etatcivil.entities.Communes;
import com.administration.etatcivil.repositories.CommuneRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommuneTest {

	@Autowired
	private CommuneRepository metier;
	Communes arrondissements;
	
	@Autowired
	public CommuneTest(Communes arrondissements){
		this.arrondissements= arrondissements;
	}
	
	@BeforeEach
	void beforeEach(@Autowired Communes arrondissements) {
		this.arrondissements= arrondissements;
	}
	
	@DisplayName("check si instanciation objet dans le constructeur marche")
	@Test
	public void checkInstanciationConstructeur() {
		assertNotNull(metier);
		assertTrue(metier.count()>0); 
	}
	
	@DisplayName("check si instanciation objet dans le constructeur avec parametre marche")
	@Test
	public void checkInstanciationConstructeurParametre(@Autowired Communes arrondissements) {
		assertNotNull(arrondissements);
		assertTrue(arrondissements.getId()>0); 
	}

	@DisplayName("test fonction get all arrondissements")
	@Test
	public void testGetAllArrondissements() {
		List<Communes> arr=	metier.findAll();	
		assertEquals(arr, metier.findAll()); 
	}
	
}
