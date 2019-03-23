package com.xspeedit.api.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xspeedit.api.service.EmballageService;

/**
 * The Class EmballageController.
 */
@RestController
@RequestMapping("api")
public class EmballageController {

	/** The emballage service. */
	@Autowired
	private EmballageService emballageService;

	/**
	 * Instantiates a new emballage controller.
	 */
	public EmballageController() {
		super();
	}

	/**
	 * Emballer.
	 *
	 * @param chaineColis the chaine colis
	 * @return the response entity
	 */
	@GetMapping("emballer")
	public ResponseEntity<String> emballer(@RequestParam(value = "chaineColis") String chaineColis) {

		// Vérification du paramètre
		if (!NumberUtils.isDigits(chaineColis)) {
			return new ResponseEntity<>("La chaine doit être non vide et constituée uniquement de nombres",
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(emballageService.emballer(chaineColis), HttpStatus.OK);
	}
}
