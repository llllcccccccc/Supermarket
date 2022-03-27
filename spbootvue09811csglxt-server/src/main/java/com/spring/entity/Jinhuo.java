package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jinhuo")
public class Jinhuo implements Serializable {

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

    @Column(name = "gongyingshang")
    private Integer gongyingshang;

    @Column(name = "gongyingshangbianhao")
    private String gongyingshangbianhao;

    @Column(name = "gongyingshangmingcheng")
    private String gongyingshangmingcheng;

    @Column(name = "gongyingshangdianhua")
    private String gongyingshangdianhua;

    @Column(name = "jinhuojiage")
    private Double jinhuojiage;

    @Column(name = "jinhuoshuliang")
    private Integer jinhuoshuliang;

    @Column(name = "jinhuoxiaoji")
    private Double jinhuoxiaoji;

    @Column(name = "jinhuobeizhu")
    private String jinhuobeizhu;

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

    public Integer getGongyingshang() {
        return gongyingshang;
    }

    public void setGongyingshang(Integer gongyingshang) {
        this.gongyingshang = gongyingshang == null ? 0 : gongyingshang;
    }

    public String getGongyingshangbianhao() {
        return gongyingshangbianhao;
    }

    public void setGongyingshangbianhao(String gongyingshangbianhao) {
        this.gongyingshangbianhao = gongyingshangbianhao == null ? "" : gongyingshangbianhao.trim();
    }

    public String getGongyingshangmingcheng() {
        return gongyingshangmingcheng;
    }

    public void setGongyingshangmingcheng(String gongyingshangmingcheng) {
        this.gongyingshangmingcheng = gongyingshangmingcheng == null ? "" : gongyingshangmingcheng.trim();
    }

    public String getGongyingshangdianhua() {
        return gongyingshangdianhua;
    }

    public void setGongyingshangdianhua(String gongyingshangdianhua) {
        this.gongyingshangdianhua = gongyingshangdianhua == null ? "" : gongyingshangdianhua.trim();
    }

    public Double getJinhuojiage() {
        return jinhuojiage;
    }

    public void setJinhuojiage(Double jinhuojiage) {
        this.jinhuojiage = jinhuojiage == null ? 0.0f : jinhuojiage;
    }

    public Integer getJinhuoshuliang() {
        return jinhuoshuliang;
    }

    public void setJinhuoshuliang(Integer jinhuoshuliang) {
        this.jinhuoshuliang = jinhuoshuliang == null ? 0 : jinhuoshuliang;
    }

    public Double getJinhuoxiaoji() {
        return jinhuoxiaoji;
    }

    public void setJinhuoxiaoji(Double jinhuoxiaoji) {
        this.jinhuoxiaoji = jinhuoxiaoji == null ? 0.0f : jinhuoxiaoji;
    }

    public String getJinhuobeizhu() {
        return jinhuobeizhu;
    }

    public void setJinhuobeizhu(String jinhuobeizhu) {
        this.jinhuobeizhu = jinhuobeizhu == null ? "" : jinhuobeizhu.trim();
    }

    public String getCaozuoren() {
        return caozuoren;
    }

    public void setCaozuoren(String caozuoren) {
        this.caozuoren = caozuoren == null ? "" : caozuoren.trim();
    }
}
