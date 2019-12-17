package Weather;

import hibernate.Weather;
import hibernate.WeatherDao;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class WeatherTodayApi {

    public static void weatherToday(String cityName) {

        try {
            String response = new HttpService().connect(Config.APP_URL + "q=" + cityName + "&appid=" + Config.apiKey);
            parseJson(response, cityName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseJson(String json, String cityName) {
        double temp;
        int humidity;
        int pressure;
        int clouds;
        String description;
        JSONObject descriptionObject = new JSONObject(json);
        JSONObject rootObject = new JSONObject(json);
        if (rootObject.getInt("cod") == 200) {
            JSONObject mainObject = rootObject.getJSONObject("main");
            java.text.DecimalFormat df=new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);

            temp = mainObject.getDouble("temp");
            temp = temp - 273;
            JSONArray weatherArray =rootObject.getJSONArray("weather");
            descriptionObject = weatherArray.getJSONObject(0);
            description = descriptionObject.getString("description");
            humidity = mainObject.getInt("humidity");
            pressure = mainObject.getInt("pressure") ;
            JSONObject cloudsObject = rootObject.getJSONObject("clouds");
            clouds = cloudsObject.getInt("all");
            String temp1 = df.format(temp);


            Weather weather = new Weather(cityName, temp1, humidity, clouds, pressure, description, new Date());
            System.out.println(weather.toString());
            WeatherDao employeeDao = new WeatherDao();
            employeeDao.saveObject(weather);



            System.out.println("Temperatura: " + df.format(temp) + " \u00b0C");
            System.out.println("Wilgotność: " + humidity + " %");
            System.out.println("Zachmurzenie: " + clouds + "%");
            System.out.println("Ciśnienie: " + pressure + " hPa");
            System.out.println("Opis pogody: " +description);


        } else {
            System.out.println("Error");
        }
    }
}





