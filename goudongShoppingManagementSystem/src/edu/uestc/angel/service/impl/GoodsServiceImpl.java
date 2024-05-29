package edu.uestc.angel.service.impl;

import edu.uestc.angel.dao.GoodsDao;
import edu.uestc.angel.dao.ipml.GoodsDaoImpl;
import edu.uestc.angel.service.GoodsService;


public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao = new GoodsDaoImpl();

    @Override
    public Float getPriceById(Integer id) {
        return dao.getPriceById(id);
    }

    @Override
    public String getGoodsNameById(Integer id) {
        return dao.getGoodsNameById(id);
    }
}
