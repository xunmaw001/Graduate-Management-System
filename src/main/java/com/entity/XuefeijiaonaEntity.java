package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 学费缴纳
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@TableName("xuefeijiaona")
public class XuefeijiaonaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XuefeijiaonaEntity() {
		
	}
	
	public XuefeijiaonaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 缴费单号
	 */
					
	private String jiaofeidanhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：缴费单号
	 */
	public void setJiaofeidanhao(String jiaofeidanhao) {
		this.jiaofeidanhao = jiaofeidanhao;
	}
	/**
	 * 获取：缴费单号
	 */
	public String getJiaofeidanhao() {
		return jiaofeidanhao;
	}
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
