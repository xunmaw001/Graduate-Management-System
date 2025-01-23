package com.entity.view;

import com.entity.ShishengduihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 师生对话
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
@TableName("shishengduihua")
public class ShishengduihuaView  extends ShishengduihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShishengduihuaView(){
	}
 
 	public ShishengduihuaView(ShishengduihuaEntity shishengduihuaEntity){
 	try {
			BeanUtils.copyProperties(this, shishengduihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
