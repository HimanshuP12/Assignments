package com.restfulPart1.assignment.restfulwebservicepart1.Controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorld(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @GetMapping("/Hello {Username}")
    public String helloUserName(@PathVariable String Username){
        Locale locale= LocaleContextHolder.getLocale();
        Object[] obj=new Object[]{Username};
        return messageSource.getMessage("message.hello",obj,"Default Message",locale);
    }
}
