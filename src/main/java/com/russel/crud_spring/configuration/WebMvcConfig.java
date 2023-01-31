package com.russel.crud_spring.configuration;

import com.russel.crud_spring.ConfigurationConstants;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName(ConfigurationConstants.LANGUAGE_PARAM);
        return localeInterceptor;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(ConfigurationConstants.LANGUAGE_BASENAME);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding(ConfigurationConstants.UTF8_ENCODING);
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(resolver.getTemplateEngine());
        resolver.setCharacterEncoding("UTF-8"); // <- this was added
        resolver.setForceContentType(true); // <- this was added
        resolver.setContentType("text/html; charset=UTF-8"); // <- this was added
        registry.viewResolver(resolver);
    }



}
