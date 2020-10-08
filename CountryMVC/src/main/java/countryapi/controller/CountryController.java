package countryapi.controller;

import countryapi.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CodeError codeError;

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/world")
    public String findAll(Model model){
        model.addAttribute("continents", countryRepository.getContinents());
        return "continents";
    }

    @RequestMapping(value="/world/country", method = RequestMethod.POST)
    public String getCountries(Model model, @RequestParam String s){
        System.out.println(s);
        model.addAttribute("countries",countryRepository.findByContinent(s));
        return "countries";
    }

    @RequestMapping(value="/world/country", params="code")
    public String getCountry(Model model, @RequestParam("code") Country code) throws Exception{
        if (code != null) {
            model.addAttribute("country_by_code", code);
            return "country";
        } else throw new Exception("No country with that code exists");
    }

    @RequestMapping("/errors")
    public String gotError(Model model){

        return "errors";
    }

    @ModelAttribute("continents")
    public List<String> getGenres(){
        return countryRepository.getContinents();
    }



}
