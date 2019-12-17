package Weather;

import hibernate.ProvinceCity;
import hibernate.ProvinceCityDao;
import hibernate.Weather;
import hibernate.WeatherDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class EmpController {
    private List<Weather> list;
    private List<Voivodship> list2;
    private List<ProvinceCity> list3;
    WeatherDao weatherDao = new WeatherDao();
    ProvinceCityDao provinceCityDao = new ProvinceCityDao();

    public EmpController() {
    }

    @RequestMapping("/zapytaniepogody")
    public ModelAndView showform(){
        return new ModelAndView("zapytaniepogody","command", new Weather());
    }

    @RequestMapping("/spc")
    public ModelAndView spc() { return new ModelAndView("spc","command", new ProvinceCity());}
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("weather") Weather weather){
        WeatherToday weatherToday = new WeatherToday();
        weatherToday.weatherToday(weather.getCity());
        return new ModelAndView("redirect:/viewWeather");
    }


    @RequestMapping("/viewWeatherList")
    public ModelAndView viewWeatherList(){
        list = weatherDao.getWeather();
        return new ModelAndView("viewWeatherList","list", list);
    }
    @RequestMapping(value="/searchProvinceCity", method = RequestMethod.POST)
    public ModelAndView searchProvinceCity(@ModelAttribute("provinceCity") ProvinceCity provinceCity) throws FileNotFoundException {
        ZJakiegoWojewodztwaJestMiasto zJakiegoWojewodztwaJestMiasto = new ZJakiegoWojewodztwaJestMiasto();
        zJakiegoWojewodztwaJestMiasto.listamiast(provinceCity.getCity());
        return new ModelAndView("redirect:/searchlastProvinceCity");
    }

    @RequestMapping("/vievProvinceCityList")
    public ModelAndView viewProvinceList() {
        list3 = provinceCityDao.getProvinceCity();
        return new ModelAndView("vievProvinceCityList", "list3", list3);
    }

    @RequestMapping("/viewWeather")
    public ModelAndView viewWeather() {
        list = weatherDao.getWeather();
        for (int i = 1; i <list.size() ; ) {
            list.remove(0);
        }
        return new ModelAndView("viewWeather", "list", list);
    }
    @RequestMapping("searchlastProvinceCity")
    public ModelAndView searchlastProvinceCity() {
        list3 = provinceCityDao.getProvinceCity();
        for (int i = 1; i <list3.size() ; ) {
            list3.remove(0);
        }
        return new ModelAndView("searchlastProvinceCity","list3", list3);
    }

    @RequestMapping("/TemperaturesInVoivodships")
    public ModelAndView temperaturesInVoivodships() {
        Wojewodztwo wojewodztwo = new Wojewodztwo();
        list2 = wojewodztwo.wojewodztwo();
return new ModelAndView("TemperaturesInVoivodships", "list2", list2);
    }
    @RequestMapping(value="/BackToChoice", method=RequestMethod.POST)
    public ModelAndView backToChoice(){

        return new ModelAndView("redirect:/");
    }
    private Weather getWeatherById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}