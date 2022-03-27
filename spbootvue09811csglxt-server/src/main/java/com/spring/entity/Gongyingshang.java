package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gongyingshang")
public class Gongyingshang implements Serializable {

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "gongyingshangbianhao")
    private String gongyingshangbianhao;

    @Column(name = "gongyingshangmingcheng")
    private String gongyingshangmingcheng;

    @Column(name = "gongyingshangdianhua")
    private String gongyingshangdianhua;

    @Column(name = "gongyingshangdizhi")
    private String gongyingshangdizhi;

    @Column(name = "gongyingshangxiangqing")
    private String gongyingshangxiangqing;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGongyingshangdizhi() {
        return gongyingshangdizhi;
    }

    public void setGongyingshangdizhi(String gongyingshangdizhi) {
        this.gongyingshangdizhi = gongyingshangdizhi == null ? "" : gongyingshangdizhi.trim();
    }

    public String getGongyingshangxiangqing() {
        return gongyingshangxiangqing;
    }

    public void setGongyingshangxiangqing(String gongyingshangxiangqing) {
        this.gongyingshangxiangqing = gongyingshangxiangqing == null ? "" : gongyingshangxiangqing.trim();
    }
}
