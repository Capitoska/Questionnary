package nk.trainings.backend.repository.impl;

import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RoleEntity findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from RoleEntity where id=:id");
        query.setParameter("id",id);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public RoleEntity findByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from RoleEntity where name=:name");
        query.setParameter("name",name);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public Iterable<RoleEntity> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query =session.createQuery("from RoleEntity");
        return  (Iterable<RoleEntity>) query.getResultList();
    }
}
