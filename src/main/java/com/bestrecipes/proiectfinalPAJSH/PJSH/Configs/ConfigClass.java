package com.bestrecipes.proiectfinalPAJSH.PJSH.Configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.bestrecipes.proiectfinalPAJSH")
@PropertySource({"classpath:application.properties","classpath:superUser.properties"})
public class ConfigClass {
}
