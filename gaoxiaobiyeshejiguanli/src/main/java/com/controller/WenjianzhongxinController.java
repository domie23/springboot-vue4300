
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
 * 文件中心
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenjianzhongxin")
public class WenjianzhongxinController {
    private static final Logger logger = LoggerFactory.getLogger(WenjianzhongxinController.class);

    @Autowired
    private WenjianzhongxinService wenjianzhongxinService;


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
        params.put("wenjianzhongxinDeleteStart",1);params.put("wenjianzhongxinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wenjianzhongxinService.queryPage(params);

        //字典表数据转换
        List<WenjianzhongxinView> list =(List<WenjianzhongxinView>)page.getList();
        for(WenjianzhongxinView c:list){
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
        WenjianzhongxinEntity wenjianzhongxin = wenjianzhongxinService.selectById(id);
        if(wenjianzhongxin !=null){
            //entity转view
            WenjianzhongxinView view = new WenjianzhongxinView();
            BeanUtils.copyProperties( wenjianzhongxin , view );//把实体数据重构到view中

                //级联表
                WodeketiEntity wodeketi = wodeketiService.selectById(wenjianzhongxin.getWodeketiId());
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
    public R save(@RequestBody WenjianzhongxinEntity wenjianzhongxin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenjianzhongxin:{}",this.getClass().getName(),wenjianzhongxin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        wenjianzhongxin.setWenjianzhongxinYesnoTypes(1);
        wenjianzhongxin.setWenjianzhongxinDelete(1);
        Wrapper<WenjianzhongxinEntity> queryWrapper = new EntityWrapper<WenjianzhongxinEntity>()
            .eq("wodeketi_id", wenjianzhongxin.getWodeketiId())
            .eq("wenjianzhongxin_name", wenjianzhongxin.getWenjianzhongxinName())
            .eq("wenjianzhongxin_yesno_types", wenjianzhongxin.getWenjianzhongxinYesnoTypes())
            .eq("wenjianzhongxin_delete", wenjianzhongxin.getWenjianzhongxinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianzhongxinEntity wenjianzhongxinEntity = wenjianzhongxinService.selectOne(queryWrapper);
        if(wenjianzhongxinEntity==null){
            wenjianzhongxin.setCreateTime(new Date());
            wenjianzhongxinService.insert(wenjianzhongxin);
            return R.ok();
        }else {
            return R.error(511,"请不要重复上传");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenjianzhongxinEntity wenjianzhongxin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wenjianzhongxin:{}",this.getClass().getName(),wenjianzhongxin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<WenjianzhongxinEntity> queryWrapper = new EntityWrapper<WenjianzhongxinEntity>()
            .notIn("id",wenjianzhongxin.getId())
            .andNew()
            .eq("wodeketi_id", wenjianzhongxin.getWodeketiId())
            .eq("wenjianzhongxin_name", wenjianzhongxin.getWenjianzhongxinName())
            .eq("wenjianzhongxin_yesno_types", wenjianzhongxin.getWenjianzhongxinYesnoTypes())
            .eq("wenjianzhongxin_yesno_text", wenjianzhongxin.getWenjianzhongxinYesnoText())
            .eq("wenjianzhongxin_delete", wenjianzhongxin.getWenjianzhongxinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianzhongxinEntity wenjianzhongxinEntity = wenjianzhongxinService.selectOne(queryWrapper);
        if("".equals(wenjianzhongxin.getWenjianzhongxinFile()) || "null".equals(wenjianzhongxin.getWenjianzhongxinFile())){
                wenjianzhongxin.setWenjianzhongxinFile(null);
        }
        if(wenjianzhongxinEntity==null){
            wenjianzhongxinService.updateById(wenjianzhongxin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 审核
     */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WenjianzhongxinEntity wenjianzhongxinEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wenjianzhongxinEntity:{}",this.getClass().getName(),wenjianzhongxinEntity.toString());

        if(wenjianzhongxinEntity.getWenjianzhongxinYesnoTypes() == 2){//通过
            WodeketiEntity wodeketiEntity = wodeketiService.selectById(wenjianzhongxinEntity.getWodeketiId());
            if(wodeketiEntity != null){
                if(wodeketiEntity.getWodeketiTypes() < 7){
                    wodeketiEntity.setWodeketiTypes(wodeketiEntity.getWodeketiTypes()+1);
                    wodeketiService.updateById(wodeketiEntity);
                }
            }
        }
        wenjianzhongxinService.updateById(wenjianzhongxinEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<WenjianzhongxinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WenjianzhongxinEntity wenjianzhongxinEntity = new WenjianzhongxinEntity();
            wenjianzhongxinEntity.setId(id);
            wenjianzhongxinEntity.setWenjianzhongxinDelete(2);
            list.add(wenjianzhongxinEntity);
        }
        if(list != null && list.size() >0){
            wenjianzhongxinService.updateBatchById(list);
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
            List<WenjianzhongxinEntity> wenjianzhongxinList = new ArrayList<>();//上传的东西
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
                            WenjianzhongxinEntity wenjianzhongxinEntity = new WenjianzhongxinEntity();
//                            wenjianzhongxinEntity.setWodeketiId(Integer.valueOf(data.get(0)));   //课题 要改的
//                            wenjianzhongxinEntity.setWenjianzhongxinName(data.get(0));                    //文件名称 要改的
//                            wenjianzhongxinEntity.setWenjianzhongxinFile(data.get(0));                    //文件上传 要改的
//                            wenjianzhongxinEntity.setWenjianzhongxinYesnoTypes(Integer.valueOf(data.get(0)));   //审核情况 要改的
//                            wenjianzhongxinEntity.setWenjianzhongxinYesnoText(data.get(0));                    //审核结果 要改的
//                            wenjianzhongxinEntity.setWenjianzhongxinDelete(1);//逻辑删除字段
//                            wenjianzhongxinEntity.setCreateTime(date);//时间
                            wenjianzhongxinList.add(wenjianzhongxinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wenjianzhongxinService.insertBatch(wenjianzhongxinList);
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
