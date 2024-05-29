package edu.uestc.angel.service;

import edu.uestc.angel.pojo.Customer;

import java.util.List;


public interface CustomerService {

    Customer findByVipCard(String vipCard);

    List<Customer> findAll();
    boolean updateByVipCard(Customer customer, String vipCard);
    Integer save(Customer customer);
    Customer findHigherIntegral();
    Integer count();
    String findVipcardByVipId(Integer vipId);
}
