package com.xiaosky.bstar.auth.repository;

import java.io.Serializable;

/**
 * Created by xiaob on 2017/1/12.
 */
public interface BaseRespository<T> {
    T get(Serializable id);
    void add(T t);
    void remove(T t);
    T load(Serializable id);

}
