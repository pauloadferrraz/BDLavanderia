/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia.servico;

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
public class ServicoCrud {
    
    public void salvar(Servico servico) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(servico);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possivel inserir o servico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operacao de inser��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void atualizar(Servico servico) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(servico);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar o servico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void excluir(Servico servico) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(servico);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir o servico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de exclus�o. Mensagem: " + e.getMessage());
			}
		}
	}

	public List<Servico> listar() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Servico> resultado = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Servico");
			resultado = consulta.list();
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel selecionar servicos. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
	}
	
	public Servico buscaServico(int valor) {
		Servico servico = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Servico where codigo = :parametro");
			consulta.setInteger("parametro", valor);
			servico = (Servico) consulta.uniqueResult();
			transacao.commit();
			return servico;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel buscar servico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de buscar. Mensagem: " + e.getMessage());
			}
		}
		return servico;
	}
}
