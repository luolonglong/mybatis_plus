package com.example.mybatis_plus.common;

import org.dozer.Mapper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zipeng
 * @date 2018/9/17
 */
public interface BeanMapper extends Mapper {

    default <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new LinkedList<T>();
        for (Object sourceObject : sourceList) {
            T destinationObject = this.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
