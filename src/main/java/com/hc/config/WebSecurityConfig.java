package com.hc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015/8/8.
 */
@Configuration
@EnableWebMvcSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties security;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
//                .loginPage("/admin/login").failureUrl("/admin/login?error").permitAll().and()
//                .logout().permitAll();

        //允许所有用户访问”/”和”/demo”和静态资源
        http.authorizeRequests()
                .antMatchers("/", "/demo", "/login", "/**/*.css", "/**/*.js", "/image/**", "/admin/**").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and().formLogin()
                //指定登录页是”/login”
                .loginPage("/admin/login.html")
//                .failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。   
//              .successHandler(loginSuccessHandler())
                .and().logout()
                //退出登录后的默认网址是"/"
                .logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .and().csrf().disable();
//                .and()
////        登录后记住用户，下次自动登录 
////        数据库中必须存在名为persistent_logins的表 
//        .rememberMe().tokenValiditySeconds(1209600)
////        指定记住登录信息所使用的数据源
//        .tokenRepository(tokenRepository());
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("select username, password, enabled from tb_user where username=?")
                .authoritiesByUsernameQuery("select username, authority from tb_authorities where username=?");
    }
}
