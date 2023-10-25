package peaksoft.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan(basePackages = "peaksoft")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
@Bean
public SpringResourceTemplateResolver  templateResolver(){
        SpringResourceTemplateResolver springResourceTemplateResolver=new SpringResourceTemplateResolver();
    springResourceTemplateResolver.setApplicationContext(applicationContext);
    springResourceTemplateResolver.setPrefix("/WEB-INF/");
    springResourceTemplateResolver.setSuffix(".html");
    return springResourceTemplateResolver;
}

  @Bean
public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine springTemplateEngine=new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
}


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolvers=new ThymeleafViewResolver();
        resolvers.setTemplateEngine(springTemplateEngine());
        registry.viewResolver(resolvers);
    }
}
