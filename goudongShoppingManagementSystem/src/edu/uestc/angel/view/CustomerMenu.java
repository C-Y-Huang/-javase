package edu.uestc.angel.view;

import edu.uestc.angel.pojo.Customer;
import edu.uestc.angel.service.CustomerService;
import edu.uestc.angel.service.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu implements Menu{

    private Scanner input = new Scanner(System.in);
    private CustomerService customerService =new CustomerServiceImpl();
    Customer customer = null;

    public String readInput() {
        return input.nextLine();
    }
    @Override
    public void displayMenu() {
        System.out.println("狗东购物管理系统>客户信息管理");
        System.out.println("*******************************");
        System.out.println("1.显示所有客户信息");
        System.out.println("2.添加客户信息");
        System.out.println("3.修改客户信息");
        System.out.println("4.查询客户信息");
        System.out.println("*******************************");
        System.out.println("请选择，输入数字或按'n'返回上一级菜单：");
    }

    @Override
    public void process(String command) {
            switch (command){
            case "1":
                do{
                System.out.println("狗东购物管理系统 > 客户信息管理 > 显示客户信息");
                System.out.println("会员号\t\t生日\t\t积分");
                List<Customer> all = customerService.findAll();
                for (Customer customer : all) {
                    System.out.println(customer.getVipCard()+"\t\t"+customer.getBirthday()+"\t\t"+customer.getIntegral());
                }
                System.out.print("请按'n'返回上一级菜单:");
                command = readInput();
                }while (!command.equals("n"));
                break;
            case "2":
                do {
                    System.out.println("狗东购物管理系统 > 客户信息管理 > 添加客户信息");
                    customer = new Customer();
                    System.out.println("输入VipCard:");
                    customer.setVipCard(readInput());
                    System.out.println("输入birthday(格式01/01):");
                    customer.setBirthday(readInput());
                    System.out.println("输入积分:");
                    customer.setIntegral(Float.parseFloat(readInput()));
                    System.out.println(customerService.save(customer));
                    System.out.println("请按'n'返回上一级菜单:");
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "3":
                do {
                    System.out.println("狗东购物管理系统 > 客户信息管理 > 修改客户信息");
                    System.out.println("请输入要修改的客户的vipCard");
                    String vipCard = readInput();
                    customer = new Customer();
                    System.out.println("请输入生日");
                    String birthday = readInput();
                    customer.setBirthday(birthday);
                    System.out.println("请输入积分");
                    float integral = Float.parseFloat(readInput());
                    customer.setIntegral(integral);
                    System.out.println(customerService.updateByVipCard(customer,vipCard));
                    System.out.println("请按'n'返回上一级菜单:");
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "4":
                do {
                    System.out.println("狗东购物管理系统 > 客户信息管理 > 查询客户信息");
                    System.out.println("请输入要查询的客户的vipCard");
                    System.out.println(customerService.findByVipCard(readInput()));
                    System.out.println("请按'n'返回上一级菜单:");
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "n":
                break;
            }
    }
}
