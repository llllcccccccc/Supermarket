package com.spring.service;

import com.spring.entity.Gongyingshang;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface GongyingshangService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Gongyingshang> select();

    /**
     * 根据Gongyingshang类搜索数据
     * @param y
     * @return
     */
    public List<Gongyingshang> select(Gongyingshang y);

    /**
     * 根据主键获取供应商一行数据
     * @param id
     * @return
     */
    public Gongyingshang find(Object id);

    /**
     * 根据供应商获取供应商类条件查询一行数据
     * @param id
     * @return
     */
    public Gongyingshang findEntity(Gongyingshang id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gongyingshang> selectPage(Gongyingshang obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gongyingshang> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入供应商     * @param y
     * @return
     */
    public int insert(Gongyingshang y);

    /**
     * 更新供应商     * @param y
     * @return
     */
    public int update(Gongyingshang y);
}
