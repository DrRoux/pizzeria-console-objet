package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;

public class CommandesJpaDao extends JpaDao
{
	LivreurJpaDao lJpaDao = new LivreurJpaDao();

	public CommandesJpaDao()
	{
		logger = LoggerFactory.getLogger(CommandesJpaDao.class);
	}

	public List<Commande> listerCommandesClient(Client client)
	{
		beginConnexionBdd();

		EntityGraph<?> graph = this.em.getEntityGraph("graph.Commande.listComPiz");

		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE client_id = ?1", Commande.class);
		query.setHint("javax.persistence.fetchgraph", graph);
		query.setParameter(1, client);

		List<Commande> listClients = query.getResultList();

		closeConnexionBdd();

		return listClients;
	}

	public List<Commande> listerCommandesAttente()
	{
		beginConnexionBdd();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE status = 0", Commande.class);
		List<Commande> listClients = query.getResultList();

		closeConnexionBdd();

		return listClients;
	}

	public void ajoutCommande(Client client, Commande commande)
	{
		beginConnexionBdd();
		commande.setClientId(client);
		commande.setLivreurId(null);
		ajout(commande);
		closeConnexionBdd();
	}

	public void associerLivreurCommande(int commande, int livreur)
	{
		beginConnexionBdd();
		Livreur l = lJpaDao.findLivreur(livreur);
		Commande c = em.find(Commande.class, commande);
		c.setLivreurId(l);
		modif(c);
		closeConnexionBdd();
	}

	public void expedierCommande()
	{
		beginConnexionBdd();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("UPDATE FROM Commande c SET c.status=1 WHERE c.livreur_id IS NOT NULL");
		query.executeUpdate();
		et.commit();
		closeConnexionBdd();
	}
}
