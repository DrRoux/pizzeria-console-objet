/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Livreur;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class LivreurJpaDao extends JpaDao
{
	public LivreurJpaDao()
	{
		LOGGER = LoggerFactory.getLogger(LivreurJpaDao.class);
	}

	public List<Livreur> listLivreur()
	{
		beginConnexionBdd();
		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l", Livreur.class);
		List<Livreur> listLivreur = query.getResultList();
		closeConnexionBdd();
		return listLivreur;
	}

	public Livreur findLivreur(int id)
	{
		beginConnexionBdd();

		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l WHERE l.id= ?1", Livreur.class);
		query.setParameter(1, id);
		Livreur l = query.getSingleResult();

		closeConnexionBdd();

		return l;
	}
}
