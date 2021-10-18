package com.nembotmarius.financeweb.gateway;

import com.nembotmarius.financeweb.gateway.filter.ErrorFilter;
import com.nembotmarius.financeweb.gateway.filter.PostFilter;
import com.nembotmarius.financeweb.gateway.filter.PreFilter;
import com.nembotmarius.financeweb.gateway.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static javax.ws.rs.HttpMethod.*;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {return new PreFilter();}

	@Bean
	public PostFilter postFilter() {return new PostFilter();}

	@Bean
	public ErrorFilter errorFilter() {return new ErrorFilter();	}

	@Bean
	public RouteFilter routeFilter() {return new RouteFilter();	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("https://prod.socecbt.com","https://dev.socecbt.com")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");

				//.allowedOrigins("https://prod.socecbt.com","https://dev.socecbt.com","http://localhost:8080")
			}
		};
	}
}
