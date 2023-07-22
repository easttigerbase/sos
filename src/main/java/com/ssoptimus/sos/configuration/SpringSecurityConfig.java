package com.ssoptimus.sos.configuration;

import com.ssoptimus.sos.auth.components.JwtEntryPoint;
import com.ssoptimus.sos.auth.filters.JwtTokenProvider;
import com.ssoptimus.sos.auth.components.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {


    private final JwtTokenProvider jwtTokenProvider;
    private final JwtEntryPoint jwtEntryPoint;

    @Autowired
    public SpringSecurityConfig(JwtTokenProvider jwtTokenProvider, JwtEntryPoint jwtEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtEntryPoint = jwtEntryPoint;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic().disable()// rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
                .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //jwt는 stateless하게 설정.
                .and()



                .authorizeHttpRequests()
                .requestMatchers("/signup", "/login").permitAll()
                .anyRequest().hasRole("USER")
                .and()



                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .cors()
        ;

         return http.build();
    }

}
