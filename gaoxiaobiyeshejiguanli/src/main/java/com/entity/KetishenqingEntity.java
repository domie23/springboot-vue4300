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
 * 课题申请
 *
 * @author 
 * @email
 */
@TableName("ketishenqing")
public class KetishenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KetishenqingEntity() {

	}

	public KetishenqingEntity(T t) {
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
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 课题选择
     */
    @TableField(value = "ketixuanze_id")

    private Integer ketixuanzeId;


    /**
     * 审核情况
     */
    @TableField(value = "ketishenqing_yesno_types")

    private Integer ketishenqingYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "ketishenqing_yesno_text")

    private String ketishenqingYesnoText;


    /**
     * 逻辑删除
     */
    @TableField(value = "ketishenqing_delete")

    private Integer ketishenqingDelete;


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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：课题选择
	 */
    public Integer getKetixuanzeId() {
        return ketixuanzeId;
    }
    /**
	 * 获取：课题选择
	 */

    public void setKetixuanzeId(Integer ketixuanzeId) {
        this.ketixuanzeId = ketixuanzeId;
    }
    /**
	 * 设置：审核情况
	 */
    public Integer getKetishenqingYesnoTypes() {
        return ketishenqingYesnoTypes;
    }
    /**
	 * 获取：审核情况
	 */

    public void setKetishenqingYesnoTypes(Integer ketishenqingYesnoTypes) {
        this.ketishenqingYesnoTypes = ketishenqingYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getKetishenqingYesnoText() {
        return ketishenqingYesnoText;
    }
    /**
	 * 获取：审核结果
	 */

    public void setKetishenqingYesnoText(String ketishenqingYesnoText) {
        this.ketishenqingYesnoText = ketishenqingYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKetishenqingDelete() {
        return ketishenqingDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setKetishenqingDelete(Integer ketishenqingDelete) {
        this.ketishenqingDelete = ketishenqingDelete;
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
        return "Ketishenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", ketixuanzeId=" + ketixuanzeId +
            ", ketishenqingYesnoTypes=" + ketishenqingYesnoTypes +
            ", ketishenqingYesnoText=" + ketishenqingYesnoText +
            ", ketishenqingDelete=" + ketishenqingDelete +
            ", createTime=" + createTime +
        "}";
    }
}
