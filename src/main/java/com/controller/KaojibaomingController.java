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

import com.entity.KaojibaomingEntity;
import com.entity.view.KaojibaomingView;

import com.service.KaojibaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 考级报名
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/kaojibaoming")
public class KaojibaomingController {
    @Autowired
    private KaojibaomingService kaojibaomingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaojibaomingEntity kaojibaoming, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yanjiusheng")) {
			kaojibaoming.setYanjiushengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaojibaomingEntity> ew = new EntityWrapper<KaojibaomingEntity>();


		PageUtils page = kaojibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaojibaoming), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaojibaomingEntity kaojibaoming, 
		HttpServletRequest request){
        EntityWrapper<KaojibaomingEntity> ew = new EntityWrapper<KaojibaomingEntity>();

		PageUtils page = kaojibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaojibaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaojibaomingEntity kaojibaoming){
       	EntityWrapper<KaojibaomingEntity> ew = new EntityWrapper<KaojibaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaojibaoming, "kaojibaoming")); 
        return R.ok().put("data", kaojibaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaojibaomingEntity kaojibaoming){
        EntityWrapper< KaojibaomingEntity> ew = new EntityWrapper< KaojibaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaojibaoming, "kaojibaoming")); 
		KaojibaomingView kaojibaomingView =  kaojibaomingService.selectView(ew);
		return R.ok("查询考级报名成功").put("data", kaojibaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaojibaomingEntity kaojibaoming = kaojibaomingService.selectById(id);
        return R.ok().put("data", kaojibaoming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaojibaomingEntity kaojibaoming = kaojibaomingService.selectById(id);
        return R.ok().put("data", kaojibaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaojibaomingEntity kaojibaoming, HttpServletRequest request){
    	kaojibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaojibaoming);

        kaojibaomingService.insert(kaojibaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaojibaomingEntity kaojibaoming, HttpServletRequest request){
    	kaojibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaojibaoming);

        kaojibaomingService.insert(kaojibaoming);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaojibaomingEntity kaojibaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaojibaoming);
        kaojibaomingService.updateById(kaojibaoming);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaojibaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
