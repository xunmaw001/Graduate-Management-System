package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaoshiView;


/**
 * 导师
 *
 * @author 
 * @email 
 * @date 2023-04-19 21:21:17
 */
public interface DaoshiService extends IService<DaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoshiVO> selectListVO(Wrapper<DaoshiEntity> wrapper);
   	
   	DaoshiVO selectVO(@Param("ew") Wrapper<DaoshiEntity> wrapper);
   	
   	List<DaoshiView> selectListView(Wrapper<DaoshiEntity> wrapper);
   	
   	DaoshiView selectView(@Param("ew") Wrapper<DaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoshiEntity> wrapper);
   	

}

