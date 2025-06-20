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
 * 打分记录
 *
 * @author 
 * @email
 */
@TableName("dafenzhongxin")
public class DafenzhongxinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DafenzhongxinEntity() {

	}

	public DafenzhongxinEntity(T t) {
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
     * 教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 课题
     */
    @TableField(value = "wodeketi_id")

    private Integer wodeketiId;


    /**
     * 打分数值
     */
    @TableField(value = "dafenzhongxin_sum")

    private Integer dafenzhongxinSum;


    /**
     * 逻辑删除
     */
    @TableField(value = "dafenzhongxin_delete")

    private Integer dafenzhongxinDelete;


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
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 设置：打分数值
	 */
    public Integer getDafenzhongxinSum() {
        return dafenzhongxinSum;
    }
    /**
	 * 获取：打分数值
	 */

    public void setDafenzhongxinSum(Integer dafenzhongxinSum) {
        this.dafenzhongxinSum = dafenzhongxinSum;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDafenzhongxinDelete() {
        return dafenzhongxinDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setDafenzhongxinDelete(Integer dafenzhongxinDelete) {
        this.dafenzhongxinDelete = dafenzhongxinDelete;
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
        return "Dafenzhongxin{" +
            "id=" + id +
            ", jiaoshiId=" + jiaoshiId +
            ", wodeketiId=" + wodeketiId +
            ", dafenzhongxinSum=" + dafenzhongxinSum +
            ", dafenzhongxinDelete=" + dafenzhongxinDelete +
            ", createTime=" + createTime +
        "}";
    }
}
