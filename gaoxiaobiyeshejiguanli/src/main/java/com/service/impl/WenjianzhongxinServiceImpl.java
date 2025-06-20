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
import com.dao.WenjianzhongxinDao;
import com.entity.WenjianzhongxinEntity;
import com.service.WenjianzhongxinService;
import com.entity.view.WenjianzhongxinView;

/**
 * 文件中心 服务实现类
 */
@Service("wenjianzhongxinService")
@Transactional
public class WenjianzhongxinServiceImpl extends ServiceImpl<WenjianzhongxinDao, WenjianzhongxinEntity> implements WenjianzhongxinService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WenjianzhongxinView> page =new Query<WenjianzhongxinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
