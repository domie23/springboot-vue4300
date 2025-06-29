package com.dao;

import com.entity.DabianshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DabianshenqingView;

/**
 * 答辩申请 Dao 接口
 *
 * @author 
 */
public interface DabianshenqingDao extends BaseMapper<DabianshenqingEntity> {

   List<DabianshenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
