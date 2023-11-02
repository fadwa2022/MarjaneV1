package dao.Impl;

import Entity.PromotionsEntity;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import dao.AbstractDao;
import dao.PromotionDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromotionsDaoImpl implements AbstractDao<PromotionsEntity>, PromotionDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public int save(PromotionsEntity promotion) {
        sessionFactory.getCurrentSession().save(promotion);
        return promotion.getId();    }

    @Override
    public PromotionsEntity get(int id) {
        return sessionFactory.getCurrentSession().get(PromotionsEntity.class, id);

    }

    @Override
    public List<PromotionsEntity> list() {
        List promotions = sessionFactory.getCurrentSession().createQuery("from PromotionsEntity ").list();
        return promotions;
    }

    @Override
    public void update(int id, PromotionsEntity promotion) {
        Session session = sessionFactory.getCurrentSession();
        PromotionsEntity promotion1 = session.byId(PromotionsEntity.class).load(id);
        promotion1.setComment(promotion.getComment());
        promotion1.setIdproduct(promotion.getIdproduct());
        promotion1.setPourcentage(promotion.getPourcentage());
        promotion1.setStatus(promotion.getStatus());
        session.flush();
    }
    @Override
    public void delete(int id) {
        PromotionsEntity promotion = sessionFactory.getCurrentSession().byId(PromotionsEntity.class).load(id);
        sessionFactory.getCurrentSession().delete(promotion);

    }
    @Override
     public List<PromotionsEntity> getPromotionByProductId(int productId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM PromotionsEntity p WHERE p.idproduct = :productId";
        Query<PromotionsEntity> query = session.createQuery(hql, PromotionsEntity.class);
        query.setParameter("productId", productId);
        return query.list();
    }
    @Override
    public List<PromotionsEntity> getPromotionByCategoryId(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM PromotionsEntity p WHERE p.idcategory = :categoryId";
        Query<PromotionsEntity> query = session.createQuery(hql, PromotionsEntity.class);
        query.setParameter("categoryId", categoryId);
        return query.list();
    }
    @Override
    public List<PromotionsEntity> getPromotionsByCategory() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM PromotionsEntity p WHERE p.idcategory IS NOT NULL";
        Query<PromotionsEntity> query = session.createQuery(hql, PromotionsEntity.class);
        return query.list();
    }
}
