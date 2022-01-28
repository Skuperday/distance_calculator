package calculator.controller;

import calculator.model.City;
import calculator.service.CityService;
import calculator.service.CityServiceImpl;
import calculator.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/")
    public ModelAndView allCities() {
        List<City> cities = cityService.allCity();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cities");
        modelAndView.addObject("citiesList", cities);
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
    //GET POST PUT DELETE implementation
    @GetMapping(value = "/cities")
    public ResponseEntity<List<City>> read(){
        List<City> cities = cityService.allCity();
        return  cities != null && !cities.isEmpty()
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @PostMapping(value = "/add")
//    public ResponseEntity<?> add(@RequestBody City city){
//        cityService.add(city);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}