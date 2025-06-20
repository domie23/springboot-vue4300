package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.WodeketiDao;
import com.entity.WodeketiEntity;
import com.service.WodeketiService;
import com.entity.view.WodeketiView;

/**
 * 我的课题 服务实现类
 */
@Service("wodeketiService")
@Transactional
public class WodeketiServiceImpl extends ServiceImpl<WodeketiDao, WodeketiEntity> implements WodeketiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WodeketiView> page =new Query<WodeketiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
