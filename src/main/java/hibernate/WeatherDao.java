package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class WeatherDao {

    public void saveWeather(Weather employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Weather> getWeather() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Weather", Weather.class).list();
        }
    }

    public void updateEmployees(Weather weather) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(weather);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
