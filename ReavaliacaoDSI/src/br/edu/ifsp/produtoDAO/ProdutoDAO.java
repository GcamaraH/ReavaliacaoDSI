package br.edu.ifsp.produtoDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

import br.edu.ifsp.model.Produto;

public class ProdutoDAO {

	private EntityManager getEntityManager() {
		EntityManagerFactory eManagerFactory = null;
		EntityManager eManager = null;

		eManagerFactory = Persistence.createEntityManagerFactory("PU");
		eManager = eManagerFactory.createEntityManager();

		return eManager;
	}

	public Produto salvarProduto(Produto p) {
		EntityManager eManager = getEntityManager();

		try {
			eManager.getTransaction().begin();

			if (p.getId() == null) {
				try {
					eManager.persist(p);
				} catch (PersistenceException de) {
					JOptionPane.showMessageDialog(null, "Erro, limite de caracteres excedido");
				p = null;
				}
			} else {
				eManager.merge(p);
			}
			try {
				eManager.getTransaction().commit();
			} catch (RollbackException rbe) {
				JOptionPane.showMessageDialog(null, "Erro, limite de caracteres excedido");
				p = null;
			}
		} finally {
			eManager.close();
		}
		return p;
	}

	public void removeProduto(Integer id) {
		EntityManager eManager = getEntityManager();
		Produto remove = eManager.find(Produto.class, id);

		try {
			eManager.getTransaction().begin();
			eManager.remove(remove);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}

	public Produto fetchProdutoById(Integer id) {
		EntityManager eManager = getEntityManager();
		Produto recovery = null;

		try {
			recovery = eManager.find(Produto.class, id);
			recovery.getNome().isBlank();
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado");
		} finally {
			eManager.close();
		}

		return recovery;
	}

	public List<Produto> fetchProdutoByName() {
		EntityManager eManager = getEntityManager();

		List<Produto> list = null;

		list = (List<Produto>) eManager.createQuery("from Produto").getResultList();

		return list;

	}
}
