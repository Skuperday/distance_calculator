package calculator.controller;

import calculator.model.City;
import calculator.model.Distance;
import calculator.service.CityService;
import calculator.service.CityServiceImpl;
import calculator.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class CalcController {

    private CityService cityService;
    private DistanceService distanceService;

    @Autowired
    public void setDistanceService(DistanceService distanceService){
        this.distanceService = distanceService;
    }
    @Autowired
    public void setCityService(CityService cityService){
        this.cityService = cityService;
    }

    //list of all cities in the DB endpoint
    @GetMapping(value = "/")
    public ModelAndView allCities() {
        List<City> cities = cityService.allCity();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cities");
        modelAndView.addObject("citiesList", cities);
        return modelAndView;
    }
    @GetMapping(value = "/calculator")
    public ModelAndView calculator() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculate");
        return modelAndView;
    }
    @PostMapping(value = "/calculator")
    public ModelAndView calculate(
            @RequestParam(value = "fromCity") String fromCityName,
            @RequestParam(value = "toCity") String toCityName,
            @RequestParam(value = "option") String option
    ){
        ModelAndView modelAndView = new ModelAndView();
        String notOption = "incorrect Option";
        String notFound = "city not found";
        if (option.equals("Straight")) {
        List<City> cities = cityService.allCity();
        City fromCity = (City) cities.stream()
                .filter(city -> fromCityName.equals(city.getName()))
                .findAny()
                .orElse(null);
        City toCity = (City) cities.stream()
                .filter(city -> toCityName.equals(city.getName()))
                .findAny()
                .orElse(null);
        if (fromCity == null || toCity == null) {
            modelAndView.setViewName("calculate");
            modelAndView.addObject("result", notFound);
            return modelAndView;
        }
        double distanceBetween = fromCity.distanceTo(toCity);
        String result = String.format("%8.2f km", distanceBetween);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("calculate");
        return modelAndView;
    } else if (option.equals("Matrix")){
            List<Distance> distances = distanceService.allDistance();
            Distance distanceTo = distances.stream()
                    .filter(distance -> fromCityName.equals(distance.getFromCity()) && toCityName.equals(distance.getToCity()))
                    .findAny()
                    .orElse(null);
            if (distanceTo == null){
                modelAndView.setViewName("calculate");
                modelAndView.addObject("result", notFound);
            }
            String result = String.format("%9.2f km", distanceTo.getDistance());
            modelAndView.addObject("result", result);
        modelAndView.setViewName("calculate");
        return modelAndView;
    } else {
            modelAndView.addObject("result", notOption);
    }       modelAndView.setViewName("calculate");
        return modelAndView;
    }
    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @PostMapping(value = "/add")
    public ModelAndView addCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.add(city);
        return modelAndView;
   }
    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable int id){
        City city = cityService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("city", cityService.getById(id));
        return modelAndView;
    }
    @PostMapping(value="/edit")
    public ModelAndView editCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        cityService.edit(city);
        return modelAndView;
    }
    @GetMapping(value="/delete/{id}")
    public ModelAndView deleteCity(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        City city = cityService.getById(id);
        cityService.delete(city);
        return modelAndView;
    }
}