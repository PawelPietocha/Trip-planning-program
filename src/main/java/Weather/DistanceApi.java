package Weather;

import hibernate.Distance;
import hibernate.DistanceDao;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class DistanceApi {

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

    public static void odleglosc(String cityName1, int a) {
        try {
            String response = new HttpService().connect(Config.APP_URL1 + "Radom" + "|" + cityName1);
            switch (a) {
                case 1:

                    parseJson2(response,1);
                    break;

                case 2:
                    parseJson2(response,2);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseJson2(String json, int a) {

        JSONObject wikipedia;
        JSONArray near;
        String opis;
        double population;
        String homepage;
        JSONObject rootObject = new JSONObject(json);
        JSONArray mainObject = rootObject.getJSONArray("stops");
        JSONObject pierwszyObject = mainObject.getJSONObject(1);

        near = pierwszyObject.getJSONArray("nearByCities");
        wikipedia = pierwszyObject.getJSONObject("wikipedia");
        opis = wikipedia.getString("abstract");
        population = wikipedia.getDouble("population");
        homepage = wikipedia.getString("home");


        switch (a) {
            case 1:

                System.out.println(opis);
                System.out.println("Populacja miasta wynosi " +population);
                System.out.println("Strona internetowa miasta " +homepage);
                break;
            case 2:
                for (int i = 0; i < near.length(); i++) {
                    System.out.println(near.get(i));

                }
                break;
        }
    }
}

