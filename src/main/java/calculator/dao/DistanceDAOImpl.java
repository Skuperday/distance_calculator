package calculator.dao;

import calculator.model.Distance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class DistanceDAOImpl implements DistanceDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Distance> allDistance() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Distance").list();
    }

    @Override
    public void add(Distance distance) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(distance);
    }

    @Override
    public void delete(Distance distance) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(distance);
    }

    @Override
    public void edit(Distance distance) {
        Session session = sessionFactory.getCurrentSession();
        session.update(distance);
    }

    @Override
    public Distance getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Distance.class, id);
    }
}
