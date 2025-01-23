package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShishengduihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShishengduihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShishengduihuaView;


/**
 * 师生对话
 *
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface ShishengduihuaService extends IService<ShishengduihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShishengduihuaVO> selectListVO(Wrapper<ShishengduihuaEntity> wrapper);
   	
   	ShishengduihuaVO selectVO(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
   	
   	List<ShishengduihuaView> selectListView(Wrapper<ShishengduihuaEntity> wrapper);
   	
   	ShishengduihuaView selectView(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShishengduihuaEntity> wrapper);
   	

}

