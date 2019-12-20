package hibernate;

import org.hibernate.Session;

import java.util.List;

public class CityDescriptionDao extends HibernateDao {

    public List<CityDescription> getCityDescription() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from CityDescription", CityDescription.class).list();
        }
    }
}
