package edu.uestc.angel.service.impl;

import edu.uestc.angel.dao.CustomerDao;
import edu.uestc.angel.dao.ipml.CustomerDaoImpl;
import edu.uestc.angel.pojo.Customer;
import edu.uestc.angel.service.CustomerService;

import java.util.List;


public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();
    @Override
    public Customer findByVipCard(String vipCard) {
        return dao.findByVipCard(vipCard);
    }

    @Override
    public List<Customer> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean updateByVipCard(Customer customer, String vipCard) {
        return dao.updateByVipCard(customer,vipCard);
    }

    @Override
    public Integer save(Customer customer) {
        return dao.save(customer);
    }

    @Override
    public Customer findHigherIntegral() {
        return dao.findHigherIntegral();
    }

    @Override
    public Integer count() {
        return dao.count();
    }

    @Override
    public String findVipcardByVipId(Integer vipId) {
        return dao.findVipcardByVipId(vipId);
    }
}
