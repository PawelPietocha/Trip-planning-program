package Weather;

import hibernate.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    private List<Weather> list;
    WeatherDao weatherDao = new WeatherDao();

    private List<Voivodship> list2;

    private List<ProvinceCity> list3;
    ProvinceCityDao provinceCityDao = new ProvinceCityDao();

    private List<Distance> list4;
    DistanceDao distanceDao = new DistanceDao();

    private List<CityDescription> list5;
    CityDescriptionDao cityDescriptionDao = new CityDescriptionDao();

    private List<String> list6;

    public MainController() {
    }
//////////////////////// Weather
    @RequestMapping("/checkWeather")
    public ModelAndView showform(){
        return new ModelAndView("Weather/checkWeather","command", new Weather());
    }

    @RequestMapping("/viewWeather")
    public ModelAndView viewWeather() {
        list = weatherDao.getWeather();
        for (int i = 1; i <list.size() ; ) {
            list.remove(0);
        }
        return new ModelAndView("Weather/viewWeather", "list", list);
    }
    @RequestMapping("/viewWeatherList")
    public ModelAndView viewWeatherList(){
        list = weatherDao.getWeather();
        return new ModelAndView("Weather/viewWeatherList","list", list);
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("weather") Weather weather){
        WeatherTodayApi weatherToday = new WeatherTodayApi();
        weatherToday.weatherToday(weather.getCity());
        return new ModelAndView("redirect:/viewWeather");
    }
/////////////////////////////////////// Voivodships Temperatures

    @RequestMapping("/TemperaturesInVoivodships")
public ModelAndView temperaturesInVoivodships() {
    VoivodshipsApi wojewodztwo = new VoivodshipsApi();
    list2 = wojewodztwo.wojewodztwo();
    return new ModelAndView("Voivodships/TemperaturesInVoivodships", "list2", list2);
}
//////////////////////////////////////// ProvinceCity
    @RequestMapping("/checkProvinceCity")
    public ModelAndView spc() { return new ModelAndView("ProvinceCity/checkProvinceCity","command", new ProvinceCity());}

    @RequestMapping(value="/saveProvinceCity", method = RequestMethod.POST)
    public ModelAndView saveProvinceCity(@ModelAttribute("provinceCity") ProvinceCity provinceCity) throws FileNotFoundException {
        ProvinceCityFromFile zJakiegoWojewodztwaJestMiasto = new ProvinceCityFromFile();
        zJakiegoWojewodztwaJestMiasto.listamiast(provinceCity.getCity());
        return new ModelAndView("redirect:/viewProvinceCity");
    }
    @RequestMapping("/viewProvinceCityList")
    public ModelAndView viewProvinceList() {
        list3 = provinceCityDao.getProvinceCity();
        return new ModelAndView("ProvinceCity/viewProvinceCityList", "list3", list3);
    }

    @RequestMapping("viewProvinceCity")
    public ModelAndView searchlastProvinceCity() {
        list3 = provinceCityDao.getProvinceCity();
        for (int i = 1; i <list3.size() ; ) {
            list3.remove(0);
        }
        return new ModelAndView("ProvinceCity/viewProvinceCity","list3", list3);
    }
    /////////////////////////Distance

    @RequestMapping("/checkDistance")
    public ModelAndView checkDistance() { return new ModelAndView("Distance/checkDistance","command", new Distance());}

    @RequestMapping("viewDistance")
    public ModelAndView viewDistance() {
        list4= distanceDao.getDistance();
        for (int i = 1; i <list4.size() ; ) {
            list4.remove(0);
        }
        return new ModelAndView("Distance/viewDistance", "list4", list4);

        }

    @RequestMapping(value="/saveDistance", method = RequestMethod.POST)
    public ModelAndView saveDistance(@ModelAttribute("distance") Distance distance)  {
        DistanceAndDescriptionApi distanceApi = new DistanceAndDescriptionApi();
        distanceApi.distance(distance.getCity1(), distance.getCity2());
        return new ModelAndView("redirect:/viewDistance");
    }
    @RequestMapping("viewDistanceList")
    public ModelAndView viewDistanceList() {
        list4 = distanceDao.getDistance();
        return new ModelAndView("Distance/viewDistanceList", "list4", list4);
    }
////////////////////////////// Description

    @RequestMapping("/checkDescription")
    public ModelAndView checkDescription() { return new ModelAndView("Description/checkDescription","command", new CityDescription());}

    @RequestMapping("/viewDescriptionList")
    public ModelAndView viewDescriptionList() {
        list5 = cityDescriptionDao.getCityDescription();
        return new ModelAndView("Description/viewDescriptionList", "list5", list5);
    }
    @RequestMapping("viewDescription")
    public ModelAndView viewDescription() {
    list5 =cityDescriptionDao.getCityDescription();
        for (int i = 1; i <list5.size() ; ) {
            list5.remove(0);
        }
        return new ModelAndView("Description/viewDescription", "list5", list5);

    }
    @RequestMapping(value="/saveDescription", method = RequestMethod.POST)
    public ModelAndView saveDescription(@ModelAttribute("cityDescription") CityDescription cityDescription) throws IOException {
        DistanceAndDescriptionApi distanceApi = new DistanceAndDescriptionApi();
        distanceApi.distance(cityDescription.getCity());


        return new ModelAndView("redirect:/viewDescription");
    }





    /////////////////////// Others
    @RequestMapping(value="/BackToChoice", method=RequestMethod.POST)
    public ModelAndView backToChoice(){

        return new ModelAndView("redirect:/");
    }
    private Weather getWeatherById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}