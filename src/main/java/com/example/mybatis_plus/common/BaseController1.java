// package com.example.mybatis_plus.common;
//
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.ResolvableType;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.domain.Specification;
// import org.springframework.web.bind.annotation.RequestBody;
//
// import javax.annotation.Resource;
// import java.io.Serializable;
// import java.util.List;
// import java.util.function.Function;
//
// /**
//  * 基础controller
//  * 提供基础的 增删改查的方法，可以通过继承此类快速实现
//  *
//  * @param <T>  实体类
//  * @param <ID> 实体类的id类型
//  * @param <VO> VO 类型
//  * @author zipeng
//  */
// public class BaseController<T, ID extends Serializable, VO> {
//     @Resource
//     private BeanMapper mBeanMapper;
//
//     private IBaseService<T, ID> mService;
//
//     /**
//      * 实体类
//      */
//     private Class mEntityClass;
//     /**
//      * vo类
//      */
//     private Class mVOClass;
//
//     protected BaseController() {
//         ResolvableType resolvableType = ResolvableType.forClass(BaseController.class, this.getClass());
//         mEntityClass = resolvableType.getGeneric(0).resolve();
//         mVOClass = resolvableType.getGeneric(2).resolve();
//     }
//
//     //=================curd封装 start ==================
//
//     /**
//      * 获取分页
//      *
//      * @param pageable
//      * @return
//      */
//     public ResultVO<PageVO<VO>> page(Pageable pageable) {
//         //优先使用 searchParamVO 的pageable
//         Page<T> page = getService().findPage(pageable);
//         return ResultVO.page(page, generateConverter(), null);
//     }
//
//     /**
//      * 获取分页
//      * <p>
//      * 提供动态参数查询 详细请看 {@link SearchParamVO}
//      * <p>
//      * 通过 {@link com.otalk.basecommon.web.SearchParamHandlerMethodArgumentResolver} 通过 requestBody 来注入的
//      *
//      * @param searchParam 不需要增加 {@link RequestBody}注解
//      * @return
//      */
//     public ResultVO<PageVO<VO>> page(SearchParamVO searchParam) {
//         //优先使用 searchParamVO 的pageable
//         Pageable searchParamPageable = searchParam.getPageable();
//         if (searchParamPageable == null) {
//             searchParamPageable = new SearchParamVO.Page();
//         }
//         Page<T> page = findBySearchParam(searchParam.getConditions(), searchParamPageable);
//         return ResultVO.page(page, generateConverter(), null);
//     }
//
//     protected Page<T> findBySearchParam(List<Condition> conditions, Pageable pageable) {
//         return getService().findPage(generateSpecification(conditions), pageable);
//     }
//
//     protected Specification generateSpecification(List<Condition> conditions) {
//         return SpecificationUtils.generateSpecification(conditions);
//     }
//
//     public ResultVO<VO> get(ID id) {
//         T entity = mService.get(id);
//         if (entity == null) {
//             return ResultVO.fail("entity not exist");
//         }
//         return ResultVO.success((VO) getBeanMapper().map(entity, getVOClass()));
//     }
//
//     public ResultVO<VO> load(ID id) {
//         T entity = mService.load(id);
//         if (entity == null) {
//             return ResultVO.fail("entity not exist");
//         }
//         return ResultVO.success((VO) getBeanMapper().map(entity, getVOClass()));
//     }
//
//     public ResultVO<VO> save(@RequestBody VO vo) {
//         T entity = mService.save((T) getBeanMapper().map(vo, getEntityClass()));
//         return ResultVO.success((VO) getBeanMapper().map(entity, getVOClass()), null);
//     }
//
//     public ResultVO delete(ID id) {
//         mService.delete(id);
//         return ResultVO.success();
//     }
//
//     //=================curd封装 end ==================
//
//     public Class getEntityClass() {
//         return mEntityClass;
//     }
//
//     public Class getVOClass() {
//         return mVOClass;
//     }
//
//     public IBaseService<T, ID> getService() {
//         return mService;
//     }
//
//     @Autowired
//     public void setService(IBaseService<T, ID> service) {
//         mService = service;
//     }
//
//     public BeanMapper getBeanMapper() {
//         return mBeanMapper;
//     }
//
//     /**
//      * 以泛型参数VO 为参数的获取转换器
//      *
//      * @return
//      * @see #generateConverter(Class)
//      */
//     public Function<T, VO> generateConverter() {
//         return generateConverter(getVOClass());
//     }
//
//     /**
//      * page用的转换器
//      *
//      * @param targetClass
//      * @param <S>
//      * @param <T>
//      * @return
//      */
//     public <S, T> Function<S, T> generateConverter(Class<T> targetClass) {
//
//         return new Function<S, T>() {
//             @Override
//             public T apply(S s) {
//                 return getBeanMapper().map(s, targetClass);
//             }
//         };
//     }
// }
