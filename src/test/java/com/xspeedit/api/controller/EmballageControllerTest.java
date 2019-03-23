package com.xspeedit.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.xspeedit.api.service.EmballageService;

/**
 * The Class EmballageControllerTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EmballageController.class)
public class EmballageControllerTest {

	/** The mvc. */
	@Autowired
	private MockMvc mvc;

	/** The emballage service. */
	@MockBean
	private EmballageService emballageService;

	/**
	 * Test emballer parametre vide.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmballerParametreVide() throws Exception {
		mvc.perform(get("/api/emballer?chaineColis=").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	/**
	 * Test emballer parametre non numerique.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmballerParametreNonNumerique() throws Exception {
		mvc.perform(get("/api/emballer?chaineColis=jnjl54685586").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	/**
	 * Test emballer parametre ok.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmballerParametreOk() throws Exception {
		Mockito.when(emballageService.emballer("54685586")).thenReturn("54/6/8/55/8/6");

		mvc.perform(get("/api/emballer?chaineColis=54685586").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string("54/6/8/55/8/6"));
	}
}
