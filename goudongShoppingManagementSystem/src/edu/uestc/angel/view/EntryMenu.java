package edu.uestc.angel.view;

import edu.uestc.angel.pojo.Administrators;

import java.util.Scanner;


public class EntryMenu implements Menu{
    private static SystemMenu systemMenu = new SystemMenu() ;
    private Scanner input = new Scanner(System.in);
    private Administrators administrators = new Administrators();
    public String readInput(){
        return input.nextLine();
    }

    @Override
    public void displayMenu() {
        System.out.println("\t欢迎使用狗东购物管理系统1.0版");
        System.out.println("***************************************");
        System.out.println("1.登录系统");
        System.out.println("2.更改管理员密码");
        System.out.println("3.退出");
        System.out.println("请选择，输入数字：");
    }

    @Override
    public void process(String command){
        switch (command){
            case "1":
                System.out.println("请输入用户名：");
                String loginAdmin = readInput();
                System.out.println("请输入密码：");
                String loginPassword = readInput();
                if(loginAdmin.equals(administrators.getAdmin())&&loginPassword.equals(administrators.getPassword())){
                    systemMenu.displayMenu();
                    command = systemMenu.readInput();
                    systemMenu.process(command);
                }break;
            case "2":
                System.out.println("请输入用户名：");
                String admin = readInput();
                administrators.setAdmin(admin);
                System.out.println("请输入密码：");
                String password = readInput();
                administrators.setPassword(password);break;
            case "3":break;
        }
}
}
