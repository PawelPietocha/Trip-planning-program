package hibernate;

import org.hibernate.Session;

import java.util.List;

public class DistanceDao extends HibernateDao {

    public List<Distance> getDistance() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Distance", Distance.class).list();
        }
    }
}
