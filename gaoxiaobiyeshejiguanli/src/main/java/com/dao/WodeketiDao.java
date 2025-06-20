package com.dao;

import com.entity.WodeketiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WodeketiView;

/**
 * 我的课题 Dao 接口
 *
 * @author 
 */
public interface WodeketiDao extends BaseMapper<WodeketiEntity> {

   List<WodeketiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
