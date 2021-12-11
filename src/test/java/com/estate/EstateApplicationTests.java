package com.estate;

import com.estate.assets.models.EstateModel;
import com.estate.components.estateAPIs.EstateRepository;
import com.estate.components.estateAPIs.EstateService;
import com.estate.components.parameters.ParameterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EstateApplicationTests {

	@Autowired
	private EstateService service;

	private final ParameterService parameterService = Mockito.mock(ParameterService.class);

	@Test
	void contextLoads() {
	}

	@Test
	void StateAdd() {
		EstateModel estateModel = new EstateModel("State One",15000,parameterService.getStocks());
		service.addEstate(estateModel);

		EstateModel estateModel2 = service.getEstateById(estateModel.getId().toString());
		assertEquals("State One", estateModel2.getName());
	}

	@Test
	void StateUpdate() {
		EstateModel estateModel = new EstateModel("State One",15000);
		service.addEstate(estateModel);

		EstateModel estateModel2 = service.getEstateById(estateModel.getId().toString());
		estateModel2.setName("State One Edited");
		service.addEstate(estateModel2);

		EstateModel estateModel3 = service.getEstateById(estateModel2.getId().toString());

		assertEquals("State One Edited", estateModel3.getName());
	}

	@Test
	void StateDelete() {
		EstateModel estateModel = new EstateModel("State One",15000);
		service.addEstate(estateModel);

		EstateModel estateModel2 = service.getEstateById(estateModel.getId().toString());

		assertNotNull(estateModel2);
		service.deleteEstate(estateModel2.getId().toString());

		EstateModel estateModel3 = service.getEstateById(estateModel.getId().toString());
		assertNull(estateModel3);
	}
}
