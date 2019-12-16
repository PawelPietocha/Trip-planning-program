package database;

import Weather.WeatherToday;
import hibernate.WeatherDao;

public class Main {


    public static void main(String[] args) {
        WeatherDao employeeDao = new WeatherDao();

        WeatherToday weatherToday = new WeatherToday();
        weatherToday.weatherToday("Radom");
    }
}
