package com.example.config;

import com.example.constant.URL;
import com.example.handler.LoginFailureHandler;
import com.example.handler.LoginSuccessHandler;
import com.example.filter.MyJSONAuthFilter;
import com.example.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(URL.ALLOW_LIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .and().logout()
                .and()
                .csrf().disable();
        http.addFilterAt(myJSONAuthFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService()).passwordEncoder(new PasswordEncoder() {
            //密码解密
            @Override
            public String encode(CharSequence charSequence) {
                return ENCODER.encode(charSequence);
            }

            //密码匹配，看输入的密码经过加密与数据库中存放的是否一样
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return ENCODER.matches(charSequence, s);
            }
        });
    }
    //配置加密算法
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //获取用户信息
    @Bean
    public MyUserDetailService myUserDetailService() {
        return new MyUserDetailService();
    }

    //注入自定义Filter，支持JSON传递登录信息（而不是form-data）
    @Bean
    public MyJSONAuthFilter myJSONAuthFilter() throws Exception {
        MyJSONAuthFilter filter = new MyJSONAuthFilter();
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailureHandler());
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
