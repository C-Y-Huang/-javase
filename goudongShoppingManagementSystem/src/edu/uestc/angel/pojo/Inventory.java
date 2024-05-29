package edu.uestc.angel.pojo;


public class Inventory extends Goods{
   private int count;
   private float allPrice;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(float allPrice) {
        this.allPrice = allPrice;
    }





    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + getGoodsId() +
                ", name='" + getGoodsName() +
                ", price=" + getPrice() +
                "count=" + count +
                ", price=" + allPrice +
                '}';
    }
}
