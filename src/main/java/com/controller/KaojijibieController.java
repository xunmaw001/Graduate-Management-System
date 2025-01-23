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

import com.entity.KaojijibieEntity;
import com.entity.view.KaojijibieView;

import com.service.KaojijibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 考级级别
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/kaojijibie")
public class KaojijibieController {
    @Autowired
    private KaojijibieService kaojijibieService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaojijibieEntity kaojijibie, 
		HttpServletRequest request){

        EntityWrapper<KaojijibieEntity> ew = new EntityWrapper<KaojijibieEntity>();


		PageUtils page = kaojijibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaojijibie), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaojijibieEntity kaojijibie, 
		HttpServletRequest request){
        EntityWrapper<KaojijibieEntity> ew = new EntityWrapper<KaojijibieEntity>();

		PageUtils page = kaojijibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaojijibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaojijibieEntity kaojijibie){
       	EntityWrapper<KaojijibieEntity> ew = new EntityWrapper<KaojijibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaojijibie, "kaojijibie")); 
        return R.ok().put("data", kaojijibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaojijibieEntity kaojijibie){
        EntityWrapper< KaojijibieEntity> ew = new EntityWrapper< KaojijibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaojijibie, "kaojijibie")); 
		KaojijibieView kaojijibieView =  kaojijibieService.selectView(ew);
		return R.ok("查询考级级别成功").put("data", kaojijibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaojijibieEntity kaojijibie = kaojijibieService.selectById(id);
        return R.ok().put("data", kaojijibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaojijibieEntity kaojijibie = kaojijibieService.selectById(id);
        return R.ok().put("data", kaojijibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaojijibieEntity kaojijibie, HttpServletRequest request){
    	kaojijibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaojijibie);

        kaojijibieService.insert(kaojijibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaojijibieEntity kaojijibie, HttpServletRequest request){
    	kaojijibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaojijibie);

        kaojijibieService.insert(kaojijibie);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaojijibieEntity kaojijibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaojijibie);
        kaojijibieService.updateById(kaojijibie);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaojijibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
