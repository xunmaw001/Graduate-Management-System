package com.dao;

import com.entity.ShishengduihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShishengduihuaVO;
import com.entity.view.ShishengduihuaView;


/**
 * 师生对话
 * 
 * @author 
 * @email 
 * @date 2023-04-19 21:21:18
 */
public interface ShishengduihuaDao extends BaseMapper<ShishengduihuaEntity> {
	
	List<ShishengduihuaVO> selectListVO(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
	
	ShishengduihuaVO selectVO(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
	
	List<ShishengduihuaView> selectListView(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);

	List<ShishengduihuaView> selectListView(Pagination page,@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
	
	ShishengduihuaView selectView(@Param("ew") Wrapper<ShishengduihuaEntity> wrapper);
	

}
