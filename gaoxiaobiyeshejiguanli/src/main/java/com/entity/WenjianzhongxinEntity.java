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
 * 文件中心
 *
 * @author 
 * @email
 */
@TableName("wenjianzhongxin")
public class WenjianzhongxinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WenjianzhongxinEntity() {

	}

	public WenjianzhongxinEntity(T t) {
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
     * 文件名称
     */
    @TableField(value = "wenjianzhongxin_name")

    private String wenjianzhongxinName;


    /**
     * 文件上传
     */
    @TableField(value = "wenjianzhongxin_file")

    private String wenjianzhongxinFile;


    /**
     * 审核情况
     */
    @TableField(value = "wenjianzhongxin_yesno_types")

    private Integer wenjianzhongxinYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "wenjianzhongxin_yesno_text")

    private String wenjianzhongxinYesnoText;


    /**
     * 逻辑删除
     */
    @TableField(value = "wenjianzhongxin_delete")

    private Integer wenjianzhongxinDelete;


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
	 * 设置：文件名称
	 */
    public String getWenjianzhongxinName() {
        return wenjianzhongxinName;
    }
    /**
	 * 获取：文件名称
	 */

    public void setWenjianzhongxinName(String wenjianzhongxinName) {
        this.wenjianzhongxinName = wenjianzhongxinName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getWenjianzhongxinFile() {
        return wenjianzhongxinFile;
    }
    /**
	 * 获取：文件上传
	 */

    public void setWenjianzhongxinFile(String wenjianzhongxinFile) {
        this.wenjianzhongxinFile = wenjianzhongxinFile;
    }
    /**
	 * 设置：审核情况
	 */
    public Integer getWenjianzhongxinYesnoTypes() {
        return wenjianzhongxinYesnoTypes;
    }
    /**
	 * 获取：审核情况
	 */

    public void setWenjianzhongxinYesnoTypes(Integer wenjianzhongxinYesnoTypes) {
        this.wenjianzhongxinYesnoTypes = wenjianzhongxinYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getWenjianzhongxinYesnoText() {
        return wenjianzhongxinYesnoText;
    }
    /**
	 * 获取：审核结果
	 */

    public void setWenjianzhongxinYesnoText(String wenjianzhongxinYesnoText) {
        this.wenjianzhongxinYesnoText = wenjianzhongxinYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWenjianzhongxinDelete() {
        return wenjianzhongxinDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setWenjianzhongxinDelete(Integer wenjianzhongxinDelete) {
        this.wenjianzhongxinDelete = wenjianzhongxinDelete;
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
        return "Wenjianzhongxin{" +
            "id=" + id +
            ", wodeketiId=" + wodeketiId +
            ", wenjianzhongxinName=" + wenjianzhongxinName +
            ", wenjianzhongxinFile=" + wenjianzhongxinFile +
            ", wenjianzhongxinYesnoTypes=" + wenjianzhongxinYesnoTypes +
            ", wenjianzhongxinYesnoText=" + wenjianzhongxinYesnoText +
            ", wenjianzhongxinDelete=" + wenjianzhongxinDelete +
            ", createTime=" + createTime +
        "}";
    }
}
