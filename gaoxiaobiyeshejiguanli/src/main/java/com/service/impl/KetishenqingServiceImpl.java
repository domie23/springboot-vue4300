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
import com.dao.KetishenqingDao;
import com.entity.KetishenqingEntity;
import com.service.KetishenqingService;
import com.entity.view.KetishenqingView;

/**
 * 课题申请 服务实现类
 */
@Service("ketishenqingService")
@Transactional
public class KetishenqingServiceImpl extends ServiceImpl<KetishenqingDao, KetishenqingEntity> implements KetishenqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<KetishenqingView> page =new Query<KetishenqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
