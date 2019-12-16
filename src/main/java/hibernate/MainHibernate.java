package hibernate;

import java.util.List;

public class MainHibernate {
    public static void main(String[] args) {
        WeatherDao employeeDao = new WeatherDao();
      //  Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
     //   employeeDao.saveEmployee(employee);
        List<Weather> employeesList = employeeDao.getWeather();

        Weather employeeToUpdate = employeesList.get(35);
      //  employeeToUpdate.setSalary(9999);

        employeeDao.updateEmployees(employeeToUpdate);
        employeesList.forEach(System.out::println);

        PhoneDao phoneDao = new PhoneDao();

        Phones phones = new Phones("Sony", "Xperia 10");

        phoneDao.savePhones(phones);
        phoneDao.getPhones().forEach(System.out::println);
    }
}
