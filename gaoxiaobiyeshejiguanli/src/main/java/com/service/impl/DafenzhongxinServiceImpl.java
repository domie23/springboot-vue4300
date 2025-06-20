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
import com.dao.DafenzhongxinDao;
import com.entity.DafenzhongxinEntity;
import com.service.DafenzhongxinService;
import com.entity.view.DafenzhongxinView;

/**
 * 打分记录 服务实现类
 */
@Service("dafenzhongxinService")
@Transactional
public class DafenzhongxinServiceImpl extends ServiceImpl<DafenzhongxinDao, DafenzhongxinEntity> implements DafenzhongxinService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<DafenzhongxinView> page =new Query<DafenzhongxinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
