package com.codegym.on_tap.controller;

import com.codegym.on_tap.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@CrossOrigin("*")
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    MessageSource messageSource;

    @GetMapping
    public Language getLanguage(@RequestParam(defaultValue = "en") String lg) {
        String home = messageSource.getMessage("home", null, new Locale(lg));
        String user = messageSource.getMessage("user", null, new Locale(lg));
        String product = messageSource.getMessage("product", null, new Locale(lg));
        return new Language(user, home, product);
    }
}
