package com.entity.view;

import com.entity.DaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 导师
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-19 21:21:17
 */
@TableName("daoshi")
public class DaoshiView  extends DaoshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DaoshiView(){
	}
 
 	public DaoshiView(DaoshiEntity daoshiEntity){
 	try {
			BeanUtils.copyProperties(this, daoshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
