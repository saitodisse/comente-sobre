package br.com.saitodisse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import br.com.caelum.vraptor.ioc.Component;
import br.com.saitodisse.model.Usuario;

@Component
public class DefaultUsuarioDao implements UsuarioDao {

	private final Session session;

	public DefaultUsuarioDao(Session session) {
		this.session = session;
	}

	public void salvar(Usuario usuario) {
		session.save(usuario);
	}

	public Usuario pesquisar(long id) {
	    Object o = session.load(Usuario.class, id);
	    return (Usuario)o;		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisarTodos() {
	    Query queryResult = session.createQuery("from Usuario");
	    return queryResult.list();
	}

	public Usuario pesquisarPorNome(String nome) {
		String hqlQuery = "from Usuario usu where usu.nome = :nome";
		Query queryResult = session.createQuery(hqlQuery);
		queryResult.setParameter("nome",nome);
	    return (Usuario) queryResult.uniqueResult();
	}
}
