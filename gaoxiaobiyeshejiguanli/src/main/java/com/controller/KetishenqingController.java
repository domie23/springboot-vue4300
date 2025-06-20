
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
 * 课题申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ketishenqing")
public class KetishenqingController {
    private static final Logger logger = LoggerFactory.getLogger(KetishenqingController.class);

    @Autowired
    private KetishenqingService ketishenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KetixuanzeService ketixuanzeService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private WodeketiService wodeketiService;

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
        params.put("ketishenqingDeleteStart",1);params.put("ketishenqingDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = ketishenqingService.queryPage(params);

        //字典表数据转换
        List<KetishenqingView> list =(List<KetishenqingView>)page.getList();
        for(KetishenqingView c:list){
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
        KetishenqingEntity ketishenqing = ketishenqingService.selectById(id);
        if(ketishenqing !=null){
            //entity转view
            KetishenqingView view = new KetishenqingView();
            BeanUtils.copyProperties( ketishenqing , view );//把实体数据重构到view中

                //级联表
                KetixuanzeEntity ketixuanze = ketixuanzeService.selectById(ketishenqing.getKetixuanzeId());
                if(ketixuanze != null){
                    BeanUtils.copyProperties( ketixuanze , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKetixuanzeId(ketixuanze.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(ketishenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody KetishenqingEntity ketishenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ketishenqing:{}",this.getClass().getName(),ketishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            ketishenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KetishenqingEntity> queryWrapper = new EntityWrapper<KetishenqingEntity>()
            .eq("yonghu_id", ketishenqing.getYonghuId())
            .eq("ketixuanze_id", ketishenqing.getKetixuanzeId())
            .eq("ketishenqing_yesno_types", ketishenqing.getKetishenqingYesnoTypes())
            .eq("ketishenqing_yesno_text", ketishenqing.getKetishenqingYesnoText())
            .eq("ketishenqing_delete", ketishenqing.getKetishenqingDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetishenqingEntity ketishenqingEntity = ketishenqingService.selectOne(queryWrapper);
        if(ketishenqingEntity==null){
            ketishenqing.setKetishenqingYesnoTypes(1);
            ketishenqing.setKetishenqingDelete(1);
            ketishenqing.setCreateTime(new Date());
            ketishenqingService.insert(ketishenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KetishenqingEntity ketishenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ketishenqing:{}",this.getClass().getName(),ketishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            ketishenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KetishenqingEntity> queryWrapper = new EntityWrapper<KetishenqingEntity>()
            .notIn("id",ketishenqing.getId())
            .andNew()
            .eq("yonghu_id", ketishenqing.getYonghuId())
            .eq("ketixuanze_id", ketishenqing.getKetixuanzeId())
            .eq("ketishenqing_yesno_types", ketishenqing.getKetishenqingYesnoTypes())
            .eq("ketishenqing_yesno_text", ketishenqing.getKetishenqingYesnoText())
            .eq("ketishenqing_delete", ketishenqing.getKetishenqingDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetishenqingEntity ketishenqingEntity = ketishenqingService.selectOne(queryWrapper);
        if(ketishenqingEntity==null){
            ketishenqingService.updateById(ketishenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody KetishenqingEntity ketishenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,ketishenqingEntity:{}",this.getClass().getName(),ketishenqingEntity.toString());

        if(ketishenqingEntity.getKetishenqingYesnoTypes() == 2){//通过
            KetixuanzeEntity ketixuanzeEntity = ketixuanzeService.selectById(ketishenqingEntity.getKetixuanzeId());
            if(ketixuanzeEntity.getKetixuanzeYixuan() >= ketixuanzeEntity.getKetixuanzeKexuan()){
                return R.error("该课题已选完");
            }
            ketixuanzeEntity.setKetixuanzeYixuan(ketixuanzeEntity.getKetixuanzeYixuan()+1);
            ketixuanzeService.updateById(ketixuanzeEntity);
            WodeketiEntity wodeketiEntity = new WodeketiEntity();
            wodeketiEntity.setCreateTime(new Date());
            wodeketiEntity.setYonghuId(ketishenqingEntity.getYonghuId());
            wodeketiEntity.setKetixuanzeId(ketishenqingEntity.getKetixuanzeId());
            wodeketiEntity.setWodeketiTypes(1);
            wodeketiEntity.setWodeketiSuijia(0);
            wodeketiEntity.setWodeketiZhidaodafen(0);
            wodeketiEntity.setWodeketiSuijib(0);
            wodeketiEntity.setWodeketiDelete(1);
            wodeketiService.insert(wodeketiEntity);
        }
        ketishenqingService.updateById(ketishenqingEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<KetishenqingEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KetishenqingEntity ketishenqingEntity = new KetishenqingEntity();
            ketishenqingEntity.setId(id);
            ketishenqingEntity.setKetishenqingDelete(2);
            list.add(ketishenqingEntity);
        }
        if(list != null && list.size() >0){
            ketishenqingService.updateBatchById(list);
        }
        return R.ok();
    }

    /**
     * 选题
     */
    @RequestMapping("/xuantia")
    public R xuantia(Integer id,HttpServletRequest request){
        Wrapper<KetishenqingEntity> queryWrapper = new EntityWrapper<KetishenqingEntity>()
                .eq("yonghu_id", request.getSession().getAttribute("userId"))
                .eq("ketishenqing_delete", 1)
                .andNew().eq("ketishenqing_yesno_types", 1).or()
                .eq("ketishenqing_yesno_types", 2)
                ;
        KetishenqingEntity ketishenqingEntity1 = ketishenqingService.selectOne(queryWrapper);
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        if(ketishenqingEntity1 != null){
            return R.error("只能选择一个课题（包括未审核的课题申请）");
        }
        KetishenqingEntity ketishenqing = new KetishenqingEntity();
        ketishenqing.setKetishenqingDelete(1);
        ketishenqing.setKetishenqingYesnoTypes(1);
        ketishenqing.setYonghuId((Integer) request.getSession().getAttribute("userId"));
        ketishenqing.setCreateTime(new Date());
        ketishenqing.setKetixuanzeId(id);
        ketishenqingService.insert(ketishenqing);

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
            List<KetishenqingEntity> ketishenqingList = new ArrayList<>();//上传的东西
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
                            KetishenqingEntity ketishenqingEntity = new KetishenqingEntity();
//                            ketishenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            ketishenqingEntity.setKetixuanzeId(Integer.valueOf(data.get(0)));   //课题选择 要改的
//                            ketishenqingEntity.setKetishenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核情况 要改的
//                            ketishenqingEntity.setKetishenqingYesnoText(data.get(0));                    //审核结果 要改的
//                            ketishenqingEntity.setKetishenqingDelete(1);//逻辑删除字段
//                            ketishenqingEntity.setCreateTime(date);//时间
                            ketishenqingList.add(ketishenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        ketishenqingService.insertBatch(ketishenqingList);
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
