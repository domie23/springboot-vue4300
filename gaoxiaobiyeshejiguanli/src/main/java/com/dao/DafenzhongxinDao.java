package com.dao;

import com.entity.DafenzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DafenzhongxinView;

/**
 * 打分记录 Dao 接口
 *
 * @author 
 */
public interface DafenzhongxinDao extends BaseMapper<DafenzhongxinEntity> {

   List<DafenzhongxinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
