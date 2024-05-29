package edu.uestc.angel.dao.ipml;

import edu.uestc.angel.commons.JdbcHelper;
import edu.uestc.angel.dao.CustomerDao;
import edu.uestc.angel.pojo.Customer;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao {
    private JdbcHelper helper = JdbcHelper.getInstance();
    @Override
    public Customer findByVipCard(String vipCard) {
        Customer customer = null;
        try(var conn = helper.getConnection()){
            var sql = "select * from customer where vipCard = ?";
            var ptst = conn.prepareStatement(sql);
            ptst.setString(1,vipCard);
            var rs =ptst.executeQuery();
            if (rs.next()){
                customer = new Customer();
                customer.setBirthday(rs.getString("birthday"));
                customer.setIntegral(rs.getFloat("integral"));
                customer.setVipCard(rs.getString("vipCard"));
                customer.setVipId(rs.getInt("vipId"));

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try(var conn = helper.getConnection()){
            var sql = "select * from customer";
            var ptst = conn.prepareStatement(sql);
            var rs = ptst.executeQuery();
            while (rs.next()){
                customer = new Customer();
                customer.setBirthday(rs.getString("birthday"));
                customer.setIntegral(rs.getFloat("integral"));
                customer.setVipCard(rs.getString("vipCard"));
                customer.setVipId(rs.getInt("vipId"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public boolean updateByVipCard(Customer customer, String vipCard) {
        try(var conn = helper.getConnection()){
            var sql = "update customer set birthday=?,integral=?  where vipCard =?";
            var ptst = conn.prepareStatement(sql);
            ptst.setString(1,customer.getBirthday());
            ptst.setFloat(2,customer.getIntegral());
            ptst.setString(3,vipCard);
            var rs = ptst.executeUpdate();
            return rs==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer save(Customer customer) {
        Integer id = null;
        try (var conn = helper.getConnection()) {
            var sql = "insert into customer(vipCard,birthday,integral) values(?,?,?)";
            var ptst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ptst.setString(1, customer.getVipCard());
            ptst.setString(2, customer.getBirthday());
            ptst.setFloat(3, customer.getIntegral());
            ptst.executeUpdate();
            var rs = ptst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Customer findHigherIntegral() {
        Customer customer = null;
        try(var conn = helper.getConnection()){
            var sql = "select * from customer where integral = (select max(integral) from customer)";
            var ptst = conn.prepareStatement(sql);
            var rs = ptst.executeQuery();
            if (rs.next()){
                customer = new Customer();
                customer.setBirthday(rs.getString("birthday"));
                customer.setIntegral(rs.getFloat("integral"));
                customer.setVipCard(rs.getString("vipCard"));
            }
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer count() {
        try (var conn = helper.getConnection()){
            var sql = "select count(*) from customer";
            var ptst = conn.prepareStatement(sql);
            var rs = ptst.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String findVipcardByVipId(Integer vipId) {
        try (var conn = helper.getConnection()){
            var sql = "select vipCard from customer where vipId=?";
            var ptst = conn.prepareStatement(sql);
            ptst.setInt(1,vipId);
            var rs = ptst.executeQuery();
            if (rs.next()){
                return rs.getString("vipCard");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
