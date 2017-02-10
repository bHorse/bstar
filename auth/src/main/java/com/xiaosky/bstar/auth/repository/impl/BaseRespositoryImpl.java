package com.xiaosky.bstar.auth.repository.impl;

import com.xiaosky.bstar.auth.repository.BaseRespository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by xiaob on 2017/1/12.
 */
public class BaseRespositoryImpl<T> implements BaseRespository<T> {
    private Class<T> clzee=null;
    @PersistenceContext
    private EntityManager entityManager;
    public BaseRespositoryImpl(){
        ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
        //System.out.println("父类的类型是"+pt);
        this.clzee=(Class<T>) pt.getActualTypeArguments()[0];
        //System.out.println("泛型参数是"+clzee);
    }

    public T get(Serializable id) {
        return entityManager.find(clzee,id);
    }

    public void add(T t) {
        entityManager.persist(t);
    }

    public void remove(T t) {
        entityManager.remove(t);
    }

    public T load(Serializable id) {
        return entityManager.getReference(clzee,id);
    }
}
