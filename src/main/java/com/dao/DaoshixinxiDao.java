package com.dao;

import com.entity.DaoshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaoshixinxiVO;
import com.entity.view.DaoshixinxiView;


/**
 * 导师信息
 * 
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface DaoshixinxiDao extends BaseMapper<DaoshixinxiEntity> {
	
	List<DaoshixinxiVO> selectListVO(@Param("ew") Wrapper<DaoshixinxiEntity> wrapper);
	
	DaoshixinxiVO selectVO(@Param("ew") Wrapper<DaoshixinxiEntity> wrapper);
	
	List<DaoshixinxiView> selectListView(@Param("ew") Wrapper<DaoshixinxiEntity> wrapper);

	List<DaoshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DaoshixinxiEntity> wrapper);
	
	DaoshixinxiView selectView(@Param("ew") Wrapper<DaoshixinxiEntity> wrapper);
	

}
