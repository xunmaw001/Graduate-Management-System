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

import com.entity.XueweiEntity;
import com.entity.view.XueweiView;

import com.service.XueweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 学位
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/xuewei")
public class XueweiController {
    @Autowired
    private XueweiService xueweiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueweiEntity xuewei, 
		HttpServletRequest request){

        EntityWrapper<XueweiEntity> ew = new EntityWrapper<XueweiEntity>();


		PageUtils page = xueweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuewei), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueweiEntity xuewei, 
		HttpServletRequest request){
        EntityWrapper<XueweiEntity> ew = new EntityWrapper<XueweiEntity>();

		PageUtils page = xueweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuewei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueweiEntity xuewei){
       	EntityWrapper<XueweiEntity> ew = new EntityWrapper<XueweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuewei, "xuewei")); 
        return R.ok().put("data", xueweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueweiEntity xuewei){
        EntityWrapper< XueweiEntity> ew = new EntityWrapper< XueweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuewei, "xuewei")); 
		XueweiView xueweiView =  xueweiService.selectView(ew);
		return R.ok("查询学位成功").put("data", xueweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueweiEntity xuewei = xueweiService.selectById(id);
        return R.ok().put("data", xuewei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueweiEntity xuewei = xueweiService.selectById(id);
        return R.ok().put("data", xuewei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueweiEntity xuewei, HttpServletRequest request){
    	xuewei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuewei);

        xueweiService.insert(xuewei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueweiEntity xuewei, HttpServletRequest request){
    	xuewei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuewei);

        xueweiService.insert(xuewei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueweiEntity xuewei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuewei);
        xueweiService.updateById(xuewei);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
