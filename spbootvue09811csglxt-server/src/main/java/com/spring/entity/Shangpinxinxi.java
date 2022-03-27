package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "shangpinxinxi")
public class Shangpinxinxi implements Serializable {

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "shangpinbianhao")
    private String shangpinbianhao;

    @Column(name = "shangpinmingcheng")
    private String shangpinmingcheng;

    @Column(name = "fenlei")
    private String fenlei;

    @Column(name = "shangpintupian")
    private String shangpintupian;

    @Column(name = "jinhuojiage")
    private Double jinhuojiage;

    @Column(name = "shangpinjiage")
    private Double shangpinjiage;

    @Column(name = "shangpinkucun")
    private Integer shangpinkucun;

    @Column(name = "shangpinxiangqing")
    private String shangpinxiangqing;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getJinhuoCount() {
        return Query.make("jinhuo").where("shangpinxinxiid", id).count();
    }

    public Long getXiaoshouCount() {
        return Query.make("xiaoshou").where("shangpinxinxiid", id).count();
    }

    public String getShangpinbianhao() {
        return shangpinbianhao;
    }

    public void setShangpinbianhao(String shangpinbianhao) {
        this.shangpinbianhao = shangpinbianhao == null ? "" : shangpinbianhao.trim();
    }

    public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }

    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng == null ? "" : shangpinmingcheng.trim();
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei == null ? "" : fenlei.trim();
    }

    public String getShangpintupian() {
        return shangpintupian;
    }

    public void setShangpintupian(String shangpintupian) {
        this.shangpintupian = shangpintupian == null ? "" : shangpintupian.trim();
    }

    public Double getJinhuojiage() {
        return jinhuojiage;
    }

    public void setJinhuojiage(Double jinhuojiage) {
        this.jinhuojiage = jinhuojiage == null ? 0.0f : jinhuojiage;
    }

    public Double getShangpinjiage() {
        return shangpinjiage;
    }

    public void setShangpinjiage(Double shangpinjiage) {
        this.shangpinjiage = shangpinjiage == null ? 0.0f : shangpinjiage;
    }

    public Integer getShangpinkucun() {
        return shangpinkucun;
    }

    public void setShangpinkucun(Integer shangpinkucun) {
        this.shangpinkucun = shangpinkucun == null ? 0 : shangpinkucun;
    }

    public String getShangpinxiangqing() {
        return shangpinxiangqing;
    }

    public void setShangpinxiangqing(String shangpinxiangqing) {
        this.shangpinxiangqing = shangpinxiangqing == null ? "" : shangpinxiangqing.trim();
    }
}
