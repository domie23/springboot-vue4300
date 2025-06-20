package com.entity.view;

import com.entity.WenjianzhongxinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件中心
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wenjianzhongxin")
public class WenjianzhongxinView extends WenjianzhongxinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核情况的值
		*/
		private String wenjianzhongxinYesnoValue;



		//级联表 wodeketi
			/**
			* 我的课题 的 学生
			*/
			private Integer wodeketiYonghuId;
			/**
			* 课题状态
			*/
			private Integer wodeketiTypes;
				/**
				* 课题状态的值
				*/
				private String wodeketiValue;
			/**
			* 指导教师打分
			*/
			private Integer wodeketiZhidaodafen;
			/**
			* 评阅教师打分
			*/
			private Integer wodeketiSuijia;
			/**
			* 答辩教师打分
			*/
			private Integer wodeketiSuijib;
			/**
			* 逻辑删除
			*/
			private Integer wodeketiDelete;

	public WenjianzhongxinView() {

	}

	public WenjianzhongxinView(WenjianzhongxinEntity wenjianzhongxinEntity) {
		try {
			BeanUtils.copyProperties(this, wenjianzhongxinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核情况的值
			*/
			public String getWenjianzhongxinYesnoValue() {
				return wenjianzhongxinYesnoValue;
			}
			/**
			* 设置： 审核情况的值
			*/
			public void setWenjianzhongxinYesnoValue(String wenjianzhongxinYesnoValue) {
				this.wenjianzhongxinYesnoValue = wenjianzhongxinYesnoValue;
			}


















				//级联表的get和set wodeketi

					/**
					* 获取：我的课题 的 学生
					*/
					public Integer getWodeketiYonghuId() {
						return wodeketiYonghuId;
					}
					/**
					* 设置：我的课题 的 学生
					*/
					public void setWodeketiYonghuId(Integer wodeketiYonghuId) {
						this.wodeketiYonghuId = wodeketiYonghuId;
					}



					/**
					* 获取： 课题状态
					*/
					public Integer getWodeketiTypes() {
						return wodeketiTypes;
					}
					/**
					* 设置： 课题状态
					*/
					public void setWodeketiTypes(Integer wodeketiTypes) {
						this.wodeketiTypes = wodeketiTypes;
					}


						/**
						* 获取： 课题状态的值
						*/
						public String getWodeketiValue() {
							return wodeketiValue;
						}
						/**
						* 设置： 课题状态的值
						*/
						public void setWodeketiValue(String wodeketiValue) {
							this.wodeketiValue = wodeketiValue;
						}

					/**
					* 获取： 指导教师打分
					*/
					public Integer getWodeketiZhidaodafen() {
						return wodeketiZhidaodafen;
					}
					/**
					* 设置： 指导教师打分
					*/
					public void setWodeketiZhidaodafen(Integer wodeketiZhidaodafen) {
						this.wodeketiZhidaodafen = wodeketiZhidaodafen;
					}

					/**
					* 获取： 评阅教师打分
					*/
					public Integer getWodeketiSuijia() {
						return wodeketiSuijia;
					}
					/**
					* 设置： 评阅教师打分
					*/
					public void setWodeketiSuijia(Integer wodeketiSuijia) {
						this.wodeketiSuijia = wodeketiSuijia;
					}

					/**
					* 获取： 答辩教师打分
					*/
					public Integer getWodeketiSuijib() {
						return wodeketiSuijib;
					}
					/**
					* 设置： 答辩教师打分
					*/
					public void setWodeketiSuijib(Integer wodeketiSuijib) {
						this.wodeketiSuijib = wodeketiSuijib;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getWodeketiDelete() {
						return wodeketiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setWodeketiDelete(Integer wodeketiDelete) {
						this.wodeketiDelete = wodeketiDelete;
					}






}
