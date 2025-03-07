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

import com.entity.XueweishenqingEntity;
import com.entity.view.XueweishenqingView;

import com.service.XueweishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 学位申请
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@RestController
@RequestMapping("/xueweishenqing")
public class XueweishenqingController {
    @Autowired
    private XueweishenqingService xueweishenqingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueweishenqingEntity xueweishenqing, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yanjiusheng")) {
			xueweishenqing.setYanjiushengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueweishenqingEntity> ew = new EntityWrapper<XueweishenqingEntity>();


		PageUtils page = xueweishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueweishenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueweishenqingEntity xueweishenqing, 
		HttpServletRequest request){
        EntityWrapper<XueweishenqingEntity> ew = new EntityWrapper<XueweishenqingEntity>();

		PageUtils page = xueweishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueweishenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueweishenqingEntity xueweishenqing){
       	EntityWrapper<XueweishenqingEntity> ew = new EntityWrapper<XueweishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueweishenqing, "xueweishenqing")); 
        return R.ok().put("data", xueweishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueweishenqingEntity xueweishenqing){
        EntityWrapper< XueweishenqingEntity> ew = new EntityWrapper< XueweishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueweishenqing, "xueweishenqing")); 
		XueweishenqingView xueweishenqingView =  xueweishenqingService.selectView(ew);
		return R.ok("查询学位申请成功").put("data", xueweishenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueweishenqingEntity xueweishenqing = xueweishenqingService.selectById(id);
        return R.ok().put("data", xueweishenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueweishenqingEntity xueweishenqing = xueweishenqingService.selectById(id);
        return R.ok().put("data", xueweishenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueweishenqingEntity xueweishenqing, HttpServletRequest request){
    	xueweishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueweishenqing);

        xueweishenqingService.insert(xueweishenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueweishenqingEntity xueweishenqing, HttpServletRequest request){
    	xueweishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueweishenqing);

        xueweishenqingService.insert(xueweishenqing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueweishenqingEntity xueweishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueweishenqing);
        xueweishenqingService.updateById(xueweishenqing);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueweishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
