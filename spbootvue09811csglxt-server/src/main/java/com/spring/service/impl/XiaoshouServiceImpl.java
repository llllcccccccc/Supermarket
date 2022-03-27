package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("XiaoshouService")
public class XiaoshouServiceImpl implements XiaoshouService {

    @Resource
    private XiaoshouMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Xiaoshou> select() {
        return dao.select(null);
    }

    /**
     * 根据Xiaoshou类搜索数据
     * @param y
     * @return
     */
    public List<Xiaoshou> select(Xiaoshou y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取销售一行数据
     * @param id
     * @return
     */
    public Xiaoshou find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据销售获取销售类条件查询一行数据
     * @param id
     * @return
     */
    public Xiaoshou findEntity(Xiaoshou id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaoshou> selectPage(Xiaoshou obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Xiaoshou> list = select(obj);
        PageInfo<Xiaoshou> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaoshou> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Xiaoshou> list = dao.selectByExample(obj);
        PageInfo<Xiaoshou> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id) {
        return dao.deleteByPrimaryKey(id);
    }

    /**
     * 插入销售     * @param y
     * @return
     */
    public int insert(Xiaoshou y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新销售     * @param y
     * @return
     */
    public int update(Xiaoshou y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
