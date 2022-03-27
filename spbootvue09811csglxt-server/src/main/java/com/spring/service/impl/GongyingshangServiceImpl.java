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

@Service("GongyingshangService")
public class GongyingshangServiceImpl implements GongyingshangService {

    @Resource
    private GongyingshangMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Gongyingshang> select() {
        return dao.select(null);
    }

    /**
     * 根据Gongyingshang类搜索数据
     * @param y
     * @return
     */
    public List<Gongyingshang> select(Gongyingshang y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取供应商一行数据
     * @param id
     * @return
     */
    public Gongyingshang find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据供应商获取供应商类条件查询一行数据
     * @param id
     * @return
     */
    public Gongyingshang findEntity(Gongyingshang id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gongyingshang> selectPage(Gongyingshang obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Gongyingshang> list = select(obj);
        PageInfo<Gongyingshang> pageInfo = new PageInfo(list);
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
    public List<Gongyingshang> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Gongyingshang> list = dao.selectByExample(obj);
        PageInfo<Gongyingshang> pageInfo = new PageInfo(list);
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
     * 插入供应商     * @param y
     * @return
     */
    public int insert(Gongyingshang y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新供应商     * @param y
     * @return
     */
    public int update(Gongyingshang y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
