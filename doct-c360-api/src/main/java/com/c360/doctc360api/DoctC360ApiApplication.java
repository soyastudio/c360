package com.c360.doctc360api;
import com.c360.doctc360api.component.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class,
		RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
@EnableCaching
@EnableMongoRepositories
public class DoctC360ApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(DoctC360ApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<WebFilter> webFilter() {
		FilterRegistrationBean<WebFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new WebFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
}
