package com.entity.model;

import com.entity.KetishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课题申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KetishenqingModel implements Serializable {
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
     * 审核情况
     */
    private Integer ketishenqingYesnoTypes;


    /**
     * 审核结果
     */
    private String ketishenqingYesnoText;


    /**
     * 逻辑删除
     */
    private Integer ketishenqingDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：审核情况
	 */
    public Integer getKetishenqingYesnoTypes() {
        return ketishenqingYesnoTypes;
    }


    /**
	 * 设置：审核情况
	 */
    public void setKetishenqingYesnoTypes(Integer ketishenqingYesnoTypes) {
        this.ketishenqingYesnoTypes = ketishenqingYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getKetishenqingYesnoText() {
        return ketishenqingYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setKetishenqingYesnoText(String ketishenqingYesnoText) {
        this.ketishenqingYesnoText = ketishenqingYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKetishenqingDelete() {
        return ketishenqingDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setKetishenqingDelete(Integer ketishenqingDelete) {
        this.ketishenqingDelete = ketishenqingDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
