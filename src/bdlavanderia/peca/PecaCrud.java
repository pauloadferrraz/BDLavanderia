/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia.peca;

import bdlavanderia.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pauloadriano
 */
public class PecaCrud {
    
    public void salvar(Peca peca) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(peca);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possivel inserir a peca. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operacao de inser��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void atualizar(Peca peca) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(peca);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar a peca. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void excluir(Peca peca) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(peca);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir a peca. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de exclus�o. Mensagem: " + e.getMessage());
			}
		}
	}

	public List<Peca> listar() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Peca> resultado = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Peca");
			resultado = consulta.list();
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel selecionar as pecas. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
	}
	
	public Peca buscaPeca(int valor) {
		Peca peca = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Peca where codigo = :parametro");
			consulta.setInteger("parametro", valor);
			peca = (Peca) consulta.uniqueResult();
			transacao.commit();
			return peca;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel buscar peca. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de buscar. Mensagem: " + e.getMessage());
			}
		}
		return peca;
	}
}
