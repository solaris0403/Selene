package com.tony.selene.service.impl;

import com.tony.selene.entity.CacheObject;
import com.tony.selene.service.CacheFullRemoveType;

/**
 * Remove type when cache is full. not remove any one, it means nothing can be put later<br/>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2011-12-26
 */
public class RemoveTypeNotRemove<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return 0;
    }
}
