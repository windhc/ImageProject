package com.hc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by Administrator on 2015/8/8.
 */
@Configuration
@EnableWebMvcSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties security;

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

//    @Autowired
//    @Qualifier("dataSource")
//    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
//                .loginPage("/admin/login").failureUrl("/admin/login?error").permitAll().and()
//                .logout().permitAll();

        //允许所有用户访问”/”和”/home”和静态资源
        http.authorizeRequests()
                .antMatchers("/", "/demo", "/**/*.css", "/**/*.js", "/image/**", "/admin/login.html").permitAll()
        //其他地址的访问均需验证权限
                .anyRequest().authenticated().and().formLogin()
        //指定登录页是”/login”
                .loginPage("/login")
                .permitAll()
        //登录成功后可使用loginSuccessHandler()存储用户信息，可选。   
//        .successHandler(loginSuccessHandler())
                .and().logout()
        //退出登录后的默认网址是"/"
        .logoutSuccessUrl("/").permitAll()
        .invalidateHttpSession(true);
//                .and()
////        登录后记住用户，下次自动登录 
////        数据库中必须存在名为persistent_logins的表 
//        .rememberMe().tokenValiditySeconds(1209600)
////        指定记住登录信息所使用的数据源
//        .tokenRepository(tokenRepository());
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //指定密码加密所使用的加密器为passwordEncoder()
//        //需要将密码加密后写入数据库
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//        //不删除凭据，以便记住用户
//        auth.eraseCredentials(false);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(4);
//    }
//
//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository(){
//        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
//        j.setDataSource(dataSource);
//        return j;
//    }

//    @Bean
//    public LoginSuccessHandler loginSuccessHandler(){
//        return new LoginSuccessHandler();
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123").roles("ADMIN", "USER").and()
                .withUser("user").password("123").roles("USER");
    }
}
