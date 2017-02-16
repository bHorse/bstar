package com.xiaosky.bstar.auth.domain;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
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

    /**
     * 判断该用户对于该菜单是否拥有访问权限
     * @param menu
     * @return
     */
    public boolean hasPermissionByMenu(@NotNull Menu menu){
        for(Role role:roles){
            int permissCode = Integer.parseInt(role.getCodeByModule(menu.getModule()).orElse("0"),2);//如果为空,表示对该模块没有任何权限
            int number = Integer.parseInt(menu.getNumber(),2);
            int result = permissCode & number;
            //如果权限编码与菜单所需的权限编码取与计算以后,还等原权限编码,表示拥有访问权限
            if(permissCode==result)return true;
        }
        return false;
    }
}
