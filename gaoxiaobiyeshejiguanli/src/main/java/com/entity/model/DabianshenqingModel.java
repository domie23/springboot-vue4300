package com.entity.model;

import com.entity.DabianshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 答辩申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DabianshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课题
     */
    private Integer wodeketiId;


    /**
     * 答辩状态
     */
    private Integer dabianshenqingTypes;


    /**
     * 答辩打分
     */
    private Integer dabianshenqingNumber;


    /**
     * 审核情况
     */
    private Integer dabianshenqingYesnoTypes;


    /**
     * 审核结果
     */
    private String dabianshenqingYesnoText;


    /**
     * 逻辑删除
     */
    private Integer dabianshenqingDelete;


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
	 * 获取：课题
	 */
    public Integer getWodeketiId() {
        return wodeketiId;
    }


    /**
	 * 设置：课题
	 */
    public void setWodeketiId(Integer wodeketiId) {
        this.wodeketiId = wodeketiId;
    }
    /**
	 * 获取：答辩状态
	 */
    public Integer getDabianshenqingTypes() {
        return dabianshenqingTypes;
    }


    /**
	 * 设置：答辩状态
	 */
    public void setDabianshenqingTypes(Integer dabianshenqingTypes) {
        this.dabianshenqingTypes = dabianshenqingTypes;
    }
    /**
	 * 获取：答辩打分
	 */
    public Integer getDabianshenqingNumber() {
        return dabianshenqingNumber;
    }


    /**
	 * 设置：答辩打分
	 */
    public void setDabianshenqingNumber(Integer dabianshenqingNumber) {
        this.dabianshenqingNumber = dabianshenqingNumber;
    }
    /**
	 * 获取：审核情况
	 */
    public Integer getDabianshenqingYesnoTypes() {
        return dabianshenqingYesnoTypes;
    }


    /**
	 * 设置：审核情况
	 */
    public void setDabianshenqingYesnoTypes(Integer dabianshenqingYesnoTypes) {
        this.dabianshenqingYesnoTypes = dabianshenqingYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getDabianshenqingYesnoText() {
        return dabianshenqingYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setDabianshenqingYesnoText(String dabianshenqingYesnoText) {
        this.dabianshenqingYesnoText = dabianshenqingYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDabianshenqingDelete() {
        return dabianshenqingDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDabianshenqingDelete(Integer dabianshenqingDelete) {
        this.dabianshenqingDelete = dabianshenqingDelete;
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
