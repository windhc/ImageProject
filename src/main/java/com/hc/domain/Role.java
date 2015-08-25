package com.hc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2015/8/24.
 */
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(length=32)
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Role")
    private Set<User> users;

    public Role(String roleName, Set<User> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
