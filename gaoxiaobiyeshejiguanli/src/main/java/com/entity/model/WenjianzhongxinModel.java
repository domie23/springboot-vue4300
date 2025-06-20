package com.entity.model;

import com.entity.WenjianzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文件中心
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenjianzhongxinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课题
     */
    private Integer wodeketiId;


    /**
     * 文件名称
     */
    private String wenjianzhongxinName;


    /**
     * 文件上传
     */
    private String wenjianzhongxinFile;


    /**
     * 审核情况
     */
    private Integer wenjianzhongxinYesnoTypes;


    /**
     * 审核结果
     */
    private String wenjianzhongxinYesnoText;


    /**
     * 逻辑删除
     */
    private Integer wenjianzhongxinDelete;


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
	 * 获取：文件名称
	 */
    public String getWenjianzhongxinName() {
        return wenjianzhongxinName;
    }


    /**
	 * 设置：文件名称
	 */
    public void setWenjianzhongxinName(String wenjianzhongxinName) {
        this.wenjianzhongxinName = wenjianzhongxinName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getWenjianzhongxinFile() {
        return wenjianzhongxinFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setWenjianzhongxinFile(String wenjianzhongxinFile) {
        this.wenjianzhongxinFile = wenjianzhongxinFile;
    }
    /**
	 * 获取：审核情况
	 */
    public Integer getWenjianzhongxinYesnoTypes() {
        return wenjianzhongxinYesnoTypes;
    }


    /**
	 * 设置：审核情况
	 */
    public void setWenjianzhongxinYesnoTypes(Integer wenjianzhongxinYesnoTypes) {
        this.wenjianzhongxinYesnoTypes = wenjianzhongxinYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getWenjianzhongxinYesnoText() {
        return wenjianzhongxinYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setWenjianzhongxinYesnoText(String wenjianzhongxinYesnoText) {
        this.wenjianzhongxinYesnoText = wenjianzhongxinYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWenjianzhongxinDelete() {
        return wenjianzhongxinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setWenjianzhongxinDelete(Integer wenjianzhongxinDelete) {
        this.wenjianzhongxinDelete = wenjianzhongxinDelete;
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
