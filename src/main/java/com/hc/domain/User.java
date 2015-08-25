package com.hc.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by Administrator on 2015/8/24.
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String LastLogin;

    @Column(nullable = false)
    private int LoginCounts;

    @Column(nullable = false)
    private String registerTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", nullable = false)
    private Role role;

    public User(String username, String password, String email, String lastLogin, int loginCounts, String registerTime, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        LastLogin = lastLogin;
        LoginCounts = loginCounts;
        this.registerTime = registerTime;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(String lastLogin) {
        LastLogin = lastLogin;
    }

    public int getLoginCounts() {
        return LoginCounts;
    }

    public void setLoginCounts(int loginCounts) {
        LoginCounts = loginCounts;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
