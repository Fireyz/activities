package br.com.activities.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.activities.models.Tipo;
import java.util.List;

@Repository
@Transactional
public class TipoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Tipo tipo) {
        manager.persist(tipo);
    }

    public List<Tipo> listar() {
        return manager.createQuery("select t from Tipo t", Tipo.class).getResultList();
    }
}
