package calculator.dao;

import calculator.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Repository
public class CityDAOImpl implements  CityDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<City> allCity(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from City").list();
    }

    @Override
    public void add(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(city);
    }

    @Override
    public void delete(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(city);
    }

    @Override
    public void edit(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.update(city);
    }

    @Override
    public City getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(City.class, id);
    }
}