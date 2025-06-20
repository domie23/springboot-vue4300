
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
 * 课题选择
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ketixuanze")
public class KetixuanzeController {
    private static final Logger logger = LoggerFactory.getLogger(KetixuanzeController.class);

    @Autowired
    private KetixuanzeService ketixuanzeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            params.put("ketixuanzeYesnoTypes",2);
        }else if("教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("ketixuanzeDeleteStart",1);params.put("ketixuanzeDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = ketixuanzeService.queryPage(params);

        //字典表数据转换
        List<KetixuanzeView> list =(List<KetixuanzeView>)page.getList();
        for(KetixuanzeView c:list){
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
        KetixuanzeEntity ketixuanze = ketixuanzeService.selectById(id);
        if(ketixuanze !=null){
            //entity转view
            KetixuanzeView view = new KetixuanzeView();
            BeanUtils.copyProperties( ketixuanze , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(ketixuanze.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
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
    public R save(@RequestBody KetixuanzeEntity ketixuanze, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ketixuanze:{}",this.getClass().getName(),ketixuanze.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教师".equals(role))
            ketixuanze.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KetixuanzeEntity> queryWrapper = new EntityWrapper<KetixuanzeEntity>()
            .eq("jiaoshi_id", ketixuanze.getJiaoshiId())
            .eq("ketixuanze_name", ketixuanze.getKetixuanzeName())
            .eq("ketixuanze_types", ketixuanze.getKetixuanzeTypes())
            .eq("laiyuan_types", ketixuanze.getLaiyuanTypes())
            .eq("zhuanye_types", ketixuanze.getZhuanyeTypes())
            .eq("ketixuanze_yixuan", ketixuanze.getKetixuanzeYixuan())
            .eq("ketixuanze_kexuan", ketixuanze.getKetixuanzeKexuan())
            .eq("ketixuanze_yesno_types", ketixuanze.getKetixuanzeYesnoTypes())
            .eq("ketixuanze_yesno_text", ketixuanze.getKetixuanzeYesnoText())
            .eq("ketixuanze_delete", ketixuanze.getKetixuanzeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetixuanzeEntity ketixuanzeEntity = ketixuanzeService.selectOne(queryWrapper);
        if(ketixuanzeEntity==null){
            ketixuanze.setKetixuanzeYesnoTypes(1);
            ketixuanze.setKetixuanzeDelete(1);
            ketixuanze.setCreateTime(new Date());
            ketixuanzeService.insert(ketixuanze);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KetixuanzeEntity ketixuanze, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ketixuanze:{}",this.getClass().getName(),ketixuanze.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教师".equals(role))
//            ketixuanze.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KetixuanzeEntity> queryWrapper = new EntityWrapper<KetixuanzeEntity>()
            .notIn("id",ketixuanze.getId())
            .andNew()
            .eq("jiaoshi_id", ketixuanze.getJiaoshiId())
            .eq("ketixuanze_name", ketixuanze.getKetixuanzeName())
            .eq("ketixuanze_types", ketixuanze.getKetixuanzeTypes())
            .eq("laiyuan_types", ketixuanze.getLaiyuanTypes())
            .eq("zhuanye_types", ketixuanze.getZhuanyeTypes())
            .eq("ketixuanze_yixuan", ketixuanze.getKetixuanzeYixuan())
            .eq("ketixuanze_kexuan", ketixuanze.getKetixuanzeKexuan())
            .eq("ketixuanze_yesno_types", ketixuanze.getKetixuanzeYesnoTypes())
            .eq("ketixuanze_yesno_text", ketixuanze.getKetixuanzeYesnoText())
            .eq("ketixuanze_delete", ketixuanze.getKetixuanzeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KetixuanzeEntity ketixuanzeEntity = ketixuanzeService.selectOne(queryWrapper);
        if(ketixuanzeEntity==null){
            ketixuanzeService.updateById(ketixuanze);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody KetixuanzeEntity ketixuanzeEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,ketixuanzeEntity:{}",this.getClass().getName(),ketixuanzeEntity.toString());

//        if(ketixuanzeEntity.getKetixuanzeYesnoTypes() == 2){//通过
//            ketixuanzeEntity.setKetixuanzeTypes();
//        }else if(ketixuanzeEntity.getKetixuanzeYesnoTypes() == 3){//拒绝
//            ketixuanzeEntity.setKetixuanzeTypes();
//        }
        ketixuanzeService.updateById(ketixuanzeEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<KetixuanzeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KetixuanzeEntity ketixuanzeEntity = new KetixuanzeEntity();
            ketixuanzeEntity.setId(id);
            ketixuanzeEntity.setKetixuanzeDelete(2);
            list.add(ketixuanzeEntity);
        }
        if(list != null && list.size() >0){
            ketixuanzeService.updateBatchById(list);
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
            List<KetixuanzeEntity> ketixuanzeList = new ArrayList<>();//上传的东西
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
                            KetixuanzeEntity ketixuanzeEntity = new KetixuanzeEntity();
//                            ketixuanzeEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            ketixuanzeEntity.setKetixuanzeName(data.get(0));                    //课题名称 要改的
//                            ketixuanzeEntity.setKetixuanzeTypes(Integer.valueOf(data.get(0)));   //课题类型 要改的
//                            ketixuanzeEntity.setLaiyuanTypes(Integer.valueOf(data.get(0)));   //课题来源 要改的
//                            ketixuanzeEntity.setZhuanyeTypes(Integer.valueOf(data.get(0)));   //适用专业 要改的
//                            ketixuanzeEntity.setKetixuanzeYixuan(Integer.valueOf(data.get(0)));   //已选人数 要改的
//                            ketixuanzeEntity.setKetixuanzeKexuan(Integer.valueOf(data.get(0)));   //可选人数 要改的
//                            ketixuanzeEntity.setKetixuanzeContent("");//详情和图片
//                            ketixuanzeEntity.setKetixuanzeYesnoTypes(Integer.valueOf(data.get(0)));   //审核情况 要改的
//                            ketixuanzeEntity.setKetixuanzeYesnoText(data.get(0));                    //审核结果 要改的
//                            ketixuanzeEntity.setKetixuanzeDelete(1);//逻辑删除字段
//                            ketixuanzeEntity.setCreateTime(date);//时间
                            ketixuanzeList.add(ketixuanzeEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        ketixuanzeService.insertBatch(ketixuanzeList);
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
