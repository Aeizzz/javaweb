package cn.itcast.ssm.service;


import cn.itcast.ssm.dao.Items;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hong-ll on 2017/3/5.
 */
@Service
public interface ItemsService {
    //查询所有的信息
    public List<Items> findAll() throws Exception;
    //根据id查询
    public Items findItemById(Integer id)throws Exception;

    void updateItems(Integer id, Items items);
}
