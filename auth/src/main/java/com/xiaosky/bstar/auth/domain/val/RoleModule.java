package com.xiaosky.bstar.auth.domain.val;

import com.xiaosky.bstar.auth.domain.Module;
import com.xiaosky.bstar.auth.domain.Role;
import org.hibernate.annotations.Parent;

import javax.persistence.*;

/**
 * 角色对应到模块所拥有的权限编码
 * Created by xiaob on 2017/1/16.
 */
@Embeddable
public class RoleModule {
    @ManyToOne(fetch = FetchType.LAZY,optional = false,targetEntity = Module.class)
    @JoinColumn(name = "moduleId",nullable = false,updatable = false)
    private Module module;
    private String number;
    @Parent
    private Role role;
  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/

    public Module getModule() {
        return module;
    }

    public String getNumber() {
        return number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
