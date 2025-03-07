package com.entity.model;

import com.entity.KaojixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 考级信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public class KaojixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 考级级别
	 */
	
	private String kaojijibie;
		
	/**
	 * 价格
	 */
	
	private String jiage;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 报名须知
	 */
	
	private String baomingxuzhi;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
				
	
	/**
	 * 设置：考级级别
	 */
	 
	public void setKaojijibie(String kaojijibie) {
		this.kaojijibie = kaojijibie;
	}
	
	/**
	 * 获取：考级级别
	 */
	public String getKaojijibie() {
		return kaojijibie;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public String getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：报名须知
	 */
	 
	public void setBaomingxuzhi(String baomingxuzhi) {
		this.baomingxuzhi = baomingxuzhi;
	}
	
	/**
	 * 获取：报名须知
	 */
	public String getBaomingxuzhi() {
		return baomingxuzhi;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
			
}
