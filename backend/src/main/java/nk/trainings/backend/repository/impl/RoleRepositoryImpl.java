package nk.trainings.backend.repository.impl;

import lombok.Setter;
import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {


    @Setter(onMethod_ = @Autowired)
    protected SessionFactory sessionFactory;

    @Override
    public RoleEntity findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from RoleEntity where id=:id");
        query.setParameter("id",id);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public RoleEntity findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from RoleEntity where name=:name");
        query.setParameter("name",name);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public Iterable<RoleEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query =session.createQuery("from RoleEntity");
        return  (Iterable<RoleEntity>) query.getResultList();
    }
}
