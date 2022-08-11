package de.secondparts.config;

import de.secondparts.service.impl.CheckoutInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CheckoutInterceptor checkoutInterceptor;


    public WebConfig(CheckoutInterceptor checkoutInterceptor) {
        this.checkoutInterceptor = checkoutInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckoutInterceptor());
    }
}
