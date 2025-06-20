package com.entity.vo;

import com.entity.KetishenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课题申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ketishenqing")
public class KetishenqingVO implements Serializable {
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
     * 创建时间  show1 show2 photoShow
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
