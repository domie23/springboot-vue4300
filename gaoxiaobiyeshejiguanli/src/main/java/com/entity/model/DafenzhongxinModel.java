package com.entity.model;

import com.entity.DafenzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 打分记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DafenzhongxinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 课题
     */
    private Integer wodeketiId;


    /**
     * 打分数值
     */
    private Integer dafenzhongxinSum;


    /**
     * 逻辑删除
     */
    private Integer dafenzhongxinDelete;


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
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 获取：打分数值
	 */
    public Integer getDafenzhongxinSum() {
        return dafenzhongxinSum;
    }


    /**
	 * 设置：打分数值
	 */
    public void setDafenzhongxinSum(Integer dafenzhongxinSum) {
        this.dafenzhongxinSum = dafenzhongxinSum;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDafenzhongxinDelete() {
        return dafenzhongxinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDafenzhongxinDelete(Integer dafenzhongxinDelete) {
        this.dafenzhongxinDelete = dafenzhongxinDelete;
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
