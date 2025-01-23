package com.dao;

import com.entity.KaojixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaojixinxiVO;
import com.entity.view.KaojixinxiView;


/**
 * 考级信息
 * 
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface KaojixinxiDao extends BaseMapper<KaojixinxiEntity> {
	
	List<KaojixinxiVO> selectListVO(@Param("ew") Wrapper<KaojixinxiEntity> wrapper);
	
	KaojixinxiVO selectVO(@Param("ew") Wrapper<KaojixinxiEntity> wrapper);
	
	List<KaojixinxiView> selectListView(@Param("ew") Wrapper<KaojixinxiEntity> wrapper);

	List<KaojixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KaojixinxiEntity> wrapper);
	
	KaojixinxiView selectView(@Param("ew") Wrapper<KaojixinxiEntity> wrapper);
	

}
