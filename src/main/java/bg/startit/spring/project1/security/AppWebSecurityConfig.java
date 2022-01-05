package bg.startit.spring.project1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
@Configuration
public class AppWebSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.headers().frameOptions().disable();
    http.httpBasic()
//    http.httpBasic().and().authorizeRequests()

//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/books/{book_id}").hasRole("LIBRARIAN")
//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/history_record/**").hasAnyRole("ADMIN","LIBRARIAN")
//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasAnyRole("ADMIN","LIBRARIAN")
//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/roles/**").hasRole("ADMIN")
//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/books/**").hasAnyRole("ADMIN","LIBRARIAN")
//        .mvcMatchers(HttpMethod.DELETE, "/api/v1/comments/**").hasAnyRole("ADMIN","LIBRARIAN")
//
//        .mvcMatchers(HttpMethod.POST, "/api/v1/roles/**").hasRole("ADMIN")
//        .mvcMatchers(HttpMethod.POST, "/api/v1/users/registration").anonymous()
//        .mvcMatchers(HttpMethod.POST, "/api/v1/comments/**").hasAnyRole("ADMIN","LIBRARIAN", "USER")
//        .mvcMatchers(HttpMethod.POST, "/api/v1/users/**").hasAnyRole("ADMIN", "LIBRARIAN")
//        .mvcMatchers(HttpMethod.POST, "/api/v1/history_record/**").hasAnyRole("ADMIN","LIBRARIAN")
//        .mvcMatchers(HttpMethod.POST, "/api/v1/roles/").hasAnyRole("ADMIN","LIBRARIAN")
//
//        .mvcMatchers(HttpMethod.GET, "/api/v1/books/**").hasAnyRole("ADMIN","LIBRARIAN", "USER")
//        .mvcMatchers(HttpMethod.GET, "/api/v1/comments/**").hasRole("LIBRARIAN")
//        .mvcMatchers(HttpMethod.GET, "/api/v1/users/**").hasAnyRole( "LIBRARIAN","USER")
//        .mvcMatchers(HttpMethod.GET, "/api/v1/roles/**").permitAll()
//        .mvcMatchers(HttpMethod.GET, "/api/v1/history_record/**").hasAnyRole( "ADMIN","LIBRARIAN")
//
//        .mvcMatchers(HttpMethod.PUT, "/api/v1/books/**").hasAnyRole("ADMIN","LIBRARIAN", "USER")
//        .mvcMatchers(HttpMethod.PUT, "/api/v1/comments/**").hasAnyRole("ADMIN","LIBRARIAN", "USER")
//        .mvcMatchers(HttpMethod.PUT, "/api/v1/users/**").hasAnyRole("LIBRARIAN","USER")
//        .mvcMatchers(HttpMethod.PUT, "/api/v1/roles/**").hasRole( "ADMIN")
//        .mvcMatchers(HttpMethod.PUT, "/api/v1/history_record/**").hasAnyRole( "ADMIN","LIBRARIAN")

//        .anyRequest().authenticated()
        .and().csrf().disable();
  }

  @Bean
  public PasswordEncoder getEncoder()
  {
    return new BCryptPasswordEncoder();
  }
}
