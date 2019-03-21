package fr.pizzeria.model;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public enum CategoriePizza
{
	VIANDE ("Viande"),
	SANS_VIANDE ("Sans_Viande"),
	POISSON ("Poisson"),
	INCONNU ("Inconnu");
	
	private String nom; 
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	private CategoriePizza(String nom)
	{
		this.nom = nom;
	}

}
