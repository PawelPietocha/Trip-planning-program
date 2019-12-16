package Weather;

import hibernate.Weather;
import hibernate.WeatherDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpController {
    private List<Weather> list;


    WeatherDao weatherDao = new WeatherDao();
    public EmpController() {


    }

    @RequestMapping("/zapytaniepogody")
    public ModelAndView showform(){
        return new ModelAndView("zapytaniepogody","command", new Weather());
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("weather") Weather weather){

            WeatherToday weatherToday = new WeatherToday();
            weatherToday.weatherToday(weather.getCity());






        return new ModelAndView("redirect:/viewWeather");
    }

 /*   @RequestMapping(value="/delete", method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam String id){
        lis   return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView edit(@RequestParam String id){
        Employees employees = getEmployeesById(Integer.parseInt(id));
        return new ModelAndView("empform","command", employees);
    }

    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ModelAndView test(){
        System.out.println("Test");
        return new ModelAndView("redirect:/viewemp");
    } */

    @RequestMapping("/viewWeatherList")
    public ModelAndView viewWeatherList(){
        list = weatherDao.getWeather();
        return new ModelAndView("viewWeatherList","list", list);
    }
    @RequestMapping("/viewWeather")
    public ModelAndView viewWeather() {
        list = weatherDao.getWeather();
        for (int i = 1; i <list.size() ; ) {
            list.remove(0);
        }
        return new ModelAndView("viewWeather", "list", list);

    }
    @RequestMapping(value="/BackToChoice", method=RequestMethod.POST)
    public ModelAndView backToChoice(){

        return new ModelAndView("redirect:/");
    }
    private Weather getWeatherById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}