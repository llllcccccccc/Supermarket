package com.spring.service;

import com.spring.entity.Shangpinfenlei;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface ShangpinfenleiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Shangpinfenlei> select();

    /**
     * 根据Shangpinfenlei类搜索数据
     * @param y
     * @return
     */
    public List<Shangpinfenlei> select(Shangpinfenlei y);

    /**
     * 根据主键获取商品分类一行数据
     * @param id
     * @return
     */
    public Shangpinfenlei find(Object id);

    /**
     * 根据商品分类获取商品分类类条件查询一行数据
     * @param id
     * @return
     */
    public Shangpinfenlei findEntity(Shangpinfenlei id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Shangpinfenlei> selectPage(Shangpinfenlei obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Shangpinfenlei> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入商品分类     * @param y
     * @return
     */
    public int insert(Shangpinfenlei y);

    /**
     * 更新商品分类     * @param y
     * @return
     */
    public int update(Shangpinfenlei y);
}
