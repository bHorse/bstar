package com.xiaosky.bstar.auth.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaob on 2017/1/16.
 */
@Entity(name = "auth_role")
public class Role {
    @Id
    @GeneratedValue(generator = "c_uuid")
    @GenericGenerator(strategy = "uuid",name = "c_uuid")
    private String id;
    private String name;
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.MERGE)
    private Set<User> users=new HashSet<>();
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    /**
     * 为该角色添加用户
     * @param users
     */
    public void addUsers(Set<User>users){
        users.forEach(u->u.getRoles().add(this));
        this.getUsers().addAll(users);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equals(role.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
