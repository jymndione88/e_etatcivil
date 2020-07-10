package com.administration.etatcivil.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.administration.etatcivil.controllers.CommuneController;
import com.administration.etatcivil.entities.Communes;
import com.administration.etatcivil.repositories.CommuneRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@RunWith(JUnitPlatform.class)
@SpringBootTest
//@ExtendWith(MockitoExtension.class)

@DisplayName("demarrage avec junit 5 et mockito")
public class CommuneTestMock {

	@InjectMocks
    private CommuneController metierController;

    @Mock 
    private CommuneRepository metierRepository;

	
	 @BeforeEach
	 public void init() {
	        MockitoAnnotations.initMocks(this);
	    }

	
	@DisplayName("check si instanciation objet constructeur avec parametre et mock")
	@Test
	public void checkGetArrondissementById(@Mock Communes arrondissements) {
		assertNotNull(arrondissements);
		 Optional<Communes> arr= metierRepository.findById(Long.getLong("1"));	
		 assertEquals("Hello Mockito From Repository", arr.get()); 
	}

	
}
