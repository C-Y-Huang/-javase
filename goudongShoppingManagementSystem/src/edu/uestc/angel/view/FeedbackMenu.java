package edu.uestc.angel.view;

import edu.uestc.angel.pojo.Customer;
import edu.uestc.angel.service.CustomerService;
import edu.uestc.angel.service.impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FeedbackMenu implements Menu{
    private Scanner input = new Scanner(System.in);
    private CustomerService csdao = new CustomerServiceImpl();
    public String command;
    public String readInput() {
        return input.nextLine();
    }

    @Override
    public void displayMenu() {
        System.out.println("狗东购物管理系统>真情回馈");
        System.out.println("*******************************");
        System.out.println("1.幸运大放送");
        System.out.println("2.幸运抽奖");
        System.out.println("3.生日问候");
        System.out.println("*******************************");
        System.out.println("请选择,输入数字或按'n'返回上一级菜单:");
    }

    public void process(String command) {
        switch (command){
            case "1":
                do {
                    luckyBroadcast();
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "2":
                do {
                    luckyDraw();
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "3":
                do {
                    birthdayLottery();
                    command = readInput();
                }while (!command.equals("n"));
                break;
            case "n":
                break;
            default:
                System.out.println("请输入正确的选项");
        }
}

    private void luckyBroadcast() {
            System.out.println("狗东购物管理系统>幸运大放送");
            Customer higherIntegral = csdao.findHigherIntegral();
            System.out.println("具有最高积分的会员是:"+higherIntegral.getVipCard()+"\t"+higherIntegral.getBirthday()+"\t"+higherIntegral.getIntegral());
            System.out.println("恭喜！获赠礼品：价值12000.0的苹果笔记本电脑");
            System.out.println("请按'n'返回上一级菜单：");
    }
    private void luckyDraw() {
        System.out.println("狗东购物管理系统>幸运抽奖");
        System.out.print("是否开始（y/n）:");
        command = readInput();
        if (command.equals("y")){
            int id = (int) (Math.random() * csdao.count() + 1);
            System.out.println("幸运客户获赠MP3:"+ csdao.findVipcardByVipId(id));
        }
        System.out.println("请按'n'返回上一级菜单：");
    }
    private void birthdayLottery(){
        System.out.println("狗东购物管理系统>生日问候");
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 格式化日期输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        System.out.println("今天日期为:"+ formattedDate);
        dateComparison(currentDate);
        System.out.println("请按'n'返回上一级菜单：");
    }
    private void dateComparison(LocalDate currentDate) {
        boolean flag = false;
        List<Customer> all = csdao.findAll();
        for (Customer customer : all) {
            String birthday = customer.getBirthday();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
            String nowadays = currentDate.format(formatter);
            if (birthday.equals(nowadays)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("生日礼物为华为手机一部");
        } else {
            System.out.println("今天没有过生日的会员!");
        }
    }
}
