// package com.example.mybatis_plus.common;
//
// import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//
//
// import java.io.Serializable;
// import java.util.List;
//
// /**
//  * @author zhangtusheng
//  */
// public interface IBaseService<T, ID extends Serializable>{
//
//     /**
//      * load 一个对象，返回引用，会延迟加载
//      *
//      * @param id
//      * @return
//      */
//     T load(ID id);
//
//     T get(ID id);
//
//     List<T> findList();
//
//     List<T> findList(Specification<T> spec, Sort sort);
//
//     Page<T> findPage(Pageable pageable);
//
//     Page<T> findPage(Specification<T> spec, Pageable pageable);
//
//     long count();
//
//     long count(Specification<T> spec);
//
//     boolean exists(ID id);
//
//     T save(T entity);
//
//     List<T> save(Iterable<T> entities);
//
//     T update(T entity);
//
//     void delete(ID id);
//
//     void deleteByIds(@SuppressWarnings("unchecked") ID... ids);
//
//     void delete(T[] entities);
//
//     void delete(Iterable<T> entities);
//
//     void delete(T entity);
//
// }
