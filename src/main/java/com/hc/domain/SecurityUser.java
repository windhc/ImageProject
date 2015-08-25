//package com.hc.domain;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * Created by Administrator on 2015/8/24.
// */
//public class SecurityUser extends User implements UserDetails {
//
//    private static final long serialVersionUID = 1L;
//    public SecurityUser(User user) {
//        if(user != null)
//        {
//            this.setId(user.getId());
//            this.setUsername(user.getUsername());
//            this.setEmail(user.getEmail());
//            this.setPassword(user.getPassword());
//            this.setLastLogin(user.getLastLogin());
//            this.setRegisterTime(user.getRegisterTime());
//            this.setLoginCounts(user.getLoginCounts());
//
//            this.setRole(user.getRole());
//        }
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.getRole().getRoleName());
//        authorities.add(authority);
//
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
////        return super.getEmail(); //可以将Email映射成username
//        return super.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
