package br.com.activities.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.activities.models.Departamento;
import java.util.List;

@Repository
@Transactional
public class DepartamentoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Departamento departamento) {
        manager.persist(departamento);
    }

    public List<Departamento> listar() {
        return manager.createQuery("select t from Departamento t", Departamento.class).getResultList();
    }
}
