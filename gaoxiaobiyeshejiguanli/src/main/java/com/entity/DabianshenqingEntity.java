package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 答辩申请
 *
 * @author 
 * @email
 */
@TableName("dabianshenqing")
public class DabianshenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DabianshenqingEntity() {

	}

	public DabianshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 课题
     */
    @TableField(value = "wodeketi_id")

    private Integer wodeketiId;


    /**
     * 答辩状态
     */
    @TableField(value = "dabianshenqing_types")

    private Integer dabianshenqingTypes;


    /**
     * 答辩打分
     */
    @TableField(value = "dabianshenqing_number")

    private Integer dabianshenqingNumber;


    /**
     * 审核情况
     */
    @TableField(value = "dabianshenqing_yesno_types")

    private Integer dabianshenqingYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "dabianshenqing_yesno_text")

    private String dabianshenqingYesnoText;


    /**
     * 逻辑删除
     */
    @TableField(value = "dabianshenqing_delete")

    private Integer dabianshenqingDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课题
	 */
    public Integer getWodeketiId() {
        return wodeketiId;
    }
    /**
	 * 获取：课题
	 */

    public void setWodeketiId(Integer wodeketiId) {
        this.wodeketiId = wodeketiId;
    }
    /**
	 * 设置：答辩状态
	 */
    public Integer getDabianshenqingTypes() {
        return dabianshenqingTypes;
    }
    /**
	 * 获取：答辩状态
	 */

    public void setDabianshenqingTypes(Integer dabianshenqingTypes) {
        this.dabianshenqingTypes = dabianshenqingTypes;
    }
    /**
	 * 设置：答辩打分
	 */
    public Integer getDabianshenqingNumber() {
        return dabianshenqingNumber;
    }
    /**
	 * 获取：答辩打分
	 */

    public void setDabianshenqingNumber(Integer dabianshenqingNumber) {
        this.dabianshenqingNumber = dabianshenqingNumber;
    }
    /**
	 * 设置：审核情况
	 */
    public Integer getDabianshenqingYesnoTypes() {
        return dabianshenqingYesnoTypes;
    }
    /**
	 * 获取：审核情况
	 */

    public void setDabianshenqingYesnoTypes(Integer dabianshenqingYesnoTypes) {
        this.dabianshenqingYesnoTypes = dabianshenqingYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getDabianshenqingYesnoText() {
        return dabianshenqingYesnoText;
    }
    /**
	 * 获取：审核结果
	 */

    public void setDabianshenqingYesnoText(String dabianshenqingYesnoText) {
        this.dabianshenqingYesnoText = dabianshenqingYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDabianshenqingDelete() {
        return dabianshenqingDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setDabianshenqingDelete(Integer dabianshenqingDelete) {
        this.dabianshenqingDelete = dabianshenqingDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dabianshenqing{" +
            "id=" + id +
            ", wodeketiId=" + wodeketiId +
            ", dabianshenqingTypes=" + dabianshenqingTypes +
            ", dabianshenqingNumber=" + dabianshenqingNumber +
            ", dabianshenqingYesnoTypes=" + dabianshenqingYesnoTypes +
            ", dabianshenqingYesnoText=" + dabianshenqingYesnoText +
            ", dabianshenqingDelete=" + dabianshenqingDelete +
            ", createTime=" + createTime +
        "}";
    }
}
