package com.xspeedit.api.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class EmballageServiceImplTest.
 */
@RunWith(SpringRunner.class)
public class EmballageServiceImplTest {

	@TestConfiguration
	static class EmballageServiceImplTestContextConfiguration {

		@Bean
		public EmballageService emballageService() {
			return new EmballageServiceImpl();
		}
	}

	/** The emballage service. */
	@Autowired
	private EmballageService emballageService;

	/**
	 * Test emballer.
	 */
	@Test
	public void testEmballer() {
		Assert.assertEquals("163/81/46/82/9/55/73/7", emballageService.emballer("163841689525773"));
	}
}
