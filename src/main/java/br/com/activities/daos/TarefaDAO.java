package br.com.activities.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.activities.models.Tarefa;
import java.util.List;

@Repository
@Transactional
public class TarefaDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Tarefa tarefa) {
        manager.persist(tarefa);
    }

    public List<Tarefa> listar() {
        return manager.createQuery("select t from Tarefa t", Tarefa.class).getResultList();
    }
}
