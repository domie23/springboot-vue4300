package com.dao;

import com.entity.KetishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KetishenqingView;

/**
 * 课题申请 Dao 接口
 *
 * @author 
 */
public interface KetishenqingDao extends BaseMapper<KetishenqingEntity> {

   List<KetishenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
