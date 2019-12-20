package Weather;

import hibernate.CityDescription;
import hibernate.CityDescriptionDao;
import hibernate.Distance;
import hibernate.DistanceDao;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class DistanceAndDescriptionApi {

    public static void distance(String cityName1, String cityName2) {
        try {
            String response = new HttpService().connect(Config.APP_URL1 + cityName1 + "|" + cityName2);
            parseJson(response, cityName1, cityName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseJson(String json, String cityName1, String cityName2) {
        double distance;
        JSONObject rootObject = new JSONObject(json);
        distance = rootObject.getDouble("distance");
        Distance dist = new Distance(cityName1, cityName2, distance);
        DistanceDao distanceDao = new DistanceDao();
        distanceDao.saveObject(dist);


    }

    public static void distance(String cityName) throws IOException {


            String response = new HttpService().connect(Config.APP_URL1 + "Radom" + "|" + cityName);
            parseJson2(response, cityName);


    }

    private static void parseJson2(String json, String cityName) {

        JSONObject wikipedia;
        String description;
        double population;
        String homepage;

        JSONObject rootObject = new JSONObject(json);
        JSONArray mainObject = rootObject.getJSONArray("stops");
        JSONObject pierwszyObject = mainObject.getJSONObject(1);


        wikipedia = pierwszyObject.getJSONObject("wikipedia");
        description = wikipedia.getString("abstract");
        population = wikipedia.getDouble("population");
        homepage = wikipedia.getString("home");

        CityDescription cityDescription = new CityDescription(cityName, homepage, population);
        CityDescriptionDao cityDescriptionDao = new CityDescriptionDao();
        cityDescriptionDao.saveObject(cityDescription);


                System.out.println(description);
                System.out.println("Populacja miasta wynosi " +population);
                System.out.println("Strona internetowa miasta " +homepage);


        }
    }


