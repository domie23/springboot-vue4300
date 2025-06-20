
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
 * 我的课题
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wodeketi")
public class WodeketiController {
    private static final Logger logger = LoggerFactory.getLogger(WodeketiController.class);

    @Autowired
    private WodeketiService wodeketiService;


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
    private JiaoshiService jiaoshiService;
    @Autowired
    private DafenzhongxinService dafenzhongxinService;


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
        params.put("wodeketiDeleteStart",1);params.put("wodeketiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wodeketiService.queryPage(params);

        //字典表数据转换
        List<WodeketiView> list =(List<WodeketiView>)page.getList();
        for(WodeketiView c:list){
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
        WodeketiEntity wodeketi = wodeketiService.selectById(id);
        if(wodeketi !=null){
            //entity转view
            WodeketiView view = new WodeketiView();
            BeanUtils.copyProperties( wodeketi , view );//把实体数据重构到view中

                //级联表
                KetixuanzeEntity ketixuanze = ketixuanzeService.selectById(wodeketi.getKetixuanzeId());
                if(ketixuanze != null){
                    BeanUtils.copyProperties( ketixuanze , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKetixuanzeId(ketixuanze.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(wodeketi.getYonghuId());
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
    public R save(@RequestBody WodeketiEntity wodeketi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wodeketi:{}",this.getClass().getName(),wodeketi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            wodeketi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WodeketiEntity> queryWrapper = new EntityWrapper<WodeketiEntity>()
            .eq("yonghu_id", wodeketi.getYonghuId())
            .eq("ketixuanze_id", wodeketi.getKetixuanzeId())
            .eq("wodeketi_types", wodeketi.getWodeketiTypes())
            .eq("wodeketi_zhidaodafen", wodeketi.getWodeketiZhidaodafen())
            .eq("wodeketi_suijia", wodeketi.getWodeketiSuijia())
            .eq("wodeketi_suijib", wodeketi.getWodeketiSuijib())
            .eq("wodeketi_delete", wodeketi.getWodeketiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WodeketiEntity wodeketiEntity = wodeketiService.selectOne(queryWrapper);
        if(wodeketiEntity==null){
            wodeketi.setWodeketiDelete(1);
            wodeketi.setCreateTime(new Date());
            wodeketiService.insert(wodeketi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WodeketiEntity wodeketi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wodeketi:{}",this.getClass().getName(),wodeketi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            wodeketi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WodeketiEntity> queryWrapper = new EntityWrapper<WodeketiEntity>()
            .notIn("id",wodeketi.getId())
            .andNew()
            .eq("yonghu_id", wodeketi.getYonghuId())
            .eq("ketixuanze_id", wodeketi.getKetixuanzeId())
            .eq("wodeketi_types", wodeketi.getWodeketiTypes())
            .eq("wodeketi_zhidaodafen", wodeketi.getWodeketiZhidaodafen())
            .eq("wodeketi_suijia", wodeketi.getWodeketiSuijia())
            .eq("wodeketi_suijib", wodeketi.getWodeketiSuijib())
            .eq("wodeketi_delete", wodeketi.getWodeketiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WodeketiEntity wodeketiEntity = wodeketiService.selectOne(queryWrapper);
        if(wodeketiEntity==null){
            wodeketiService.updateById(wodeketi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 后端修改
     */
    @RequestMapping("/dafen")
    public R dafen(Integer wodeketiId,Integer ketixuanzeId,Integer dafenzhongxinSum,HttpServletRequest request){
        KetixuanzeEntity ketixuanzeEntity = ketixuanzeService.selectById(ketixuanzeId);
        WodeketiEntity wodeketiEntity = wodeketiService.selectById(wodeketiId);
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        DafenzhongxinEntity dafenzhongxinEntity = new DafenzhongxinEntity();
        if(ketixuanzeEntity == null || wodeketiEntity == null){
            return R.error("数据丢失");
        }

        Boolean yanzheng = false;

        if(wodeketiEntity.getWodeketiTypes() == 8){
            if(wodeketiEntity.getWodeketiSuijib() > 0){
                return R.error("答辩教师已经打分，请不要重复操作");
            }
            if(dafenzhongxinSum > 30){
                return R.error("答辩教师打分满分为30分");
            }
            yanzheng = true;
            wodeketiEntity.setWodeketiSuijib(dafenzhongxinSum);
            wodeketiEntity.setWodeketiTypes(9);
        }
        if(yanzheng == false){
            if(ketixuanzeEntity.getJiaoshiId() == userId){
                if(wodeketiEntity.getWodeketiZhidaodafen() > 0){
                    return R.error("指导教师已经打分，请不要重复操作");
                }
                if(dafenzhongxinSum > 30){
                    return R.error("指导教师打分满分为40分");
                }
                wodeketiEntity.setWodeketiZhidaodafen(dafenzhongxinSum);

            } else {
                if(wodeketiEntity.getWodeketiSuijia() > 0){
                    return R.error("评阅教师已经打分，请不要重复操作");
                }
                if(dafenzhongxinSum > 30){
                    return R.error("评阅教师打分满分为30分");
                }
                wodeketiEntity.setWodeketiSuijia(dafenzhongxinSum);

            }
        }




        wodeketiService.updateById(wodeketiEntity);

        dafenzhongxinEntity.setDafenzhongxinSum(dafenzhongxinSum);
        dafenzhongxinEntity.setJiaoshiId(userId);
        dafenzhongxinEntity.setDafenzhongxinDelete(1);
        dafenzhongxinEntity.setWodeketiId(wodeketiId);
        dafenzhongxinEntity.setCreateTime(new Date());
        dafenzhongxinService.insert(dafenzhongxinEntity);


        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<WodeketiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WodeketiEntity wodeketiEntity = new WodeketiEntity();
            wodeketiEntity.setId(id);
            wodeketiEntity.setWodeketiDelete(2);
            list.add(wodeketiEntity);
        }
        if(list != null && list.size() >0){
            wodeketiService.updateBatchById(list);
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
            List<WodeketiEntity> wodeketiList = new ArrayList<>();//上传的东西
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
                            WodeketiEntity wodeketiEntity = new WodeketiEntity();
//                            wodeketiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            wodeketiEntity.setKetixuanzeId(Integer.valueOf(data.get(0)));   //课题选择 要改的
//                            wodeketiEntity.setWodeketiTypes(Integer.valueOf(data.get(0)));   //课题状态 要改的
//                            wodeketiEntity.setWodeketiZhidaodafen(Integer.valueOf(data.get(0)));   //指导教师打分 要改的
//                            wodeketiEntity.setWodeketiSuijia(Integer.valueOf(data.get(0)));   //评阅教师打分 要改的
//                            wodeketiEntity.setWodeketiSuijib(Integer.valueOf(data.get(0)));   //答辩教师打分 要改的
//                            wodeketiEntity.setWodeketiDelete(1);//逻辑删除字段
//                            wodeketiEntity.setCreateTime(date);//时间
                            wodeketiList.add(wodeketiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wodeketiService.insertBatch(wodeketiList);
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
