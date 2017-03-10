package cn.itcast.ssm.service.impl;


import cn.itcast.ssm.dao.Items;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hong-ll on 2017/3/5.
 */
@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapper itemsMapper;
    //查询所有
    public List<Items> findAll()throws Exception{
        return itemsMapper.findAll();
    }
    //根据id查询
    public Items findItemById(Integer id)throws Exception{
        return itemsMapper.findItemById(id);
    }
    public void updateItems(Integer id, Items items){
        itemsMapper.updateByPrimaryKey(items);
    }





}
