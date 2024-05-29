package edu.uestc.angel.view;

import java.util.Scanner;


public class SystemMenu implements Menu {
    private Scanner input = new Scanner(System.in);
    private static ShoppingMenu shoppingMenu = new ShoppingMenu();
    private static FeedbackMenu feedbackMenu = new FeedbackMenu();
    private static CustomerMenu customerMenu = new CustomerMenu();
    public String command;

    public String readInput() {
        return input.nextLine();
    }

    @Override
    public void displayMenu() {
        System.out.println("\t欢迎使用狗东购物管理系统");
        System.out.println("*******************************");
        System.out.println("1.客户信息管理");
        System.out.println("2.购物结算");
        System.out.println("3.真情回馈");
        System.out.println("4.注销");
        System.out.println("*******************************");
        System.out.println("请选择，输入数字：");
    }

    @Override
    public void process(String command) {
        switch (command) {
            case "1":
                do {
                    customerMenu.displayMenu();
                    command = readInput();
                    customerMenu.process(command);
                } while (!command.equals("n"));
                this.displayMenu();
                command = readInput();
                this.process(command);
                break;
            case "2":
                do {
                    shoppingMenu.displayMenu();
                    command = readInput();
                } while (!command.equals("n"));
                this.displayMenu();
                command = readInput();
                this.process(command);
                break;
            case "3":
                do {
                    feedbackMenu.displayMenu();
                    command = readInput();
                    feedbackMenu.process(command);
                } while (!command.equals("n"));
                this.displayMenu();
                command = readInput();
                this.process(command);
                break;
            case "4":
                System.out.println("注销成功");
                break;
        }
    }
}
