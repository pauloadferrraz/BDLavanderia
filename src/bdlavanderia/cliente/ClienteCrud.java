
package bdlavanderia.cliente;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bdlavanderia.hibernate.HibernateUtil;

public class ClienteCrud {

	public void salvar(Cliente cliente) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(cliente);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possivel inserir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operacao de inser��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void atualizar(Cliente cliente) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(cliente);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void excluir(Cliente cliente) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(cliente);
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de exclus�o. Mensagem: " + e.getMessage());
			}
		}
	}

	public List<Cliente> listar() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Cliente> resultado = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Cliente");
			resultado = consulta.list();
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel selecionar clientes. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
	}
	
	public Cliente buscaCliente(int valor) {
		Cliente cliente = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Cliente where cod_cliente = :parametro");
			consulta.setInteger("parametro", valor);
			cliente = (Cliente) consulta.uniqueResult();
			transacao.commit();
			return cliente;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel buscar cliente. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de buscar. Mensagem: " + e.getMessage());
			}
		}
		return cliente;
	}

}
