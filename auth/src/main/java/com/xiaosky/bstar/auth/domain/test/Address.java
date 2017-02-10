package com.xiaosky.bstar.auth.domain.test;

import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by xiaob on 2017/2/1.
 */
@Embeddable
public class Address {
    @Parent
    private TestUser testUser;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;
    private Address(){}
    public Address(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return name.equals(address.name);

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    public TestUser getTestUser(){
        return testUser;
    }

    public void setTestUser(TestUser testUser) {
        this.testUser = testUser;
    }
}
