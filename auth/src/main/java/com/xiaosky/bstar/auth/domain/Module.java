package com.xiaosky.bstar.auth.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by xiaob on 2017/1/16.
 */
@Entity(name = "auth_module")
public class Module {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;
    private String name;

    public Module() {
    }

    public Module(String name) {
        this.name = name;
    }

}
