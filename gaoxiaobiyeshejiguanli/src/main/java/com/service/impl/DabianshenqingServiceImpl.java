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
import com.dao.DabianshenqingDao;
import com.entity.DabianshenqingEntity;
import com.service.DabianshenqingService;
import com.entity.view.DabianshenqingView;

/**
 * 答辩申请 服务实现类
 */
@Service("dabianshenqingService")
@Transactional
public class DabianshenqingServiceImpl extends ServiceImpl<DabianshenqingDao, DabianshenqingEntity> implements DabianshenqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<DabianshenqingView> page =new Query<DabianshenqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
