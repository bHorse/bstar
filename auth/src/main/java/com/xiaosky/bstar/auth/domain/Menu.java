package com.xiaosky.bstar.auth.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaob on 2017/1/16.
 */
//@Entity(name = "auth_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String menuName;

    //private Menu parentMenu;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Menu>chileMenus=new ArrayList<>();

    private String number;

    private String seat;

    private String seq;

    private Module module;
}
