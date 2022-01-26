package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CalcController {

    @GetMapping(value = "/")
    public ModelAndView calculate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
}