package com.xiaosky.bstar.auth.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaob on 2017/1/16.
 */
@Entity(name = "auth_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String menuName;

    //private Menu parentMenu;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
    @JoinColumn(name = "parentId")
    private List<Menu>chileMenus=new ArrayList<>();

    private String number;

    private String seat;

    private String seq;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moduleId")
    private Module module;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
