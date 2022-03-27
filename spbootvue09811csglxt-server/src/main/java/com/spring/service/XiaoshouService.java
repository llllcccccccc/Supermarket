package com.spring.service;

import com.spring.entity.Xiaoshou;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface XiaoshouService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Xiaoshou> select();

    /**
     * 根据Xiaoshou类搜索数据
     * @param y
     * @return
     */
    public List<Xiaoshou> select(Xiaoshou y);

    /**
     * 根据主键获取销售一行数据
     * @param id
     * @return
     */
    public Xiaoshou find(Object id);

    /**
     * 根据销售获取销售类条件查询一行数据
     * @param id
     * @return
     */
    public Xiaoshou findEntity(Xiaoshou id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaoshou> selectPage(Xiaoshou obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaoshou> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入销售     * @param y
     * @return
     */
    public int insert(Xiaoshou y);

    /**
     * 更新销售     * @param y
     * @return
     */
    public int update(Xiaoshou y);
}
