package br.com.activities.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.activities.models.Usuario;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Usuario usuario) {
        manager.persist(usuario);
    }

    public List<Usuario> listar() {
        return manager.createQuery("select t from Usuario t", Usuario.class).getResultList();
    }
}
