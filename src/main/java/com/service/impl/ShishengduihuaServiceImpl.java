package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShishengduihuaDao;
import com.entity.ShishengduihuaEntity;
import com.service.ShishengduihuaService;
import com.entity.vo.ShishengduihuaVO;
import com.entity.view.ShishengduihuaView;

@Service("shishengduihuaService")
public class ShishengduihuaServiceImpl extends ServiceImpl<ShishengduihuaDao, ShishengduihuaEntity> implements ShishengduihuaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShishengduihuaEntity> page = this.selectPage(
                new Query<ShishengduihuaEntity>(params).getPage(),
                new EntityWrapper<ShishengduihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShishengduihuaEntity> wrapper) {
		  Page<ShishengduihuaView> page =new Query<ShishengduihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShishengduihuaVO> selectListVO(Wrapper<ShishengduihuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShishengduihuaVO selectVO(Wrapper<ShishengduihuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShishengduihuaView> selectListView(Wrapper<ShishengduihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShishengduihuaView selectView(Wrapper<ShishengduihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
