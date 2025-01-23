package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueweiView;


/**
 * 学位
 *
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface XueweiService extends IService<XueweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueweiVO> selectListVO(Wrapper<XueweiEntity> wrapper);
   	
   	XueweiVO selectVO(@Param("ew") Wrapper<XueweiEntity> wrapper);
   	
   	List<XueweiView> selectListView(Wrapper<XueweiEntity> wrapper);
   	
   	XueweiView selectView(@Param("ew") Wrapper<XueweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueweiEntity> wrapper);
   	

}

