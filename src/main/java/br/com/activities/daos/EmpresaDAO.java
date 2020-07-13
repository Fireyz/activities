package br.com.activities.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.activities.models.Empresa;
import java.util.List;

@Repository
@Transactional
public class EmpresaDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Empresa empresa) {
        manager.persist(empresa);
    }

    public List<Empresa> listar() {
        return manager.createQuery("select e from Empresa e", Empresa.class).getResultList();
    }
}
