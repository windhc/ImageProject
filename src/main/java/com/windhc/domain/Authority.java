package com.windhc.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限
 *
 * @author Administrator
 * @date 2015/8/27
 */
@Table(name = "tb_authorities")
public class Authority {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String username;

    private String authority;

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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
