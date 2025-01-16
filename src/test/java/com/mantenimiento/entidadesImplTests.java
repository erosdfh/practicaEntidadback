package com.mantenimiento;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mantenimiento.controllers.EntidadController;
import com.mantenimiento.dtos.InsertEntidadDto;
import com.mantenimiento.services.EntidadService;

@WebMvcTest(EntidadController.class)
class entidadesImplTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EntidadService entidadService;
	
	
	private InsertEntidadDto entidad;
	
	@BeforeEach
	void setup() {
	}
	
	@Test
	public void insertEntidad() throws Exception {
		Integer resp=1;
		Mockito.when(entidadService.insertEntidad(entidad)).thenReturn(resp);
		mockMvc.perform(post("/insert-entidad").contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void updateEntidad() throws Exception {
		Integer resp=1;
		Mockito.when(entidadService.updateEntidad(entidad)).thenReturn(resp);
		mockMvc.perform(post("/update-entidad").contentType(MediaType.APPLICATION_JSON));
	}

}
