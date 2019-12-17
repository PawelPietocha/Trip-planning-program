package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class WeatherDao extends  HibernateDao {

    public List<Weather> getWeather() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Weather", Weather.class).list();
        }
    }


}
