package countryapi.controller;

import countryapi.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CodeToCConverter implements Converter<String,Country> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country convert(String s) {
        return countryRepository.findByCode(s);
    }
}
