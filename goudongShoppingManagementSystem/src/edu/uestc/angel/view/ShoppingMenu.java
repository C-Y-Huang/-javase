package edu.uestc.angel.view;

import edu.uestc.angel.dao.ipml.GoodsDaoImpl;
import edu.uestc.angel.pojo.Customer;
import edu.uestc.angel.pojo.Goods;
import edu.uestc.angel.pojo.Inventory;
import edu.uestc.angel.service.CustomerService;
import edu.uestc.angel.service.GoodsService;
import edu.uestc.angel.service.impl.CustomerServiceImpl;
import edu.uestc.angel.service.impl.GoodsServiceImpl;

import java.util.*;


public class ShoppingMenu implements Menu{
    private Scanner input = new Scanner(System.in);
    public String readInput() {
        return input.nextLine();
    }
    private  List<Inventory> goodsList = new ArrayList<>();

    private Map<String,Inventory> map = new HashMap<>();
     GoodsService goodsService= new GoodsServiceImpl();
     CustomerService customerService = new CustomerServiceImpl();
     int count = 0;
     float price = 0;
     float allPrice = 0;//总共的价钱
     float goodsPrice = 0;//总共的价钱
     float discount = 1;//折扣
     String vipCard;
    private void consumptionList(){

            System.out.println("************消费清单************");
            System.out.println("物品\t\t单价\t\t个数\t\t金额");
            for (Inventory value : goodsList) {
                System.out.println(value.getGoodsName()+"\t\t"+value.getPrice()+"\t\t"+map.get(value.getGoodsName()).getCount() + "\t\t" + map.get(value.getGoodsName()).getAllPrice());
            }
            if (allPrice>500000){
                discount = 0.7f;
            }else if (allPrice>200000){
                discount = 0.75f;
            }else if (allPrice>100000){
                discount = 0.8f;
            }else if (allPrice>50000){
                discount = 0.85f;
            }else if (allPrice>10000){
                discount = 0.9f;
            }else {
                discount = 0.95f;
            }
            System.out.println("折扣："+discount);
            System.out.println("金额总价"+allPrice*discount);
            System.out.print("实际交费:");
            float money = Float.parseFloat(readInput());
            System.out.println(money);
            System.out.println("找钱："+(money-allPrice*discount));
            float integral =  allPrice*discount*0.03f;
            System.out.println("本次购物所获的积分是："+integral);
            Customer cs = customerService.findByVipCard(vipCard);
            cs.setIntegral(cs.getIntegral()+integral);
            customerService.updateByVipCard(cs,vipCard);
            System.out.print("请按'n'返回上一级菜单:");

    }

    @Override
    public void displayMenu() {
        System.out.println("狗东购物管理系统>购物结算");
        System.out.println("*******************************");
        System.out.println("1.Rolex劳力士(￥180000.00)");
        System.out.println("2.IWC葡计（￥80000.00）");
        System.out.println("3.Longines月相（￥27800.00）");
        System.out.println("4.Omega（￥42078.00）");
        System.out.println("5.百达翡丽（￥24500000.00）");
        System.out.println("6.江诗丹顿（￥450000.00）");
        System.out.println("7.小天才电话手表（￥1900.00）");
        System.out.println("*******************************");
        System.out.print("请输入会员号：");
        vipCard = readInput();
        while (customerService.findByVipCard(vipCard)==null||(!Objects.equals(customerService.findByVipCard(vipCard).getVipCard(), vipCard))){
            System.out.println("重新输入");
            vipCard = readInput();
        }
        process("");
        consumptionList();
    }

    @Override
    public void process(String command) {
        do {
            System.out.println("请输入商品编号：");
            command =readInput();
            Inventory inventory = new Inventory();
            inventory.setGoodsId(Integer.parseInt(command));
            inventory.setGoodsName(goodsService.getGoodsNameById(Integer.parseInt(command)));
            inventory.setPrice(goodsService.getPriceById(Integer.parseInt(command)));
            System.out.println("请输入数目：");
            command = readInput();
            count = Integer.parseInt(command);
            price = inventory.getPrice()*count;
            goodsPrice += price;
            inventory.setCount(count);
            inventory.setAllPrice(goodsPrice);
            if(map.get(inventory.getGoodsName()) == null){
                map.put(inventory.getGoodsName(),inventory);
            }else {
                int newCount = map.get(inventory.getGoodsName()).getCount()+count;
                inventory.setCount(newCount);
                map.put(inventory.getGoodsName(),inventory);
            }
            goodsList.add(inventory);
            System.out.println(goodsList);
            System.out.println("是否继续（y/n）：");
            allPrice+=goodsPrice;
            goodsPrice = 0;
        }while (readInput().equals("y"));
    }
}