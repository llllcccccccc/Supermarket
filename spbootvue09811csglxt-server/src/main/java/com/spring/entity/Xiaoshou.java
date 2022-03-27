package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "xiaoshou")
public class Xiaoshou implements Serializable {

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "shangpinxinxiid")
    private Integer shangpinxinxiid;

    @Column(name = "shangpinbianhao")
    private String shangpinbianhao;

    @Column(name = "shangpinmingcheng")
    private String shangpinmingcheng;

    @Column(name = "fenlei")
    private String fenlei;

    @Column(name = "shangpinjiage")
    private Double shangpinjiage;

    @Column(name = "xiaoshoushuliang")
    private Integer xiaoshoushuliang;

    @Column(name = "xiaoji")
    private Double xiaoji;

    @Column(name = "xiaoshoubeizhu")
    private String xiaoshoubeizhu;

    @Column(name = "caozuoren")
    private String caozuoren;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShangpinxinxiid() {
        return shangpinxinxiid;
    }

    public void setShangpinxinxiid(Integer shangpinxinxiid) {
        this.shangpinxinxiid = shangpinxinxiid == null ? 0 : shangpinxinxiid;
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

    public Double getShangpinjiage() {
        return shangpinjiage;
    }

    public void setShangpinjiage(Double shangpinjiage) {
        this.shangpinjiage = shangpinjiage == null ? 0.0f : shangpinjiage;
    }

    public Integer getXiaoshoushuliang() {
        return xiaoshoushuliang;
    }

    public void setXiaoshoushuliang(Integer xiaoshoushuliang) {
        this.xiaoshoushuliang = xiaoshoushuliang == null ? 0 : xiaoshoushuliang;
    }

    public Double getXiaoji() {
        return xiaoji;
    }

    public void setXiaoji(Double xiaoji) {
        this.xiaoji = xiaoji == null ? 0.0f : xiaoji;
    }

    public String getXiaoshoubeizhu() {
        return xiaoshoubeizhu;
    }

    public void setXiaoshoubeizhu(String xiaoshoubeizhu) {
        this.xiaoshoubeizhu = xiaoshoubeizhu == null ? "" : xiaoshoubeizhu.trim();
    }

    public String getCaozuoren() {
        return caozuoren;
    }

    public void setCaozuoren(String caozuoren) {
        this.caozuoren = caozuoren == null ? "" : caozuoren.trim();
    }
}
