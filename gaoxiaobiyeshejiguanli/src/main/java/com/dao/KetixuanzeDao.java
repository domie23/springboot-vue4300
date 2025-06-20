package com.dao;

import com.entity.KetixuanzeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KetixuanzeView;

/**
 * 课题选择 Dao 接口
 *
 * @author 
 */
public interface KetixuanzeDao extends BaseMapper<KetixuanzeEntity> {

   List<KetixuanzeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
