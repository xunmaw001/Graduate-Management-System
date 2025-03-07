package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiaowuxinxiEntity;
import com.entity.view.JiaowuxinxiView;

import com.service.JiaowuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 教务信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/jiaowuxinxi")
public class JiaowuxinxiController {
    @Autowired
    private JiaowuxinxiService jiaowuxinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaowuxinxiEntity jiaowuxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yanjiusheng")) {
			jiaowuxinxi.setYanjiushengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daoshi")) {
			jiaowuxinxi.setDaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaowuxinxiEntity> ew = new EntityWrapper<JiaowuxinxiEntity>();


		PageUtils page = jiaowuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaowuxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaowuxinxiEntity jiaowuxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiaowuxinxiEntity> ew = new EntityWrapper<JiaowuxinxiEntity>();

		PageUtils page = jiaowuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaowuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaowuxinxiEntity jiaowuxinxi){
       	EntityWrapper<JiaowuxinxiEntity> ew = new EntityWrapper<JiaowuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaowuxinxi, "jiaowuxinxi")); 
        return R.ok().put("data", jiaowuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaowuxinxiEntity jiaowuxinxi){
        EntityWrapper< JiaowuxinxiEntity> ew = new EntityWrapper< JiaowuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaowuxinxi, "jiaowuxinxi")); 
		JiaowuxinxiView jiaowuxinxiView =  jiaowuxinxiService.selectView(ew);
		return R.ok("查询教务信息成功").put("data", jiaowuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaowuxinxiEntity jiaowuxinxi = jiaowuxinxiService.selectById(id);
        return R.ok().put("data", jiaowuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaowuxinxiEntity jiaowuxinxi = jiaowuxinxiService.selectById(id);
        return R.ok().put("data", jiaowuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaowuxinxiEntity jiaowuxinxi, HttpServletRequest request){
    	jiaowuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaowuxinxi);

        jiaowuxinxiService.insert(jiaowuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaowuxinxiEntity jiaowuxinxi, HttpServletRequest request){
    	jiaowuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaowuxinxi);

        jiaowuxinxiService.insert(jiaowuxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaowuxinxiEntity jiaowuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaowuxinxi);
        jiaowuxinxiService.updateById(jiaowuxinxi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaowuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
