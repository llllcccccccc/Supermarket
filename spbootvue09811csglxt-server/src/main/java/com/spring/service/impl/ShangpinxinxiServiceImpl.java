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

@Service("ShangpinxinxiService")
public class ShangpinxinxiServiceImpl implements ShangpinxinxiService {

    @Resource
    private ShangpinxinxiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Shangpinxinxi> select() {
        return dao.select(null);
    }

    /**
     * 根据Shangpinxinxi类搜索数据
     * @param y
     * @return
     */
    public List<Shangpinxinxi> select(Shangpinxinxi y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取商品信息一行数据
     * @param id
     * @return
     */
    public Shangpinxinxi find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据商品信息获取商品信息类条件查询一行数据
     * @param id
     * @return
     */
    public Shangpinxinxi findEntity(Shangpinxinxi id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Shangpinxinxi> selectPage(Shangpinxinxi obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Shangpinxinxi> list = select(obj);
        PageInfo<Shangpinxinxi> pageInfo = new PageInfo(list);
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
    public List<Shangpinxinxi> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Shangpinxinxi> list = dao.selectByExample(obj);
        PageInfo<Shangpinxinxi> pageInfo = new PageInfo(list);
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
     * 插入商品信息     * @param y
     * @return
     */
    public int insert(Shangpinxinxi y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新商品信息     * @param y
     * @return
     */
    public int update(Shangpinxinxi y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
