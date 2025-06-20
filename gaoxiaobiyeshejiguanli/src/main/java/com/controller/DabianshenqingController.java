
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 答辩申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dabianshenqing")
public class DabianshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(DabianshenqingController.class);

    @Autowired
    private DabianshenqingService dabianshenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private WodeketiService wodeketiService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        params.put("dabianshenqingDeleteStart",1);params.put("dabianshenqingDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dabianshenqingService.queryPage(params);

        //字典表数据转换
        List<DabianshenqingView> list =(List<DabianshenqingView>)page.getList();
        for(DabianshenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DabianshenqingEntity dabianshenqing = dabianshenqingService.selectById(id);
        if(dabianshenqing !=null){
            //entity转view
            DabianshenqingView view = new DabianshenqingView();
            BeanUtils.copyProperties( dabianshenqing , view );//把实体数据重构到view中

                //级联表
                WodeketiEntity wodeketi = wodeketiService.selectById(dabianshenqing.getWodeketiId());
                if(wodeketi != null){
                    BeanUtils.copyProperties( wodeketi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWodeketiId(wodeketi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DabianshenqingEntity dabianshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dabianshenqing:{}",this.getClass().getName(),dabianshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DabianshenqingEntity> queryWrapper = new EntityWrapper<DabianshenqingEntity>()
            .eq("wodeketi_id", dabianshenqing.getWodeketiId())
                .andNew().eq("dabianshenqing_yesno_types", 1)
                .or().eq("dabianshenqing_yesno_types", 2)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DabianshenqingEntity dabianshenqingEntity = dabianshenqingService.selectOne(queryWrapper);
        if(dabianshenqingEntity==null){
            dabianshenqing.setDabianshenqingYesnoTypes(1);
            dabianshenqing.setDabianshenqingDelete(1);
            dabianshenqing.setCreateTime(new Date());
            dabianshenqingService.insert(dabianshenqing);
            return R.ok();
        }else {
            return R.error(511,"请不要重复申请");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DabianshenqingEntity dabianshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dabianshenqing:{}",this.getClass().getName(),dabianshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<DabianshenqingEntity> queryWrapper = new EntityWrapper<DabianshenqingEntity>()
            .notIn("id",dabianshenqing.getId())
            .andNew()
            .eq("wodeketi_id", dabianshenqing.getWodeketiId())
            .eq("dabianshenqing_types", dabianshenqing.getDabianshenqingTypes())
            .eq("dabianshenqing_number", dabianshenqing.getDabianshenqingNumber())
            .eq("dabianshenqing_yesno_types", dabianshenqing.getDabianshenqingYesnoTypes())
            .eq("dabianshenqing_yesno_text", dabianshenqing.getDabianshenqingYesnoText())
            .eq("dabianshenqing_delete", dabianshenqing.getDabianshenqingDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DabianshenqingEntity dabianshenqingEntity = dabianshenqingService.selectOne(queryWrapper);
        if(dabianshenqingEntity==null){
            dabianshenqingService.updateById(dabianshenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody DabianshenqingEntity dabianshenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,dabianshenqingEntity:{}",this.getClass().getName(),dabianshenqingEntity.toString());

        if(dabianshenqingEntity.getDabianshenqingYesnoTypes() == 2){//通过
            WodeketiEntity wodeketiEntity = wodeketiService.selectById(dabianshenqingEntity.getWodeketiId());
            if(wodeketiEntity == null){
                return R.error("数据丢失");
            }
            wodeketiEntity.setWodeketiTypes(8);
            wodeketiService.updateById(wodeketiEntity);
        }

        dabianshenqingService.updateById(dabianshenqingEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<DabianshenqingEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DabianshenqingEntity dabianshenqingEntity = new DabianshenqingEntity();
            dabianshenqingEntity.setId(id);
            dabianshenqingEntity.setDabianshenqingDelete(2);
            list.add(dabianshenqingEntity);
        }
        if(list != null && list.size() >0){
            dabianshenqingService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DabianshenqingEntity> dabianshenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DabianshenqingEntity dabianshenqingEntity = new DabianshenqingEntity();
//                            dabianshenqingEntity.setWodeketiId(Integer.valueOf(data.get(0)));   //课题 要改的
//                            dabianshenqingEntity.setDabianshenqingTypes(Integer.valueOf(data.get(0)));   //答辩状态 要改的
//                            dabianshenqingEntity.setDabianshenqingNumber(Integer.valueOf(data.get(0)));   //答辩打分 要改的
//                            dabianshenqingEntity.setDabianshenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核情况 要改的
//                            dabianshenqingEntity.setDabianshenqingYesnoText(data.get(0));                    //审核结果 要改的
//                            dabianshenqingEntity.setDabianshenqingDelete(1);//逻辑删除字段
//                            dabianshenqingEntity.setCreateTime(date);//时间
                            dabianshenqingList.add(dabianshenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        dabianshenqingService.insertBatch(dabianshenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
