package np.com.bigbrackets.jobportal.config;


import np.com.bigbrackets.jobportal.auth.JwtRequestFilter;
import np.com.bigbrackets.jobportal.entity.users.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()

                .antMatchers("/authenticate").permitAll()
                .antMatchers("/signup").permitAll()

                .antMatchers(HttpMethod.GET, "/jobs").permitAll()
                .antMatchers(HttpMethod.GET, "/jobs/**").permitAll()
                .antMatchers("/jobs/**").hasRole("EMPLOYER")

                .antMatchers("/upload").permitAll()

                .antMatchers("/applied-jobs/users").hasRole("APPLICANT")
                .antMatchers("/applied-jobs/company").hasRole("EMPLOYER")
                .antMatchers("/applied-jobs/jobs/{\\d+}/applicant/{\\d+}").hasRole("EMPLOYER")
                .antMatchers("/applied-jobs/users/job/{\\d+}").hasRole("APPLICANT")
                .antMatchers("/applied-jobs/**").hasRole("APPLICANT")

                .antMatchers("/profiles").hasAnyRole("APPLICANT", "EMPLOYER")

                .anyRequest().authenticated()

                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }
}
