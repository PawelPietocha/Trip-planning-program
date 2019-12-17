package hibernate;

import org.hibernate.Session;

import java.util.List;

public class ProvinceCityDao extends HibernateDao {

    public List<ProvinceCity> getProvinceCity() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from ProvinceCity", ProvinceCity.class).list();
        }
    }
}
