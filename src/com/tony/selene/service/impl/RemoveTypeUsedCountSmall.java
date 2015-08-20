package com.tony.selene.service.impl;

import com.tony.selene.entity.CacheObject;
import com.tony.selene.service.CacheFullRemoveType;

/**
 * Remove type when cache is full.<br/>
 * when cache is full, compare used count of object in cache, if is smaller remove it first.<br/>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2011-12-26
 */
public class RemoveTypeUsedCountSmall<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return (obj1.getUsedCount() > obj2.getUsedCount()) ? 1
                : ((obj1.getUsedCount() == obj2.getUsedCount()) ? 0 : -1);
    }
}