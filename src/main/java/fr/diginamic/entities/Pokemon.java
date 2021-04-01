/**
 * 
 */
package fr.diginamic.entities;

/**
 * @author manon
 *
 */
public class Pokemon {
	
	private int id;
	private String nom;
	private String type;
	private int pv;
	private int attaque;
	private int defense;
	private int vitesse;
	
	//////// CONSTRUCTEURS ////////
	
	/**
	 * Constructeur vide
	 */
	public Pokemon() {
		super();
	}

	/**
	 * Constructeur
	 * @param int id
	 * @param String nom
	 * @param String type
	 * @param int pv
	 * @param int attaque
	 * @param int defense
	 * @param int vitesse
	 */
	public Pokemon(int id, String nom, String type, int pv, int attaque, int defense, int vitesse) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.pv = pv;
		this.attaque = attaque;
		this.defense = defense;
		this.vitesse = vitesse;
	}
	
	/**
	 * Constructeur
	 * @param String nom
	 * @param String type
	 * @param int pv
	 * @param int attaque
	 * @param int defense
	 * @param int vitesse
	 */
	public Pokemon(String nom, String type, int pv, int attaque, int defense, int vitesse) {
		super();
		this.nom = nom;
		this.type = type;
		this.pv = pv;
		this.attaque = attaque;
		this.defense = defense;
		this.vitesse = vitesse;
	}

	//////// MEHTODES ////////

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return id + " : " + nom + ", type: " + type + ", pv: " + pv + ", attaque: " + attaque
				+ ", defense: " + defense + ", vitesse: " + vitesse;
	}

	//////// GETTERS & SETTERS ////////
	
	/**
	 * Getter
	 * @return @id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return @nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return @type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter
	 * @return @pv
	 */
	public int getPv() {
		return pv;
	}

	/**
	 * Setter
	 * @param pv
	 */
	public void setPv(int pv) {
		this.pv = pv;
	}

	/**
	 * Getter
	 * @return @attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * Setter
	 * @param attaque
	 */
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	/**
	 * Getter
	 * @return @defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Setter
	 * @param defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * Getter
	 * @return @vitesse
	 */
	public int getVitesse() {
		return vitesse;
	}

	/**
	 * Setter
	 * @param vitesse
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}	

}
