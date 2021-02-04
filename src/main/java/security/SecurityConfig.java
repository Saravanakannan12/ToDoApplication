package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import Utility.ConstantUtils;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
public void configureGlobalSecurity1(AuthenticationManagerBuilder auth)
        throws Exception {
    auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
    		.withUser(ConstantUtils.userName).password(ConstantUtils.password)
            .roles("USER", "ADMIN");
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
            .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
            .formLogin();
    
    http.csrf().disable();
    http.headers().frameOptions().disable();
}

}
