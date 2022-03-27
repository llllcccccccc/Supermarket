package com.spring.service;

import com.spring.entity.Jinhuo;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface JinhuoService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Jinhuo> select();

    /**
     * 根据Jinhuo类搜索数据
     * @param y
     * @return
     */
    public List<Jinhuo> select(Jinhuo y);

    /**
     * 根据主键获取进货一行数据
     * @param id
     * @return
     */
    public Jinhuo find(Object id);

    /**
     * 根据进货获取进货类条件查询一行数据
     * @param id
     * @return
     */
    public Jinhuo findEntity(Jinhuo id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jinhuo> selectPage(Jinhuo obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jinhuo> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入进货     * @param y
     * @return
     */
    public int insert(Jinhuo y);

    /**
     * 更新进货     * @param y
     * @return
     */
    public int update(Jinhuo y);
}
