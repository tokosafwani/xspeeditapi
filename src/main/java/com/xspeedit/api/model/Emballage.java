package com.xspeedit.api.model;

/**
 * The Class Emballage.
 */
public class Emballage {

	/** The taille restante. */
	private int tailleRestante = 10;

	/** The colis. */
	private String colis = "";

	/**
	 * Instantiates a new emballage.
	 */
	public Emballage() {
		super();
	}

	/**
	 * Gets the taille restante.
	 *
	 * @return the taille restante
	 */
	public int getTailleRestante() {
		return tailleRestante;
	}

	/**
	 * Sets the taille restante.
	 *
	 * @param tailleRestante the new taille restante
	 */
	public void setTailleRestante(int tailleRestante) {
		this.tailleRestante = tailleRestante;
	}

	/**
	 * Gets the colis.
	 *
	 * @return the colis
	 */
	public String getColis() {
		return colis;
	}

	/**
	 * Sets the colis.
	 *
	 * @param colis the new colis
	 */
	public void setColis(String colis) {
		this.colis = colis;
	}

}
