package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Entity.AdminEntity;


@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(AdminEntity admin) {
        sessionFactory.getCurrentSession().save(admin);
        return admin.getId();
    }

    @Override
    public AdminEntity get(long id) {
        return sessionFactory.getCurrentSession().get(AdminEntity.class, id);
    }

    @Override
    public List<AdminEntity> list() {
        List<AdminEntity> list = sessionFactory.getCurrentSession().createQuery("from AdminEntity ").list();
        return list;
    }

    @Override
    public void update(long id, AdminEntity admin) {


    }

    @Override
    public void delete(long id) {

    }


}