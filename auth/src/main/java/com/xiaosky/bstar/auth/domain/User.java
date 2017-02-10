package com.xiaosky.bstar.auth.domain;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaob on 2017/1/12.
 */
@Entity
@Table(name = "auth_user")
public class User {
    @Id
    @GeneratedValue(generator = "c_uuid")
    @GenericGenerator(name = "c_uuid",strategy = "uuid")
    private String id;
    private String password;

    private String loginName;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name ="auth_user_role",joinColumns ={@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<Role> roles=new HashSet<>();

    public User(String password, String loginName, String name) {
        this.password = password;
        this.loginName = loginName;
        this.name = name;
    }

    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * 重设密码
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return true表示修改成功,flase 表示修改失败
     */
    public boolean restPwd(@NotNull String oldPwd, String newPwd){
        if (this.password.equals(oldPwd)) {
            this.password = newPwd;
            return true;
        }else
            return false;
    }

    /**
     * 给人员加添多种角色
     * @param roles 角色
     */
    public void addRoles(@NotNull Set<Role>roles){
        this.roles.addAll(roles);
        roles.forEach(x->x.getUsers().add(this));
    }
}
