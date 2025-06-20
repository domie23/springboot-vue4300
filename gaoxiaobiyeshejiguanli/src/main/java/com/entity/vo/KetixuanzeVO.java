package com.entity.vo;

import com.entity.KetixuanzeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课题选择
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ketixuanze")
public class KetixuanzeVO implements Serializable {
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
     * 课题名称
     */

    @TableField(value = "ketixuanze_name")
    private String ketixuanzeName;


    /**
     * 课题类型
     */

    @TableField(value = "ketixuanze_types")
    private Integer ketixuanzeTypes;


    /**
     * 课题来源
     */

    @TableField(value = "laiyuan_types")
    private Integer laiyuanTypes;


    /**
     * 适用专业
     */

    @TableField(value = "zhuanye_types")
    private Integer zhuanyeTypes;


    /**
     * 已选人数
     */

    @TableField(value = "ketixuanze_yixuan")
    private Integer ketixuanzeYixuan;


    /**
     * 可选人数
     */

    @TableField(value = "ketixuanze_kexuan")
    private Integer ketixuanzeKexuan;


    /**
     * 课题详情
     */

    @TableField(value = "ketixuanze_content")
    private String ketixuanzeContent;


    /**
     * 审核情况
     */

    @TableField(value = "ketixuanze_yesno_types")
    private Integer ketixuanzeYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "ketixuanze_yesno_text")
    private String ketixuanzeYesnoText;


    /**
     * 逻辑删除
     */

    @TableField(value = "ketixuanze_delete")
    private Integer ketixuanzeDelete;


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
	 * 设置：课题名称
	 */
    public String getKetixuanzeName() {
        return ketixuanzeName;
    }


    /**
	 * 获取：课题名称
	 */

    public void setKetixuanzeName(String ketixuanzeName) {
        this.ketixuanzeName = ketixuanzeName;
    }
    /**
	 * 设置：课题类型
	 */
    public Integer getKetixuanzeTypes() {
        return ketixuanzeTypes;
    }


    /**
	 * 获取：课题类型
	 */

    public void setKetixuanzeTypes(Integer ketixuanzeTypes) {
        this.ketixuanzeTypes = ketixuanzeTypes;
    }
    /**
	 * 设置：课题来源
	 */
    public Integer getLaiyuanTypes() {
        return laiyuanTypes;
    }


    /**
	 * 获取：课题来源
	 */

    public void setLaiyuanTypes(Integer laiyuanTypes) {
        this.laiyuanTypes = laiyuanTypes;
    }
    /**
	 * 设置：适用专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 获取：适用专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：已选人数
	 */
    public Integer getKetixuanzeYixuan() {
        return ketixuanzeYixuan;
    }


    /**
	 * 获取：已选人数
	 */

    public void setKetixuanzeYixuan(Integer ketixuanzeYixuan) {
        this.ketixuanzeYixuan = ketixuanzeYixuan;
    }
    /**
	 * 设置：可选人数
	 */
    public Integer getKetixuanzeKexuan() {
        return ketixuanzeKexuan;
    }


    /**
	 * 获取：可选人数
	 */

    public void setKetixuanzeKexuan(Integer ketixuanzeKexuan) {
        this.ketixuanzeKexuan = ketixuanzeKexuan;
    }
    /**
	 * 设置：课题详情
	 */
    public String getKetixuanzeContent() {
        return ketixuanzeContent;
    }


    /**
	 * 获取：课题详情
	 */

    public void setKetixuanzeContent(String ketixuanzeContent) {
        this.ketixuanzeContent = ketixuanzeContent;
    }
    /**
	 * 设置：审核情况
	 */
    public Integer getKetixuanzeYesnoTypes() {
        return ketixuanzeYesnoTypes;
    }


    /**
	 * 获取：审核情况
	 */

    public void setKetixuanzeYesnoTypes(Integer ketixuanzeYesnoTypes) {
        this.ketixuanzeYesnoTypes = ketixuanzeYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getKetixuanzeYesnoText() {
        return ketixuanzeYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setKetixuanzeYesnoText(String ketixuanzeYesnoText) {
        this.ketixuanzeYesnoText = ketixuanzeYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKetixuanzeDelete() {
        return ketixuanzeDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setKetixuanzeDelete(Integer ketixuanzeDelete) {
        this.ketixuanzeDelete = ketixuanzeDelete;
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
