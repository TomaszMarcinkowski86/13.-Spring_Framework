package pl.sda.springmvc.springmvcDemo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //tablica stringów dla użytkowników - gdzie mogąwejść
    private static final String[] MATCHERS={"/", "/login","/sign-in","/products", "/h2/**", "/shopcart", "/webjars/**"} ;

    private  static final String[] ADMIN_MATCHERS ={"/admin/**"};

    private final UserDetailsService userDetailsService;

    @Autowired
    public SpringSecurityConfiguration(@Qualifier("userServiceDetailImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void configureGobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    // konfiguracja SpringSecurity - na jakie strony kto może wejsć
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers(MATCHERS)
                .permitAll()
                .antMatchers(ADMIN_MATCHERS).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
