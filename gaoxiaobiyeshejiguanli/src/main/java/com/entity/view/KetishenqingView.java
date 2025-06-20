package com.entity.view;

import com.entity.KetishenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 课题申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("ketishenqing")
public class KetishenqingView extends KetishenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核情况的值
		*/
		private String ketishenqingYesnoValue;



		//级联表 ketixuanze
			/**
			* 课题选择 的 教师
			*/
			private Integer ketixuanzeJiaoshiId;
			/**
			* 课题名称
			*/
			private String ketixuanzeName;
			/**
			* 课题类型
			*/
			private Integer ketixuanzeTypes;
				/**
				* 课题类型的值
				*/
				private String ketixuanzeValue;
			/**
			* 课题来源
			*/
			private Integer laiyuanTypes;
				/**
				* 课题来源的值
				*/
				private String laiyuanValue;
			/**
			* 适用专业
			*/
			private Integer zhuanyeTypes;
				/**
				* 适用专业的值
				*/
				private String zhuanyeValue;
			/**
			* 已选人数
			*/
			private Integer ketixuanzeYixuan;
			/**
			* 可选人数
			*/
			private Integer ketixuanzeKexuan;
			/**
			* 课题详情
			*/
			private String ketixuanzeContent;
			/**
			* 审核情况
			*/
			private Integer ketixuanzeYesnoTypes;
				/**
				* 审核情况的值
				*/
				private String ketixuanzeYesnoValue;
			/**
			* 审核结果
			*/
			private String ketixuanzeYesnoText;
			/**
			* 逻辑删除
			*/
			private Integer ketixuanzeDelete;

		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**

			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public KetishenqingView() {

	}

	public KetishenqingView(KetishenqingEntity ketishenqingEntity) {
		try {
			BeanUtils.copyProperties(this, ketishenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核情况的值
			*/
			public String getKetishenqingYesnoValue() {
				return ketishenqingYesnoValue;
			}
			/**
			* 设置： 审核情况的值
			*/
			public void setKetishenqingYesnoValue(String ketishenqingYesnoValue) {
				this.ketishenqingYesnoValue = ketishenqingYesnoValue;
			}

















				//级联表的get和set ketixuanze

					/**
					* 获取：课题选择 的 教师
					*/
					public Integer getKetixuanzeJiaoshiId() {
						return ketixuanzeJiaoshiId;
					}
					/**
					* 设置：课题选择 的 教师
					*/
					public void setKetixuanzeJiaoshiId(Integer ketixuanzeJiaoshiId) {
						this.ketixuanzeJiaoshiId = ketixuanzeJiaoshiId;
					}


					/**
					* 获取： 课题名称
					*/
					public String getKetixuanzeName() {
						return ketixuanzeName;
					}
					/**
					* 设置： 课题名称
					*/
					public void setKetixuanzeName(String ketixuanzeName) {
						this.ketixuanzeName = ketixuanzeName;
					}

					/**
					* 获取： 课题类型
					*/
					public Integer getKetixuanzeTypes() {
						return ketixuanzeTypes;
					}
					/**
					* 设置： 课题类型
					*/
					public void setKetixuanzeTypes(Integer ketixuanzeTypes) {
						this.ketixuanzeTypes = ketixuanzeTypes;
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
					* 获取： 课题来源
					*/
					public Integer getLaiyuanTypes() {
						return laiyuanTypes;
					}
					/**
					* 设置： 课题来源
					*/
					public void setLaiyuanTypes(Integer laiyuanTypes) {
						this.laiyuanTypes = laiyuanTypes;
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
					* 获取： 已选人数
					*/
					public Integer getKetixuanzeYixuan() {
						return ketixuanzeYixuan;
					}
					/**
					* 设置： 已选人数
					*/
					public void setKetixuanzeYixuan(Integer ketixuanzeYixuan) {
						this.ketixuanzeYixuan = ketixuanzeYixuan;
					}

					/**
					* 获取： 可选人数
					*/
					public Integer getKetixuanzeKexuan() {
						return ketixuanzeKexuan;
					}
					/**
					* 设置： 可选人数
					*/
					public void setKetixuanzeKexuan(Integer ketixuanzeKexuan) {
						this.ketixuanzeKexuan = ketixuanzeKexuan;
					}

					/**
					* 获取： 课题详情
					*/
					public String getKetixuanzeContent() {
						return ketixuanzeContent;
					}
					/**
					* 设置： 课题详情
					*/
					public void setKetixuanzeContent(String ketixuanzeContent) {
						this.ketixuanzeContent = ketixuanzeContent;
					}

					/**
					* 获取： 审核情况
					*/
					public Integer getKetixuanzeYesnoTypes() {
						return ketixuanzeYesnoTypes;
					}
					/**
					* 设置： 审核情况
					*/
					public void setKetixuanzeYesnoTypes(Integer ketixuanzeYesnoTypes) {
						this.ketixuanzeYesnoTypes = ketixuanzeYesnoTypes;
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

					/**
					* 获取： 审核结果
					*/
					public String getKetixuanzeYesnoText() {
						return ketixuanzeYesnoText;
					}
					/**
					* 设置： 审核结果
					*/
					public void setKetixuanzeYesnoText(String ketixuanzeYesnoText) {
						this.ketixuanzeYesnoText = ketixuanzeYesnoText;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getKetixuanzeDelete() {
						return ketixuanzeDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setKetixuanzeDelete(Integer ketixuanzeDelete) {
						this.ketixuanzeDelete = ketixuanzeDelete;
					}











				//级联表的get和set yonghu

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
					}


						/**
						* 获取： 专业的值
						*/
						public String getZhuanyeValue() {
							return zhuanyeValue;
						}
						/**
						* 设置： 专业的值
						*/
						public void setZhuanyeValue(String zhuanyeValue) {
							this.zhuanyeValue = zhuanyeValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}







}
