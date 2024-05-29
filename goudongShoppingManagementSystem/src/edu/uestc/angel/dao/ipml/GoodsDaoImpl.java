package edu.uestc.angel.dao.ipml;

import edu.uestc.angel.commons.JdbcHelper;
import edu.uestc.angel.dao.GoodsDao;

import java.sql.SQLException;


public class GoodsDaoImpl implements GoodsDao {
    private JdbcHelper helper = JdbcHelper.getInstance();
    @Override
    public Float getPriceById(Integer id) {
        try(var conn = helper.getConnection()) {
            var sql = "select price from goods where goodsId = ?";
            var ptst = conn.prepareStatement(sql);
            ptst.setInt(1, id);
            var rs = ptst.executeQuery();
            if(rs.next()){
                return rs.getFloat("price");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String getGoodsNameById(Integer id) {
        try(var conn = helper.getConnection()) {
            var sql = "select goodsName from goods where goodsId = ?";
            var ptst = conn.prepareStatement(sql);
            ptst.setInt(1, id);
            var rs = ptst.executeQuery();
            if(rs.next()){
                return rs.getString("goodsName");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
