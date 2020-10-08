package countryapi.controller;

import countryapi.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CodeError implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest,
                                         javax.servlet.http.HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        ModelAndView model = new ModelAndView("errors");
        model.addObject("requestUri", httpServletRequest.getQueryString());
        model.addObject("exception", e.getMessage());
        return model;
    }
}
