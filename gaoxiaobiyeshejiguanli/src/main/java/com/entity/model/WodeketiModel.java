package com.entity.model;

import com.entity.WodeketiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 我的课题
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WodeketiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 课题选择
     */
    private Integer ketixuanzeId;


    /**
     * 课题状态
     */
    private Integer wodeketiTypes;


    /**
     * 指导教师打分
     */
    private Integer wodeketiZhidaodafen;


    /**
     * 评阅教师打分
     */
    private Integer wodeketiSuijia;


    /**
     * 答辩教师打分
     */
    private Integer wodeketiSuijib;


    /**
     * 逻辑删除
     */
    private Integer wodeketiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：课题选择
	 */
    public Integer getKetixuanzeId() {
        return ketixuanzeId;
    }


    /**
	 * 设置：课题选择
	 */
    public void setKetixuanzeId(Integer ketixuanzeId) {
        this.ketixuanzeId = ketixuanzeId;
    }
    /**
	 * 获取：课题状态
	 */
    public Integer getWodeketiTypes() {
        return wodeketiTypes;
    }


    /**
	 * 设置：课题状态
	 */
    public void setWodeketiTypes(Integer wodeketiTypes) {
        this.wodeketiTypes = wodeketiTypes;
    }
    /**
	 * 获取：指导教师打分
	 */
    public Integer getWodeketiZhidaodafen() {
        return wodeketiZhidaodafen;
    }


    /**
	 * 设置：指导教师打分
	 */
    public void setWodeketiZhidaodafen(Integer wodeketiZhidaodafen) {
        this.wodeketiZhidaodafen = wodeketiZhidaodafen;
    }
    /**
	 * 获取：评阅教师打分
	 */
    public Integer getWodeketiSuijia() {
        return wodeketiSuijia;
    }


    /**
	 * 设置：评阅教师打分
	 */
    public void setWodeketiSuijia(Integer wodeketiSuijia) {
        this.wodeketiSuijia = wodeketiSuijia;
    }
    /**
	 * 获取：答辩教师打分
	 */
    public Integer getWodeketiSuijib() {
        return wodeketiSuijib;
    }


    /**
	 * 设置：答辩教师打分
	 */
    public void setWodeketiSuijib(Integer wodeketiSuijib) {
        this.wodeketiSuijib = wodeketiSuijib;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWodeketiDelete() {
        return wodeketiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setWodeketiDelete(Integer wodeketiDelete) {
        this.wodeketiDelete = wodeketiDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
