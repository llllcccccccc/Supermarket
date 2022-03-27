package com.spring.service;

import com.spring.entity.Shangpinxinxi;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface ShangpinxinxiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Shangpinxinxi> select();

    /**
     * 根据Shangpinxinxi类搜索数据
     * @param y
     * @return
     */
    public List<Shangpinxinxi> select(Shangpinxinxi y);

    /**
     * 根据主键获取商品信息一行数据
     * @param id
     * @return
     */
    public Shangpinxinxi find(Object id);

    /**
     * 根据商品信息获取商品信息类条件查询一行数据
     * @param id
     * @return
     */
    public Shangpinxinxi findEntity(Shangpinxinxi id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Shangpinxinxi> selectPage(Shangpinxinxi obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Shangpinxinxi> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入商品信息     * @param y
     * @return
     */
    public int insert(Shangpinxinxi y);

    /**
     * 更新商品信息     * @param y
     * @return
     */
    public int update(Shangpinxinxi y);
}
