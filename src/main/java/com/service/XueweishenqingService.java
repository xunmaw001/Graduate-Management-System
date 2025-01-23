package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueweishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueweishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueweishenqingView;


/**
 * 学位申请
 *
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface XueweishenqingService extends IService<XueweishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueweishenqingVO> selectListVO(Wrapper<XueweishenqingEntity> wrapper);
   	
   	XueweishenqingVO selectVO(@Param("ew") Wrapper<XueweishenqingEntity> wrapper);
   	
   	List<XueweishenqingView> selectListView(Wrapper<XueweishenqingEntity> wrapper);
   	
   	XueweishenqingView selectView(@Param("ew") Wrapper<XueweishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueweishenqingEntity> wrapper);
   	

}

