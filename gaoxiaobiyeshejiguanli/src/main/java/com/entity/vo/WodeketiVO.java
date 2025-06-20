package com.entity.vo;

import com.entity.WodeketiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 我的课题
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wodeketi")
public class WodeketiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 课题状态
     */

    @TableField(value = "wodeketi_types")
    private Integer wodeketiTypes;


    /**
     * 指导教师打分
     */

    @TableField(value = "wodeketi_zhidaodafen")
    private Integer wodeketiZhidaodafen;


    /**
     * 评阅教师打分
     */

    @TableField(value = "wodeketi_suijia")
    private Integer wodeketiSuijia;


    /**
     * 答辩教师打分
     */

    @TableField(value = "wodeketi_suijib")
    private Integer wodeketiSuijib;


    /**
     * 逻辑删除
     */

    @TableField(value = "wodeketi_delete")
    private Integer wodeketiDelete;


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
	 * 设置：课题状态
	 */
    public Integer getWodeketiTypes() {
        return wodeketiTypes;
    }


    /**
	 * 获取：课题状态
	 */

    public void setWodeketiTypes(Integer wodeketiTypes) {
        this.wodeketiTypes = wodeketiTypes;
    }
    /**
	 * 设置：指导教师打分
	 */
    public Integer getWodeketiZhidaodafen() {
        return wodeketiZhidaodafen;
    }


    /**
	 * 获取：指导教师打分
	 */

    public void setWodeketiZhidaodafen(Integer wodeketiZhidaodafen) {
        this.wodeketiZhidaodafen = wodeketiZhidaodafen;
    }
    /**
	 * 设置：评阅教师打分
	 */
    public Integer getWodeketiSuijia() {
        return wodeketiSuijia;
    }


    /**
	 * 获取：评阅教师打分
	 */

    public void setWodeketiSuijia(Integer wodeketiSuijia) {
        this.wodeketiSuijia = wodeketiSuijia;
    }
    /**
	 * 设置：答辩教师打分
	 */
    public Integer getWodeketiSuijib() {
        return wodeketiSuijib;
    }


    /**
	 * 获取：答辩教师打分
	 */

    public void setWodeketiSuijib(Integer wodeketiSuijib) {
        this.wodeketiSuijib = wodeketiSuijib;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWodeketiDelete() {
        return wodeketiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWodeketiDelete(Integer wodeketiDelete) {
        this.wodeketiDelete = wodeketiDelete;
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
