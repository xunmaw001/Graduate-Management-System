package com.entity.model;

import com.entity.XuefeijiaonaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 学费缴纳
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public class XuefeijiaonaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 学期
	 */
	
	private String xueqi;
		
	/**
	 * 学费
	 */
	
	private String xuefei;
		
	/**
	 * 录入时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date lurushijian;
		
	/**
	 * 研究生账号
	 */
	
	private String yanjiushengzhanghao;
		
	/**
	 * 研究生姓名
	 */
	
	private String yanjiushengxingming;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：学期
	 */
	 
	public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
	}
	
	/**
	 * 获取：学期
	 */
	public String getXueqi() {
		return xueqi;
	}
				
	
	/**
	 * 设置：学费
	 */
	 
	public void setXuefei(String xuefei) {
		this.xuefei = xuefei;
	}
	
	/**
	 * 获取：学费
	 */
	public String getXuefei() {
		return xuefei;
	}
				
	
	/**
	 * 设置：录入时间
	 */
	 
	public void setLurushijian(Date lurushijian) {
		this.lurushijian = lurushijian;
	}
	
	/**
	 * 获取：录入时间
	 */
	public Date getLurushijian() {
		return lurushijian;
	}
				
	
	/**
	 * 设置：研究生账号
	 */
	 
	public void setYanjiushengzhanghao(String yanjiushengzhanghao) {
		this.yanjiushengzhanghao = yanjiushengzhanghao;
	}
	
	/**
	 * 获取：研究生账号
	 */
	public String getYanjiushengzhanghao() {
		return yanjiushengzhanghao;
	}
				
	
	/**
	 * 设置：研究生姓名
	 */
	 
	public void setYanjiushengxingming(String yanjiushengxingming) {
		this.yanjiushengxingming = yanjiushengxingming;
	}
	
	/**
	 * 获取：研究生姓名
	 */
	public String getYanjiushengxingming() {
		return yanjiushengxingming;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
