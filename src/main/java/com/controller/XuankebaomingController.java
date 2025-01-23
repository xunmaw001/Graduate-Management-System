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

import com.entity.XuankebaomingEntity;
import com.entity.view.XuankebaomingView;

import com.service.XuankebaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 选课报名
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/xuankebaoming")
public class XuankebaomingController {
    @Autowired
    private XuankebaomingService xuankebaomingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuankebaomingEntity xuankebaoming, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yanjiusheng")) {
			xuankebaoming.setYanjiushengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daoshi")) {
			xuankebaoming.setDaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuankebaomingEntity> ew = new EntityWrapper<XuankebaomingEntity>();


		PageUtils page = xuankebaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuankebaoming), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuankebaomingEntity xuankebaoming, 
		HttpServletRequest request){
        EntityWrapper<XuankebaomingEntity> ew = new EntityWrapper<XuankebaomingEntity>();

		PageUtils page = xuankebaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuankebaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuankebaomingEntity xuankebaoming){
       	EntityWrapper<XuankebaomingEntity> ew = new EntityWrapper<XuankebaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuankebaoming, "xuankebaoming")); 
        return R.ok().put("data", xuankebaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuankebaomingEntity xuankebaoming){
        EntityWrapper< XuankebaomingEntity> ew = new EntityWrapper< XuankebaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuankebaoming, "xuankebaoming")); 
		XuankebaomingView xuankebaomingView =  xuankebaomingService.selectView(ew);
		return R.ok("查询选课报名成功").put("data", xuankebaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuankebaomingEntity xuankebaoming = xuankebaomingService.selectById(id);
        return R.ok().put("data", xuankebaoming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuankebaomingEntity xuankebaoming = xuankebaomingService.selectById(id);
        return R.ok().put("data", xuankebaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuankebaomingEntity xuankebaoming, HttpServletRequest request){
    	xuankebaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuankebaoming);

        xuankebaomingService.insert(xuankebaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuankebaomingEntity xuankebaoming, HttpServletRequest request){
    	xuankebaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuankebaoming);

        xuankebaomingService.insert(xuankebaoming);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuankebaomingEntity xuankebaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuankebaoming);
        xuankebaomingService.updateById(xuankebaoming);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuankebaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
