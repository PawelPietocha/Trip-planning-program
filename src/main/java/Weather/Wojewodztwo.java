package Weather;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wojewodztwo {

    public List<Voivodship> wojewodztwo() {
        ArrayList<String> listaStolicWojewodztw = new ArrayList<>();
        ArrayList<Voivodship> list = new ArrayList<>();
        listaStolicWojewodztw.add("Warszawa");
        listaStolicWojewodztw.add("Szczecin");
        listaStolicWojewodztw.add("Gdansk");
        listaStolicWojewodztw.add("Olsztyn");
        listaStolicWojewodztw.add("Bialystok");
        listaStolicWojewodztw.add("Zielona+Gora");
        listaStolicWojewodztw.add("Poznan");
        listaStolicWojewodztw.add("Bydgoszcz");
        listaStolicWojewodztw.add("Lodz");
        listaStolicWojewodztw.add("Lublin");
        listaStolicWojewodztw.add("Kielce");
        listaStolicWojewodztw.add("Rzeszow");
        listaStolicWojewodztw.add("Krakow");
        listaStolicWojewodztw.add("Katowice");
        listaStolicWojewodztw.add("Opole");
        listaStolicWojewodztw.add("Wroclaw");


        for (int i = 0; i < listaStolicWojewodztw.size(); i++) {

            try {
                String response = new HttpService().connect(Config.APP_URL + "q=" + listaStolicWojewodztw.get(i) + "&appid=" + Config.apiKey);
                list.add(new Voivodship(listaStolicWojewodztw.get(i),parseJson(response)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
return list;
    }



    private static String parseJson(String json) {
        Double temp = null;
        String temp1=null;

        JSONObject rootObject = new JSONObject(json);
        if (rootObject.getInt("cod") == 200) {
            JSONObject mainObject = rootObject.getJSONObject("main");
            temp = mainObject.getDouble("temp");
             temp = temp - 273;
            java.text.DecimalFormat df=new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
             temp1 = df.format(temp);
        }
        return temp1;
    }
}
