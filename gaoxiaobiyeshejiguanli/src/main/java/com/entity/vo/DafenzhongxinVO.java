package com.entity.vo;

import com.entity.DafenzhongxinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 打分记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dafenzhongxin")
public class DafenzhongxinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
