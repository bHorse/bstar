package com.xiaosky.bstar.auth.domain.test;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaob on 2017/2/1.
 */
@Entity
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(insertable = false,columnDefinition = "datetime NOT NULL DEFAULT NOW()")
    private Instant createTime;
    @ElementCollection
    @JoinTable(name = "test_user_address",joinColumns = @JoinColumn(name = "userId"))
    @OrderBy("name desc ")
    private Set<Address> addresses=new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        addresses.add(address);
    }
    public void delAddress(Address address){
        addresses.remove(address);
    }
}
