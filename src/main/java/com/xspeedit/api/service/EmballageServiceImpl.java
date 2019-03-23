package com.xspeedit.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.xspeedit.api.model.Emballage;

/**
 * The Class EmballageServiceImpl.
 */
@Service
public class EmballageServiceImpl implements EmballageService {

	/**
	 * Instantiates a new emballage service impl.
	 */
	public EmballageServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xspeedit.api.service.EmballageService#emballer(java.lang.String)
	 */
	@Override
	public String emballer(String chaineColis) {

		// Récupération des tailles numériques
		List<Integer> taillesColis = new ArrayList<>();
		for (String tailleStr : chaineColis.split("")) {
			taillesColis.add(Integer.valueOf(tailleStr));
		}

		// init liste emballages
		List<Emballage> emballages = new ArrayList<>();
		emballages.add(new Emballage());

		// répartition des colis
		for (Integer colis : taillesColis) {
			// tentive de mettre le colis dans un des emballages
			boolean colisMis = mettreDansUnEmballge(emballages, colis);

			// Si le colis n'a pu être mis dans aucun emballage, nouvel emballage
			if (!colisMis) {
				Emballage unEmballage = new Emballage();
				unEmballage.setColis(unEmballage.getColis().concat(colis.toString()));
				unEmballage.setTailleRestante(unEmballage.getTailleRestante() - colis);
				emballages.add(unEmballage);
			}

		}
		return emballages.stream().map(emb -> emb.getColis()).collect(Collectors.joining("/"));
	}

	/**
	 * Mettre dans un emballge.
	 *
	 * @param emballages the emballages
	 * @param colis      the colis
	 * @return true, if successful
	 */
	private boolean mettreDansUnEmballge(List<Emballage> emballages, Integer colis) {
		// init retour
		boolean retour = false;

		for (Emballage unEmballage : emballages) {

			// Si l'emballage peut contenir le colis, on l'y met
			if (unEmballage.getTailleRestante() >= colis) {
				unEmballage.setColis(unEmballage.getColis().concat(colis.toString()));
				unEmballage.setTailleRestante(unEmballage.getTailleRestante() - colis);

				retour = true;
				break;
			}
		}

		return retour;
	}

}
