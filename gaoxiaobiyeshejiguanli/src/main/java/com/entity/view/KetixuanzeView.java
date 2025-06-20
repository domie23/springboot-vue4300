package com.entity.view;

import com.entity.KetixuanzeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 课题选择
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("ketixuanze")
public class KetixuanzeView extends KetixuanzeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 课题类型的值
		*/
		private String ketixuanzeValue;
		/**
		* 课题来源的值
		*/
		private String laiyuanValue;
		/**
		* 适用专业的值
		*/
		private String zhuanyeValue;
		/**
		* 审核情况的值
		*/
		private String ketixuanzeYesnoValue;



		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 头像
			*/
			private String jiaoshiPhoto;
			/**
			* 联系方式
			*/
			private String jiaoshiPhone;
			/**
			* 假删
			*/
			private Integer jiaoshiDelete;

	public KetixuanzeView() {

	}

	public KetixuanzeView(KetixuanzeEntity ketixuanzeEntity) {
		try {
			BeanUtils.copyProperties(this, ketixuanzeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 课题类型的值
			*/
			public String getKetixuanzeValue() {
				return ketixuanzeValue;
			}
			/**
			* 设置： 课题类型的值
			*/
			public void setKetixuanzeValue(String ketixuanzeValue) {
				this.ketixuanzeValue = ketixuanzeValue;
			}
			/**
			* 获取： 课题来源的值
			*/
			public String getLaiyuanValue() {
				return laiyuanValue;
			}
			/**
			* 设置： 课题来源的值
			*/
			public void setLaiyuanValue(String laiyuanValue) {
				this.laiyuanValue = laiyuanValue;
			}
			/**
			* 获取： 适用专业的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 适用专业的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
			}
			/**
			* 获取： 审核情况的值
			*/
			public String getKetixuanzeYesnoValue() {
				return ketixuanzeYesnoValue;
			}
			/**
			* 设置： 审核情况的值
			*/
			public void setKetixuanzeYesnoValue(String ketixuanzeYesnoValue) {
				this.ketixuanzeYesnoValue = ketixuanzeYesnoValue;
			}






















				//级联表的get和set jiaoshi

					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}

					/**
					* 获取： 头像
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}

					/**
					* 获取： 假删
					*/
					public Integer getJiaoshiDelete() {
						return jiaoshiDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setJiaoshiDelete(Integer jiaoshiDelete) {
						this.jiaoshiDelete = jiaoshiDelete;
					}


}
